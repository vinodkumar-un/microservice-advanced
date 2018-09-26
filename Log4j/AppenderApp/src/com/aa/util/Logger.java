package com.aa.util;

public class Logger {
	private static Logger logger = new Logger();
	private static org.apache.log4j.Logger log4jLogger;

	public static Logger getLogger(String name) {
		log4jLogger = org.apache.log4j.Logger.getLogger(name);
		return logger;
	}

	public void info(Object message) {
		log4jLogger.info(message);
	}

	public void debug(Object message) {
		log4jLogger.debug(message);
	}

	public void trace(Object message) {
		log4jLogger.trace(message);
	}
}
