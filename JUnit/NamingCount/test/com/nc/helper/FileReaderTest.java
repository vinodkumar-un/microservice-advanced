package com.nc.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileReaderTest {
	private final static String DATA_FILE = "d:\\testData.txt";
	private FileReader reader;
	private String[] expectedNames;

	@BeforeClass
	public static void startUp() throws IOException {
		File file = null;
		String data = null;
		FileOutputStream fos = null;

		data = "Ravi,Raju,Raghu,Ramu,Rajesh";
		file = new File(DATA_FILE);
		fos = new FileOutputStream(file);
		fos.write(data.getBytes());
		fos.close();
	}

	@Before
	public void setUp() {
		reader = new FileReader();
		expectedNames = new String[] { "Ravi", "Raju", "Raghu", "Ramu",
				"Rajesh" };
	}

	@Test
	public void testGetDataWithArrayLength() throws IOException {
		String[] actualNames = null;
		actualNames = reader.getData(DATA_FILE);
		Assert.assertEquals(expectedNames.length, actualNames.length);
	}

	@Test
	public void testGetDataWithArrayContent() throws IOException {
		String[] actualNames = null;

		actualNames = reader.getData(DATA_FILE);
		Assert.assertArrayEquals(expectedNames, actualNames);
	}

	@Test(expected = FileNotFoundException.class)
	public void testGetDataWithoutFile() throws IOException {
		reader.getData("d:\\nofile.txt");
	}

	@AfterClass
	public static void release() {
		File file = null;

		file = new File(DATA_FILE);
		file.delete();
	}
}
