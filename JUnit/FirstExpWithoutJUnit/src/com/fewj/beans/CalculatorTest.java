package com.fewj.beans;

public class CalculatorTest {
	
	Calculator cal = null;
	static int a = 10;
	static int b = 20;

	

	public void testAdd() throws Exception {
		int expectedSum = 30;
		int sum = cal.add(a, b);
		if (sum != expectedSum) {
			throw new Exception("add() has returned in-correct output");
		}
	}

	public void testMultiply() throws Exception {
		int expectedMultiply = 200;

		int multiply = cal.multiply(a, b);
		if (multiply != expectedMultiply) {
			throw new Exception("multiply() has returned in-correct output");
		}

	}

}
