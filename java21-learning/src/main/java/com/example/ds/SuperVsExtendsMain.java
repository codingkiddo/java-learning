package com.example.ds;

import java.util.ArrayList;
import java.util.List;

public class SuperVsExtendsMain {

	public static void main(String[] args) {

		Integer i = 100;
		Number n = 200;
		Comparable<Number> c1 = (Comparable<Number>) n;
		
		System.out.println(c1.compareTo(202));
		System.out.println(c1.compareTo(100.5));
		
		
		List<? super Integer> list = new ArrayList<Number>();
		list.add(10);             // ✅ safe
		Object x = list.get(0);   // ✅ only guaranteed as Object
		
		Object o1 = 3.14;
		list.add(o1);
 		
	}

	private static void print1() {
		
	}
	
}
