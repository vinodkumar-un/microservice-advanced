package com.ju.beans;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Calculator34Test {
	
	@BeforeClass
	public static void startup() {
		System.out.println("startup()");
	}
	
	@Test
	@Ignore
	public void testAdd() {
		System.out.println("testAdd()");
	}

	@Test
	public void verifyMultiply() {
		System.out.println("verifyMultiply()");
	}
	
	@AfterClass
	public static void cleanUp() {
		System.out.println("cleanUp()");
	}
}
