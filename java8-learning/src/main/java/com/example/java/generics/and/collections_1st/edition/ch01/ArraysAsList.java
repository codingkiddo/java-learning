package com.example.java.generics.and.collections_1st.edition.ch01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {

		
		
		List<Integer> ints = Arrays.asList(1, 2, 3);
		ints.contains(1);
		int s=0;
		for (int n : ints) { s += n; }
		assert s == 6;
//		
//		List ints = Arrays.asList(new Integer[] {new Integer(1), new Integer(2), new Integer(3) });
//		int s = 0;
//		for ( Iterator it = ints.iterator(); it.hasNext(); ) {
//			int n = ((Integer) it.next()).intValue();
//			s += n;
//		}
//		assert s == 6;
		
		List words = new ArrayList();
//		words.add("Hello ");
//		words.add("world!");
//		System.out.println(words.get(0));
//		
//		List<String> wordsG = new ArrayList<String>();
//		wordsG.add("Hello ");
//		wordsG.add("world!");
//		System.out.println(wordsG.get(0));
		
//		String sArray[] = new String[10];
//		List<String> sList = new ArrayList<String>(100);
//		
//		System.out.println("<--- OK --->");
		
//		Integer[] a =  Array.newInstance(Integer.class, 10);
//		a[1] = 11;
//		System.out.println(a);
	}
	
//	public <T> T[] getArray(int size) {
//		T[] arr = new T[size];
//		return arr;
//	}

}


class Stack<T> {
	private final T[] array;
	Stack(Class<T> clazz, int capacity) {
		array = (T[])Array.newInstance(clazz, capacity);
	}
}
