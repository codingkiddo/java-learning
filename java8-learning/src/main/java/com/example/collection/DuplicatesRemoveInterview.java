package com.example.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicatesRemoveInterview {

	private static String str = "this is a simple example and simple program example";
	
	public static void main(String[] args) {

		String[] words = str.split(" ");	
		Stream.of(words).forEach(System.out::println);
		System.out.println();
		List<String> result = Arrays.asList(words).stream().distinct().collect(Collectors.toList());
		result.forEach(System.out::println);
		System.out.println();
		List<String> list = Arrays.asList(words);
		list.stream().filter(e -> Collections.frequency(list, e)==1).forEach(e->System.out.println(e));
	}

}
