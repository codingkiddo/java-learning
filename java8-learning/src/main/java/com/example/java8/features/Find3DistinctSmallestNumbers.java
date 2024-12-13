package com.example.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Find3DistinctSmallestNumbers {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(4, 1, 1, 13, 90, 16, 2, 0, 0);
		long count = list.stream().distinct().count();
		System.out.println("Count: " + count);
		System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
		
//		int[] numbers =  {4, 1, 1, 13, 90, 16, 2, 0, 0};
//		List<Integer> list = Arrays.stream(numbers).boxed().collect((Collectors.toList()));
//		long count = list.stream().distinct().count();
//		System.out.println("Count: " + count);
//
//		System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
//		
//		System.out.println(IntStream.of(numbers).sum());
//		
//		int[] copy = Arrays.copyOf(numbers, numbers.length);
//		
//		Arrays.sort(copy);
//		for ( int i=0; i<copy.length; i++ ) {
//			System.out.print(copy[i] + " ");
//		}
//		System.out.println();
//		int cnt = 0;
//		for ( int i=0, j=0; i<copy.length; ) {
//			
//			if ( i==0 && cnt ==0 ) {
//				++cnt;
//				System.out.print(copy[i] + " ");
//				++j;
//			} else if ( !( cnt == 3 )) {
//				if ( copy[i] == copy[j] ) {
//					++j;
//				} else {
//					i = j;
//					++cnt;
//					System.out.print(copy[i] + " ");
//					++j;
//					if ( cnt == 3) {
//						break;
//					}
//				}
//			}
//			
//		}
//		
//		System.out.println();
//		
//		IntStream.of(numbers).distinct().sorted().limit(3).forEach(System.out::println);
//		System.out.println(IntStream.of(numbers).distinct().sorted().limit(3).sum());
//		System.out.println("Done !!!");
	}

}
