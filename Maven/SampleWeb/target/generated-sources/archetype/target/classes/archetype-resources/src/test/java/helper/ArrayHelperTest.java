#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.helper;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayHelperTest {
	private ArrayHelper arrayHelper;
	private int[] input;
	private int[] expected;

	@Before
	public void setup() {
		arrayHelper = new ArrayHelper();
		input = new int[] { 1, 2, 3, 4, 5 };
		expected = new int[] { 5, 4, 3, 2, 1 };
	}

	@Test
	public void testReverse() throws Exception {
		int[] actual = null;

		actual = arrayHelper.reverse(input);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void testReverseException() throws Exception {
		arrayHelper.reverse(null);
	}

	@After
	public void clean() {
		arrayHelper = null;
	}
}
