package com.example.java8.streams;

import java.io.File;

public class FileHiddenMain {

	public static void main(String[] args) {

		File[] hiddenFiles = new File(".").listFiles(File::isHidden);
		System.out.println(hiddenFiles.length);
		
	}

}
