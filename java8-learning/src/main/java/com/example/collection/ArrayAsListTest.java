package com.example.collection;

import java.util.Arrays;
import java.util.List;

public class ArrayAsListTest {

	public static void main(String[] args) {

		String[] stringArray = {"one", "two", "three"};
		List<String> stringList = Arrays.asList(stringArray);
		
		int[] intArray = {1, 2, 3};
		List<int[]> intList = Arrays.asList(intArray);
		
		System.out.println(stringList.contains("one"));
		System.out.println(intList.contains(1));
		
		System.out.println(intList.contains(intArray));
		
	}

}
