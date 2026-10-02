package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class StringStreamMain {

	public static void main(String[] args) {

		List<String> string = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
				"ten", "eleven", "twelve");
		string.stream().forEach(System.out::println);

		Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");

		Map<String, Long> letterToCount = words.map(w -> w.split("")).flatMap(Arrays::stream)
				.collect(groupingBy(identity(), counting()));

		System.out.println("Letter To Count - " + letterToCount);
	}

}
