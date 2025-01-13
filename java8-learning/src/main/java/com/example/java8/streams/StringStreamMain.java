package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;

public class StringStreamMain {

	public static void main(String[] args) {

		
		List<String> string = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
											"ten", "eleven", "twelve");
		
		string.stream().forEach(System.out::println);
		
	}

}
