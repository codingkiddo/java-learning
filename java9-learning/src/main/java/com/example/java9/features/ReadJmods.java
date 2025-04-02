package com.example.java9.features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadJmods {

	public static void main(String[] args) throws IOException {
		readMyOwnJRE();
	}

	private static void readMyOwnJRE() throws IOException {
	    try {
	        Path p = Paths.get(URI.create("jrt:/")).resolve("/modules");
	        System.out.println("My own JRE's modules:");
	        Files.list(p).forEach(m -> {
	        	try {
	        		File file = new File(m.toUri().getPath());
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder stringBuilder = new StringBuilder();

					char[] buffer = new char[10];

					while ( bufferedReader.read(buffer) != -1 ) {
						stringBuilder.append(new String(buffer));
						buffer = new char[10];

					}
					bufferedReader.close();
					String content = stringBuilder.toString();
					System.out.println("CONTENT - " + content);
				} catch ( IOException e) {
					e.printStackTrace();
				}
	        });
	        System.out.println();
	    } catch(FileSystemNotFoundException ex) {
	        System.out.println("Could not read my modules (perhaps not Java 9?).");
	    }
	}

}
