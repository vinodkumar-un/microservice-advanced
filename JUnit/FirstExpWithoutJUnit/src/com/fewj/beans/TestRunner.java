package com.fewj.beans;

public class TestRunner {
	public static void main(String[] args) throws Exception {
		CalculatorTest ct = new CalculatorTest();
		int errors = 0;
		int success = 0;

		try {
			ct.testAdd();
			success++;
		} catch (Exception e) {
			errors++;
		}

		try {
			ct.testMultiply();
			success++;
		} catch (Exception e) {
			errors++;
		}
		System.out.println("errors : " + errors + " success " + success);
	}
}
