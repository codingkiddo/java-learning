package org.paumard.javaone2017;

import java.util.Arrays;
import java.util.List;

public class LiveDemo {

	public static void main(String[] args) {

		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six");
		strings.stream().forEach(System.out::println);
		
	}

}
