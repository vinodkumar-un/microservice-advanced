package com.rl.util;

import org.apache.log4j.BasicConfigurator;


public class Test {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		A a = new A();
		B b = new B();
		a.m1();
		a.m1();
	}
}




