package com.example.modren_java_in_action.ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;



public class ExecuteAround {
	private static final String FILE = ExecuteAround.class.getResource("data.txt").getFile();

	public static void main(String... args) throws IOException {
		// method we want to refactor to make more flexible
//		String result = processFileLimited();
//		System.out.println(result);
//		System.out.println("---");
		
		
		BufferedReaderProcessor p1 = br -> br.readLine();
		String line1 = processFile(p1);
		System.out.println(line1);
		System.out.println("---");
		BufferedReaderProcessor p2 = br -> br.readLine() + br.readLine();
		String line2 = processFile(p2);
		System.out.println(line2);
		System.out.println("---");
		BufferedReaderProcessor p3 = br -> {
			String text = "";
			String line = null;
			while ( (line = br.readLine()) != null ) {
				text = text + line;
			}
			return text;
		};
		String line3 = processFile(p3);
		System.out.println(line3);
		System.out.println("---");
		
		
		BufferedReaderProcessor p4 = br -> {
//			return 	br.lines().collect(Collectors.joining(System.lineSeparator()));
			return 	br.lines().collect(Collectors.joining());
			
		};
		String line4 = processFile(p4);
		System.out.println(line4);
		System.out.println("---");
	}

	public static String processFileLimited() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
			return br.readLine();
		}
	}
	
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
			return p.process(br);
		}
	}
}
