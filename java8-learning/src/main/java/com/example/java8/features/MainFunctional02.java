package com.example.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFunctional02 {
	public static void main(String[] args) {
		System.out.println(map(Arrays.asList("codingkiddo", "aaa", "aa"), s->s.length()));
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
}
