package com.example.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFunctional01 {

	public static void main(String[] args) {
		System.out.println(map(Arrays.asList("a", "aaa", "aa")));
		System.out.println(map(Arrays.asList(1, 3, 44)));
	}

//	public static <T, R> List<R> map(List<T> list) {
//		
//	}
	
	public static <T> List<Integer> map(List<T> list) {
		List<Integer> result = new ArrayList<>();
		for( T t : list ) {
			result.add( t instanceof String ? ((String)t).length() : 0 );
		}
		return result;
	}
}
