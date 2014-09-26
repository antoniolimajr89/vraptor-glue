package br.com.caelum.vraptor.glue;

import java.util.HashMap;
import java.util.Map;

/**
 * A thread local that contains a map. A typical application will have only one
 * of those per classloader-wide-scope, but you are free to have more than one.
 * 
 * @author guilherme silveira
 */
class ThreadedMap {

	/**
	 * All instances for all threads
	 */
	private final ThreadLocal<Map<Class<?>, Object>> instances = new ThreadLocal<>();

	/**
	 * Clears everything for this thread.
	 */
	void resetThread() {
		instances.remove();
	}

	/**
	 * Registers an instance for this type in this thread
	 */
	<S> void put(Class<S> type, S s) {
		map().put(type, s);
	}

	/**
	 * Returns an instance for this thread and this type, or null if nothing
	 * found.
	 */
	@SuppressWarnings("unchecked")
	<S> S get(Class<S> type) {
		return (S) map().get(type);
	}

	private Map<Class<?>, Object> map() {
		if (instances.get() == null)
			instances.set(new HashMap<Class<?>, Object>());
		return instances.get();
	}

}
