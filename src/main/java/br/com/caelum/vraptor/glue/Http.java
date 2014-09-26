package br.com.caelum.vraptor.glue;

import static br.com.caelum.vraptor.glue.Glue.get;
import static br.com.caelum.vraptor.glue.Glue.put;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Intercepts;

/**
 * Static access to http servlet request and response.
 * 
 * @author guilherme silveira
 */
@Intercepts(before = Glueing.class)
public class Http {
	Http(HttpServletRequest req, HttpServletResponse res) {
		put(HttpServletRequest.class, req);
		put(HttpServletResponse.class, res);
	}

	public static HttpServletRequest request() {
		return get(HttpServletRequest.class);
	}

	public static HttpServletResponse response() {
		return get(HttpServletResponse.class);
	}

}
