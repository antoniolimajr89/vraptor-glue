package br.com.caelum.vraptor.glue;

/**
 * Public static holder for one single threadlocal map.
 * 
 * @author guilherme silveira
 */
public class Glue {

	private static final ThreadedMap INSTANCES = new ThreadedMap();

	public static <S> void put(Class<S> type, S s) {
		INSTANCES.put(type, s);
	}

	public static <T> T get(Class<T> type) {
		return (T) INSTANCES.get(type);
	}

	/**
	 * Resets the threadlocal content after it has been fully used.
	 */
	static void resetThread() {
		INSTANCES.resetThread();
	}

}
