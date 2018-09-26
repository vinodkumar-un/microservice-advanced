package com.av.util;

import java.util.Properties;

public class SystemProperties {
	public static void main(String[] args) {
		Properties props = System.getProperties();
		for(Object key : props.keySet()) {
			System.out.println("key : " + key + " value:  " + props.getProperty((String)key));
		}
	}
}
