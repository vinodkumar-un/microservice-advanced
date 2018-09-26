package com.uct.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	public void print() throws IOException {
		Properties props = null;

		props = new Properties();
		props.load(this.getClass().getClassLoader()
				.getResourceAsStream("app.properties"));
		for (Object key : props.keySet()) {
			System.out.println("key : " + key + " value: "
					+ props.getProperty((String) key));
		}
	}
}
