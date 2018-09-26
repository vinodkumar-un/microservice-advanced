package com.ts.beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MathCalculatorTest {
	private MathCalculator mCalc;
	private int a;
	private int b;
	private int expectedSum;

	@Before
	public void setUp() {
		mCalc = new MathCalculator();
		a = 10;
		b = 20;
		expectedSum = 30;
	}

	@Test
	public void testAdd() {
		int actual = mCalc.add(a, b);
		Assert.assertEquals(expectedSum, actual);
	}
}
