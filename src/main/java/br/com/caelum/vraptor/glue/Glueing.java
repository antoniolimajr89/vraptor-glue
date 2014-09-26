package br.com.caelum.vraptor.glue;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

/**
 * A threaded interceptor that clears the thread local map pool after a request
 * is finished.
 * 
 * @author guilherme silveira
 */
@Intercepts
@RequestScoped
public class Glueing {

	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		try {
			stack.next();
		} finally {
			Glue.resetThread();
		}
	}

}
