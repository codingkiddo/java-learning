package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;

public class MiniStreamSourceMain {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Laptop", "Smartphone", "Headphones", "Smartwatch");

		MiniStream<String> stream = MiniStream.from(names);

		System.out.println("Stream created");

		stream.forEach(name -> System.out.println(name));
		
		stream.forEach(System.out::println);
	}
}