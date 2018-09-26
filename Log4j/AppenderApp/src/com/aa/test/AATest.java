package com.aa.test;

import java.io.FileNotFoundException;

import org.apache.log4j.xml.DOMConfigurator;

import com.aa.util.Math;

public class AATest {
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * PropertyConfigurator .configure(new FileInputStream(
		 * "D:\\WorkShop\\Trainings\\02042015\\Tools\\Log4j\\AppenderApp\\src\\com\\aa\\test\\log4j.properties"
		 * ));
		 */
		DOMConfigurator
				.configure("D:\\WorkShop\\Trainings\\02042015\\Tools\\Log4j\\AppenderApp\\src\\com\\aa\\test\\log4j.xml");
		Math m = new Math();
		long p = m.power(3, 3);
		System.out.println("Power : " + p);
	}
}
