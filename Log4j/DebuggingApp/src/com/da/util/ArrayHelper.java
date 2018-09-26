package com.da.util;

public class ArrayHelper {
	public int[] reverse(int[] input) throws Exception {
		int[] output = null;

		if (input == null || input.length <= 0) {
			throw new Exception("Input Array is empty");
		}

		output = new int[input.length];
		int j = 0;
		for (int i = input.length - 1; i >= 1; i--) {
			System.out.println("i: " + i);
			output[j++] = input[i];
		}
		return output;
	}
}
