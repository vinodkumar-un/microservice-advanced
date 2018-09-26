package com.ll.util;

import org.apache.log4j.Logger;

public class Calculator {
	private static Logger logger = Logger.getRootLogger();

	public int add(int a, int b) {
		logger.trace("entered");
		int sum = 0;

		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
		
		logger.debug("a: " + a);
		logger.debug("b : " + b);

		sum = a + b;
		logger.debug("sum : " + sum);
		
		logger.trace("exiting");
		return sum;

	}
}
