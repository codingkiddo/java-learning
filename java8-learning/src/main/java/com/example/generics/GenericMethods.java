package com.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericMethods {

	public static void main(String[] args) {

		Integer[] intArray = { 1, 2, 3, 4, 5 };
		System.out.println(arrayToList(intArray));
        System.out.println(fromArrayToList(intArray, Object::toString));
	}

	private static <T> List<T> arrayToList(T[] a) {
//		return Arrays.stream(a).collect(Collectors.toList());
//		OR
		List<T> list = new ArrayList<T>();
		for (T t : a) {
			list.add(t);
		}
		return list;
	}
	
	private static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapper) {
		return Arrays.stream(a).map(mapper).collect(Collectors.toList());
	}
}
