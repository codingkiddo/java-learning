package com.example.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Vinod", "Kumar", "Coding", "Kiddo");

		System.out.println("Before Java 5");
		for ( Iterator<String> it = names.iterator(); it.hasNext(); ) {
			String name = it.next();
			System.out.println(name.length());
		}
		System.out.println("On/After Java 5");
		for ( String name : names ) {
			System.out.println(name.length());
		}
		
		System.out.println("From Java 8 - 1");
		names.forEach(name -> System.out.println(name.length()));
		System.out.println("From Java 8 - 2");
//		names.forEach(System.out.println(String::length));
	}

}
