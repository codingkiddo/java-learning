package com.example.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListStringTest {

	public static void main(String[] args) {

		List<String> strings = new ArrayList<>();
		String s = "abc";
		Object o = s;      // allowed
		// strings.add(o); // not allowed
		strings.add((String)o); // alowed
		
		System.out.println(strings);
		
//		 List<Object> moreObjects = strings; // also not allowed, but pretend it was
//		 moreObjects.add(new Date());
//		 String s = moreObjects.get(0); // uh oh

		
		List<Number> numbers = new ArrayList<Number>();
		numbers.add(new Integer(100));
		numbers.add(new Byte((byte)0));
		numbers.add(new Float(1.1));
		
		System.out.println(numbers);
		
	}

}
