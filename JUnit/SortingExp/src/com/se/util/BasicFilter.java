package com.se.util;

import java.util.ArrayList;
import java.util.List;

public class BasicFilter implements Filter {

	@Override
	public Integer[] removeDuplicates(Integer[] data) {
		List<Integer> filterData = null;

		if (data != null && data.length > 0) {
			filterData = new ArrayList<Integer>();
			for (int d : data) {
				if (filterData.contains(d) == true) {
					continue;
				}
				filterData.add(d);
			}
		}

		return toArray(filterData);
	}

	/**
	 * No need to write testCase as it is being referred by other methods of the
	 * class
	 * 
	 * @param filterData
	 * @return
	 */
	private Integer[] toArray(List<Integer> filterData) {
		Integer[] data = null;

		data = new Integer[filterData.size()];
		for (int i = 0; i < filterData.size(); i++) {
			data[i] = filterData.get(i);
		}
		return data;
	}

}
