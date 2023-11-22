package com.example.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class TestWildCardOne {
	
	private static final int COPY_THRESHOLD           =   10;
	
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<Integer>();
		Bar bar = new Bar();
//		bar.doInsert(integers);
		
		// copy(dest, src)
		copy(new ArrayList<Number>(), new ArrayList<Number>());
		copy(new ArrayList<Number>(), new ArrayList<Integer>());
	}
	
	
	
//	public static <T> void copy(List<T> dest, List<T> src) {
//        for ( int i=0; i<src.size(); i++ ) {
//        	dest.set(i, src.get(i));
//        }
//    }
	
//	public static <T> void copy(List<?> dest, List<?> src) {
//        for ( int i=0; i<src.size(); i++ ) {
//        	dest.set(i, src.get(i));
//        }
//    }
	
//	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
//        for ( int i=0; i<src.size(); i++ ) {
//        	dest.set(i, src.get(i));
//        }
//    }
	
	public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for ( int i=0; i<src.size(); i++ ) {
        	dest.set(i, src.get(i));
        }
    }
}

//class Bar {
//	void doInsert(List<?> list) {
//		list.add(new Integer(0));
//	}
//}

class Bar {
	void doInsert(List<Object> list) {
		list.add(new Integer(0));
	}
}