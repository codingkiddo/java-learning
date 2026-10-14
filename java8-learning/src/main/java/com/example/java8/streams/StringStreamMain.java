package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StringStreamMain {

	public static void main(String[] args) {

//		List<String> string = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
//				"ten", "eleven", "twelve");
//		string.stream().forEach(System.out::println);
//
//		Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");
//
//		Map<String, Long> letterToCount = words.map(w -> w.split("")).flatMap(Arrays::stream)
//				.collect(groupingBy(identity(), counting()));
//
//		System.out.println("Letter To Count - " + letterToCount);
		
		Stream<?> emptyStream = Stream.of();
		System.out.println(emptyStream);
		
		List<String> string = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
											"ten", "eleven", "twelve");
		
		string.stream().forEach(System.out::println);
		
		
		
		Object o1 = "A";
		Object o2 = 1;
		
//		Consumer<? super String> consumer2 = value -> System.out.println(value);

//		consumer2.accept("A");          // Valid
//		consumer2.accept(o1);
		
		Consumer<String> strings = value -> System.out.println(value);
		Consumer<Object> objects = value -> System.out.println(value);

//		Consumer<? extends Object> consumer2 = value -> System.out.println(value); // Valid
//		consumer2.accept("A");
	}

}
