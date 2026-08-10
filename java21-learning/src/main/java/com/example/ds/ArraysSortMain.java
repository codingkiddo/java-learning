package com.example.ds;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysSortMain {

	public static void main(String[] args) {

		int[] a = { 9, 3, 5, 1, 4 };
//		Stream.of(a).forEach( n -> System.out.println(n));
		Arrays.stream(a).forEach(n -> System.out.println(n));
		System.out.println("---------");
		Arrays.sort(a);
		Stream.of(a).forEach( n -> System.out.println(n));
		System.out.println("---------");
		
	}

}
