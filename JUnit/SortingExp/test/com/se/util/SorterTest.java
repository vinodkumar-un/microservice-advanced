package com.se.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {
	private Integer[] data;
	private Filter filter;
	private Sorter sorter;
	private Integer[] expectedData;

	@Before
	public void setUp() {
		data = new Integer[] { 10, 12, 1, 4, 10, 12 };
		expectedData = new Integer[] { 1, 4, 10, 12 };
		filter = new MockBasicFilter();
		sorter = new Sorter(filter);
	}

	@Test
	public void testSort() {
		Integer[] actualData = null;

		actualData = sorter.sort(data);
		Assert.assertArrayEquals(expectedData, actualData);
	}
}
