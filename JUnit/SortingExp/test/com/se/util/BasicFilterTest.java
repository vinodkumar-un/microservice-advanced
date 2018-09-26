package com.se.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicFilterTest {
	private Filter filter;
	private Integer[] data;
	private Integer[] expectedFilterData;

	@Before
	public void setUp() {
		filter = new BasicFilter();
		data = new Integer[] { 10, 12, 1, 10, 2, 12 };
		expectedFilterData = new Integer[] { 10, 12, 1, 2 };
	}

	@Test
	public void testRemoveDuplicates() {
		Integer[] actualFilterData = null;

		actualFilterData = filter.removeDuplicates(data);
		Assert.assertArrayEquals(expectedFilterData, actualFilterData);
	}

	@After
	public void cleanUp() {
		filter = null;
	}

}
