package com.example.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StramsMain {

	public static void main(String[] args) {

//		List<Integer> integers = new ArrayList<>();
//		Stream<Integer> intStream = integers.stream();

		Stream.of("Monkey", "Lion", "Giraffe", "Lemur", "Lion").forEachOrdered(System.out::print);
		display(System.out::print);

	}

	private static <T> void display(Consumer<? super T> action) {
	}
}
