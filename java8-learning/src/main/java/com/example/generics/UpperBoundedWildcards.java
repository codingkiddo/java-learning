package com.example.generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcards {

	public static void main(String[] args) {

//		List<? extends Number> numbers = new ArrayList<Number>();
//		List<? extends Number> integers = new ArrayList<Integer>();
		
		List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
	    List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
	    List<BigDecimal> bigDecimals = Arrays.asList(
	        new BigDecimal("1.0"),
	        new BigDecimal("2.0"),
	        new BigDecimal("3.0"),
	        new BigDecimal("4.0"),
	        new BigDecimal("5.0")
	    );

	    System.out.printf("ints sum is        %s%n", sumList(ints));
	    System.out.printf("doubles sum is     %s%n", sumList(doubles));
	    System.out.printf("bigdecimals sum is %s%n", sumList(bigDecimals));
	    
//	    List<String> strings = new ArrayList<>();
//	    sumList(strings); // NOT OK
	    
	    
	    readList(ints);
	    readList(doubles);
	    readList(bigDecimals);
	}


	private static double sumList(List<? extends Number> list) {
	    return list.stream()
	            .mapToDouble(Number::doubleValue) // returns DoubleStream
	            .sum();
	}

	private static void readList(List<? extends Number>  list) {
		Number n = list.get(0);
		System.out.println("Number: " + n);
	}
}


class Test<T> {
	private List<? extends T> list = new ArrayList<T>(); 
}