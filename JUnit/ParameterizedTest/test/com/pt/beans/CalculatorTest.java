package com.pt.beans;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTest {
	private int a;
	private int b;
	private int expected;
	private Calculator calc;

	public CalculatorTest(int[] parameters) {
		this.a = parameters[0];
		this.b = parameters[1];
		this.expected = parameters[2];
	}

	@Parameters
	public static Collection<int[]> getParameters() {
		return Arrays.asList(new int[][] { { 1, 2, 3 }, { 4, 5, 9 } });
	}

	@Before
	public void setUp() {
		calc = new Calculator();
	}

	@Test
	public void testAdd() {
		Assert.assertEquals(expected, calc.add(a, b));
	}

	@After
	public void cleanUp() {
		calc = null;
	}
}
