package com.example.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFunctional02 {
	public static void main(String[] args) throws Exception {
		FunctionalEx<String, Integer> funEx = (s) -> {
			if ( s.equals("") ) {
				throw new RuntimeException("Empty String");
			} 
			return s.length();
		};
		
		System.out.println(map(Arrays.asList("codingkiddo", "aaa", "aa"), s->s.length()));
		System.out.println(mapEx(Arrays.asList("codingkiddo", "aaa", ""), funEx));
		
		Runnable r = () -> System.out.println("Hello !!");
//		The following code doesn't compile. The target type is must be funtional interface
//		Object o = () -> System.out.println("Hello !!"); 
		Object o = r;
	}

//	public static <T, R> List<R> map(List<T> list) {
//		
//	}
	
	public static <T, R> List<R> map(List<T> list, Functional<T, R> f) {
		List<R> result = new ArrayList<>();
		for( T t : list ) {
			result.add( f.apply(t) );
		}
		return result;
	}
	
	public static <T, R> List<R> mapEx(List<T> list, FunctionalEx<T, R> f) throws Exception {
		List<R> result = new ArrayList<>();
		for ( T t : list) {
			result.add( f.apply(t) );
		}
		return result;
	}
}
