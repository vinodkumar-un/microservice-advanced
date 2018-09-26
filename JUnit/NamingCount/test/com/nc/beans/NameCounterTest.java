package com.nc.beans;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nc.helper.Reader;

public class NameCounterTest {
	private final static String DATA_FILE = "d:\\testData.txt";
	private NameCounter nameCounter;
	private String name;
	private int expectedCount;
	private Map<String, Integer> nameCounterMap;
	private Reader mockReader;

	@Before
	public void setUp() throws IOException {
		mockReader = EasyMock.createMock(Reader.class);
		EasyMock.expect(mockReader.getData(DATA_FILE)).andReturn(
				new String[] { "abc", "bcd" });
		EasyMock.replay(mockReader);

		nameCounter = new NameCounter(mockReader);
		name = "abc";
		expectedCount = 294;
		nameCounterMap = new HashMap<String, Integer>();
		nameCounterMap.put("abc", 294);
		nameCounterMap.put("bcd", 594);
	}

	@Test
	public void testGetCountOfChars() {
		int actualCount = 0;

		actualCount = nameCounter.getCountOfChars(name);
		Assert.assertEquals(expectedCount, actualCount);
	}

	@Test
	public void testGetNameIndexTotalCount() throws IOException {
		Map<String, Integer> actualMap;

		actualMap = nameCounter.getNameIndexTotalCount(DATA_FILE);
		Assert.assertEquals(nameCounterMap, actualMap);
	}

}
