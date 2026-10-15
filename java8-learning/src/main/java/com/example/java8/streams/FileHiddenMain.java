package com.example.java8.streams;

import java.io.File;
import java.io.FileFilter;

public class FileHiddenMain {

	public static void main(String[] args) {

		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isHidden();
			}
		};

//		File[] hiddenFiles = new File(".").listFiles(File::isHidden);
		File[] hiddenFiles = new File(".").listFiles(fileFilter);
		System.out.println(hiddenFiles.length);
	}

}
