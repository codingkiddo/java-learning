package com.example.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LowerBoundedWildcards {

	public static void main(String[] args) {
		ArrayList<Integer> integerList = new ArrayList<>();
		ArrayList<Number> numberList = new ArrayList<>();
		ArrayList<Object> objectList = new ArrayList<>();

		numsUpTo(5, integerList);
		numsUpTo(5, numberList);
		numsUpTo(5, objectList);
		
		System.out.println(integerList);
		System.out.println(numberList);
		System.out.println(objectList);
		
	}

	private static void numsUpTo(Integer num, List<? super Integer> output) {
	    IntStream.rangeClosed(1, num)
	        .forEach(output::add);
	}

}
