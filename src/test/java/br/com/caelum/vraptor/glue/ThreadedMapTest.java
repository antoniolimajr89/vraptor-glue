package br.com.caelum.vraptor.glue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ThreadedMapTest {

	private ThreadedMap map;

	@Before
	public void setup() {
		this.map = new ThreadedMap();
	}

	@Test
	public void shouldReturnNullIfNothingFoundForIt() {
		String result = map.get(String.class);
		String expected = null;
		assertEquals(expected, result);
	}

	@Test
	public void shouldReturnNullAfterCleaning() {
		map.put(String.class, "glue");
		map.resetThread();
		String result = map.get(String.class);
		String expected = null;
		assertEquals(expected, result);
	}

	@Test
	public void shouldReturnARegisteredValue() {
		map.put(String.class, "glue");
		String result = map.get(String.class);
		String expected = "glue";
		assertEquals(expected, result);
	}

	@Test
	public void shouldReturnOverridenRegisteredValue() {
		map.put(String.class, "glue");
		map.put(String.class, "glue-2.0");
		String result = map.get(String.class);
		String expected = "glue-2.0";
		assertEquals(expected, result);
	}

	@Test
	public void shouldSupportMultipleTypes() {
		map.put(String.class, "glue");
		map.put(Integer.class, Integer.MAX_VALUE);

		{
			String result = map.get(String.class);
			String expected = "glue";
			assertEquals(expected, result);
		}
		{
			Integer result = map.get(Integer.class);
			Integer expected = Integer.MAX_VALUE;
			assertEquals(expected, result);
		}
	}

}
