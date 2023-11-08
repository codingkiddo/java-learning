package com.example.generics;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards {

	public static void main(String[] args) {
		
		List<?> stuff = new ArrayList<>();
		// stuff.add("abc");
		// stuff.add(new Object());
		// stuff.add(3);
		int numElements = stuff.size();
		System.out.println(numElements);
		
		List<String> strings = new ArrayList<>();
		String s = "abc";
		Object o = s;      // allowed
		// strings.add(o); // not allowed
		strings.add((String)o); // alowed
		
		printList(strings);
		
		List<Number> numbers = new ArrayList<Number>();
		numbers.add(new Integer(100));
		numbers.add(new Byte((byte)0));
		numbers.add(new Float(1.1));
		
		printList(numbers);
		
		System.out.println(strings.containsAll(numbers));
	}
	
	private static void printList(List<?> list) {
	    System.out.println(list);
	}

}
