package com.qlvk.common.excel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyUtils {
	private static Logger logger = LoggerFactory.getLogger(CopyUtils.class);
	public boolean copyFile(File source, File dest) {

		InputStream inStream = null;
		OutputStream outStream = null;

		try {
			inStream = new FileInputStream(source);
			outStream = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
			inStream.close();
			outStream.close();
			logger.info("Copy File: " + source.getName() + "\t\t>> ");
		} catch (IOException e) {
			logger.info("ERROR");
			return false;
		}

		logger.info("SUCCESS");
		return true;
	}

	public List<String> copyAllFile(File source, File dest) {

		List<String> listFile = new ArrayList<>();
		// String pattern = ".*\\.java";
		String pattern = ".*";
		search(pattern, source, listFile);

		List<String> fileError = new ArrayList<>();
		for (String s : listFile) {
			if (!copyFile(new File(source + "/" + s), new File(dest + "/" + s))) {
				fileError.add(source + "/" + s);
			}
		}
		return fileError;
	}

	public void search(final String pattern, final File folder, List<String> result) {
		for (final File f : folder.listFiles()) {

			if (f.isDirectory()) {
				search(pattern, f, result);
			}

			if (f.isFile()) {
				if (f.getName().matches(pattern)) {
					result.add(f.getName());
				}
			}

		}
	}
}
