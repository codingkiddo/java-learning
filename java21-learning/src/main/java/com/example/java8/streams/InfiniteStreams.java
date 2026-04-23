package com.example.java8.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteStreams {

	public static void main(String[] args) {

		Stream<Integer> naturals = Stream.iterate(1, n->n+1);
//		naturals.collect(Collectors.toList());
		naturals.forEach(n -> System.out.println(n));
		
	}

}
