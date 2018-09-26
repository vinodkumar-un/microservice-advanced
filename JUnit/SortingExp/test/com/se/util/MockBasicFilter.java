package com.se.util;

public class MockBasicFilter implements Filter {

	@Override
	public Integer[] removeDuplicates(Integer[] data) {
		if (data != null && data.length > 0) {
			// if (new Integer[] { 10, 12, 1, 4, 10, 12 }.equals(data)) {
			return new Integer[] { 10, 12, 1, 4 };
			// }
		}
		throw new IllegalArgumentException("Incorrect test data");
	}

}
