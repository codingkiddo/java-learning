package com.example.java8.features;

import java.util.stream.IntStream;

public class FindMinInArray {

	public static void main(String[] args) {

		int[] numbers =  {4, 1, 13, 90, 16, 2, 0};
		
		int min = numbers[0];
		
		for ( int i=1; i<numbers.length; i++ ) {
			if ( min > numbers[i]) {
				min = numbers[i];
			}
		}
		System.out.println("Minimum is : " + min);
		
		int minUsingJava8 = IntStream.of(numbers).min().getAsInt();
		System.out.println("Minimum is : " + minUsingJava8);
//		OR
		IntStream.of(numbers).min().ifPresent(System.out::println);
	}

}
