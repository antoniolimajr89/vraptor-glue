package br.com.caelum.vraptor.glue;

import static br.com.caelum.vraptor.glue.Glue.get;
import static br.com.caelum.vraptor.glue.Glue.put;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.View;

@Intercepts(before = Glueing.class)
public class Resulter {

	Resulter(Result result) {
		put(Result.class, result);
	}

	public static <T extends View> T use(Class<T> type) {
		return result().use(type);
	}

	public static Result result() {
		return get(Result.class);
	}

}
