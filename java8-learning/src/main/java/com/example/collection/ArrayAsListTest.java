package com.example.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayAsListTest {

	public static void main(String[] args) {

//		String[] stringArray = {"one", "two", "three"};
//		List<String> stringList = Arrays.asList(stringArray);
//		
//		int[] intArray = {1, 2, 3};
//		List<int[]> intList = Arrays.asList(intArray);
//		
//		System.out.println(stringList.contains("one"));
//		System.out.println(intList.contains(1));
//		
//		System.out.println(intList.contains(intArray));
//		
//		Collections.synchronizedMap(null);
		
		List<String> list = new ArrayList<>();

		list.add("one");
		list.add("two");
		list.add("three");

		for( String element : list ){
		    System.out.println( element.toString() );
		}

		
	}

}
