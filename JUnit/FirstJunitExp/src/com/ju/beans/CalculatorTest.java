package com.ju.beans;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
	private Calculator cal;
	private int a;
	private int b;

	@Override
	protected void setUp() throws Exception {
		System.out.println("setUp()");
		cal = new Calculator();
		a = 10;
		b = 20;
	}

	public void testAdd() {
		int expectedSum = 20;
		int actualSum = 0;

		actualSum = cal.add(a, b);

		Assert.assertEquals("Sum is in-correct", expectedSum, actualSum);
	}

	public void testMultiply() {
		int expectedMultiply = 200;
		int actualMultiply = 0;

		actualMultiply = cal.multiply(a, b);
		Assert.assertEquals(expectedMultiply, actualMultiply);
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("tearDown()");
		cal = null;
		a = 0;
		b = 0;
	}

}
