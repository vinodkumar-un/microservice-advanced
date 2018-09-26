package com.ts.beans;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator calc;
	private int a;
	private int b;
	private int expectedSubs;
	
	@Before
	public void setUp() {
		calc = new Calculator();
		a = 10;
		b = 20;
		expectedSubs = 10;
	}
	
	@Test
	public void testSubstract() {
		int actual = calc.substract(a, b);
		assertEquals(expectedSubs, actual);
	}
	
	@After
	public void clear() {
		calc = null;
	}
}
