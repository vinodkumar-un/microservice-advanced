package com.nc.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader implements Reader {
	private final String NAME_SEPARATOR = ",";

	public String[] getData(final String fileName) throws IOException {
		int c = -1;
		File file = null;
		String[] names = null;
		StringBuffer buffer = null;
		FileInputStream fis = null;

		try {
			file = new File(fileName);
			if (file.exists() == false) {
				throw new FileNotFoundException("Unable to locate the file");
			}
			buffer = new StringBuffer();
			fis = new FileInputStream(file);
			while ((c = fis.read()) != -1) {
				buffer.append((char) c);
			}
			names = buffer.toString().split(NAME_SEPARATOR);
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
		return names;
	}
}
