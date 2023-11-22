package com.example.generics;

import java.util.ArrayList;
import java.util.Collections;
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
		
		if ( objectList.get(0) instanceof String ) {
			String s = (String) objectList.get(0);
			System.out.println(s);	
		}
		
		Collections.copy(new ArrayList<Number>(), new ArrayList<Number>());
		Collections.copy(new ArrayList<Number>(), new ArrayList<Integer>());
		Collections.copy(new ArrayList<Object>(), new ArrayList<Number>());
		Collections.copy(new ArrayList<Object>(), new ArrayList<Double>());
		
	}

	private static void numsUpTo(Integer num, List<? super Integer> output) {
	    IntStream.rangeClosed(1, num)
	        .forEach(output::add);
	}

}
