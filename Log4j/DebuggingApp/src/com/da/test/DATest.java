package com.da.test;

import com.da.util.ArrayHelper;

public class DATest {

	public static void main(String[] args) throws Exception {
		int[] input = new int[] { 1, 2, 3, 4, 5 };
		int[] output = null;
		ArrayHelper arrayHelper = null;

		arrayHelper = new ArrayHelper();
		output = arrayHelper.reverse(input);
		for (int o : output) {
			System.out.print(o + ",");
		}
	}
}
