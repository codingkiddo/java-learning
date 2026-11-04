package com.example.java8.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMain1 {

	public static void main(String[] args) {

		
		Stream<String> stream = Stream.of("a", "b", "c", "d");
		Long count = stream.collect(Collectors.counting());
		
	}

}
