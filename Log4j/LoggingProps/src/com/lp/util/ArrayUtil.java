package com.lp.util;

import org.apache.log4j.Logger;

public class ArrayUtil {
	private Logger logger = Logger.getRootLogger();

	public long add(int[] input) {
		logger.trace("entered()");
		int sum = 0;

		logger.info("start of for loop");
		for (int i = 0; i < input.length; i++) {
			logger.debug("input[" + i + "]" + input[i]);
			sum += input[i];
		}
		logger.info("end of for loop");
		logger.debug("sum : " + sum);

		logger.trace("exiting()");
		return sum;
	}
}
