package com.example.generics;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcards3 {
	public static void main(String[] args) {
		List<Object> objs =new  ArrayList<Object>();
		objs.add(2);
		objs.add(3.14);
		objs.add("four");
		
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(5);
		ints.add(6);
		System.out.println(objs);
		
		LowerBoundedWildcards3.copy(objs, ints);
//		LowerBoundedWildcards3.copy(ints, objs); // Error
		System.out.println(objs);
		
	}
	
	private static <T> void copy( List<? super T> dest, List<? extends T> src ) {
		for ( int i=0; i<src.size(); i++ ) {
			dest.add(src.get(i));
		}
	}
	
//	private static void copy( List<? super Integer> dest, List<? extends Integer> src ) {
//		for ( int i=0; i<src.size(); i++ ) {
//			dest.add(src.get(i));
//		}
//	}
	
//	private static void copy( List<? super Object> dest, List<? extends Object> src ) {
//		for ( int i=0; i<src.size(); i++ ) {
//			dest.add(src.get(i));
//		}
//	}
}
