package com.wcp.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator calc;
	private int a;
	private int b;
	private int expectedSum;

	@Before
	public void setUp() {
		calc = new Calculator();
		a = 10;
		b = 20;
		expectedSum = 20;
	}

	@Test
	public void testAdd() {
		int actualSum = 0;

		actualSum = calc.add(a, b);
		Assert.assertEquals(expectedSum, actualSum);
	}

	@After
	public void clean() {
		calc = null;
	}
}
