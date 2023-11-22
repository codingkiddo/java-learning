package com.example.java.generics.and.collections_1st.edition.ch01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Lists {
//	static <T> List<T> toList(T[] arr) {
//		List<T> list = new ArrayList<T>();
//		for (T elt : arr) list.add(elt);
//		return list;
//	}
	static <T> List<T> toList(T... arr) {
		List<T> list = new ArrayList<T>();
		for (T elt : arr) list.add(elt);
		return list;
	}
}
public class ArraysAsListTwo {
	public static void main(String[] args) {
		List<Integer> numbers = Lists.toList();
		System.out.println(numbers);
		
		List<?> objects = Lists.toList(1, "ONE");
		System.out.println(objects.get(0).getClass());
		System.out.println(objects.get(1).getClass());
		
		List<Object> objects2 = new ArrayList<Object>();
		objects2.add(1);
		objects2.add("ONE");
		objects2.add(new Date());
		System.out.println(objects2.get(0).getClass());
		System.out.println(objects2.get(1).getClass());
		System.out.println(objects2.get(2).getClass());
//		System.out.println(objects2.get(2).);
	}
}
