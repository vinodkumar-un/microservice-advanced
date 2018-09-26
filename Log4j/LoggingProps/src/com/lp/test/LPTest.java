package com.lp.test;

import com.lp.util.ArrayUtil;

public class LPTest {
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };
		ArrayUtil au = new ArrayUtil();
		long sum = au.add(input);
		System.out.println("Sum : " + sum);
	}
}
