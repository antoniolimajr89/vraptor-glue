package br.com.caelum.vraptor.glue;

import static br.com.caelum.vraptor.glue.Glue.get;
import static br.com.caelum.vraptor.glue.Glue.put;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.validator.Validator;

@Intercepts(before = Glueing.class)
public class Validators {

	Validators(Validator result) {
		put(Validator.class, result);
	}

	public static Validator validator() {
		return get(Validator.class);
	}

}
