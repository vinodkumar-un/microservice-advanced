package com.nc.beans;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.nc.helper.FileReader;
import com.nc.helper.Reader;

public class NameCounter {
	private Reader reader;

	public NameCounter() {
		reader = new FileReader();
	}

	public NameCounter(Reader reader) {
		this.reader = reader;
	}

	public Map<String, Integer> getNameIndexTotalCount(final String fileName)
			throws IOException {
		int i = 0;
		int charCount = 0;
		String[] names = null;
		Map<String, Integer> nameCounterMap = null;

		names = reader.getData(fileName);
		if (names != null && names.length > 0) {
			nameCounterMap = new HashMap<String, Integer>();
			for (i = 0; i < names.length; i++) {
				charCount = getCountOfChars(names[i]);
				nameCounterMap.put(names[i], (i + 1) * charCount);
			}
		}
		return nameCounterMap;
	}

	protected int getCountOfChars(final String name) {
		int totalCount = 0;
		char[] chars = null;

		chars = name.toCharArray();
		for (char c : chars) {
			totalCount += (int) c;
		}
		return totalCount;
	}
}
