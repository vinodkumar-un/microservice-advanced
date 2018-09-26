package com.ll.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.ll.util.Calculator;

public class CalculatorTest {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.OFF);

		Calculator cal = new Calculator();
		int sum = cal.add(10, 20);
		System.out.println("Sum : " + sum);
	}
}
