package com.ju.beans;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Calculator4Test {
	private Calculator cal;
	private int a;
	private int b;

	@Before
	public void prepare() {
		System.out.println("prepare()");
		cal = new Calculator();
		a = 10;
		b = 20;
	}

	@Test
	public void testAdd() {
		int expectedSum = 30;
		int actualSum = 0;

		actualSum = cal.add(a, b);
		Assert.assertSame(expectedSum, actualSum);
	}

	@Test
	public void testMultiply() {
		int expectedMultiply = 200;
		int actualMultiply = 0;

		actualMultiply = cal.multiply(a, b);
		Assert.assertEquals(expectedMultiply, actualMultiply);
	}

	@After
	public void cleanUp() {
		System.out.println("cleanUp()");
		cal = null;
		a = 0;
		b = 0;
	}
}
