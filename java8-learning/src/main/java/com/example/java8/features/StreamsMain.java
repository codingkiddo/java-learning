package com.example.java8.features;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamsMain {

	
	public static void main(String[] args) {

		OptionalInt result = IntStream.range(0, 4)
					.filter(i -> i%2==1)
					.flatMap(number -> IntStream.range(0, number))
					.reduce((n1, n2) -> (n1+n2));
		
		System.out.println("Result: " + result.getAsInt());
	}

}
