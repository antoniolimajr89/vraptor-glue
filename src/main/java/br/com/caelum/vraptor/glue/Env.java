package br.com.caelum.vraptor.glue;

import static br.com.caelum.vraptor.glue.Glue.get;
import static br.com.caelum.vraptor.glue.Glue.put;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.environment.Environment;

@Intercepts(before = Glueing.class)
public class Env {

	Env(Environment result) {
		put(Environment.class, result);
	}

	public static Environment env() {
		return get(Environment.class);
	}

}
