package com.example.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics4 {

	public static void main(String[] args) {

		List<Number> numbers = new ArrayList<Number>();
		numbers.add(100);
		numbers.add(100.200);
		
		System.out.println(numbers);
		
		Integer i1 = (Integer) numbers.get(1);
		System.out.println(i1);
		
		Number n2 = 200.200;
		Integer i2 = (Integer) n2;
		System.out.println(i2);
		
	}

}
