package com.example.java8.features;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Find3DistinctSmallestNumbers {

	public static void main(String[] args) {

		int[] numbers =  {4, 1, 1, 13, 90, 16, 2, 0, 0};
		
		int[] copy = Arrays.copyOf(numbers, numbers.length);
		
		Arrays.sort(copy);
		for ( int i=0; i<copy.length; i++ ) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();
		int cnt = 0;
		for ( int i=0, j=0; i<copy.length; ) {
			
			if ( i==0 && cnt ==0 ) {
				++cnt;
				System.out.print(copy[i] + " ");
				++j;
			} else if ( !( cnt == 3 )) {
				if ( copy[i] == copy[j] ) {
					++j;
				} else {
					i = j;
					++cnt;
					System.out.print(copy[i] + " ");
					++j;
					if ( cnt == 3) {
						break;
					}
				}
			}
			
		}
		
		System.out.println();
		
		IntStream.of(numbers).distinct().sorted().limit(3).forEach(System.out::println);
		System.out.println(IntStream.of(numbers).distinct().sorted().limit(3).sum());
		System.out.println("Done !!!");
	}

}
