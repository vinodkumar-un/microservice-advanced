package com.se.util;

public class Sorter {
	private Filter filter;

	public Sorter() {
		filter = new BasicFilter();
	}

	public Sorter(Filter filter) {
		this.filter = filter;
	}

	public Integer[] sort(Integer[] data) {
		int tmp = 0;
		Integer[] filterData = null;

		filterData = filter.removeDuplicates(data);
		for (int i = 0; i < filterData.length; i++) {
			for (int j = i + 1; j < filterData.length; j++) {
				if (filterData[i] > filterData[j]) {
					tmp = filterData[i];
					filterData[i] = filterData[j];
					filterData[j] = tmp;
				}
			}
		}
		return filterData;
	}
}
