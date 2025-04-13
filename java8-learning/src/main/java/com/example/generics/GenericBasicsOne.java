package com.example.generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericBasicsOne {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		Stream<Integer> stream = numbers.stream();
		
		stream.onClose(new Runnable() {
			@Override
			public void run() {
				System.out.println("Closing Stream !!!!!");
			}
		});
		
		System.out.println(stream.filter(n -> n/2==0).collect(Collectors.toList()));;
		stream.close();
	}
}
