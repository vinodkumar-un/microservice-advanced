package com.aa.util;

public class Math {
	private static Logger logger = Logger.getLogger(Math.class.getName());

	public long power(int base, int expo) {
		logger.trace("entered");
		long p = 1;

		for (int i = 0; i < expo; i++) {
			p *= base;
			logger.debug("pow(" + base + "," + (i + 1) + ") : " + p);
		}

		logger.trace("exiting");
		return p;
	}
}
