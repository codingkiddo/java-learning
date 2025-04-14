package com.example.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Generics1 {

	public static void main(String[] args) {

		List list = new LinkedList();
		list.add(new Integer(11));
//		Integer i = list.iterator().next();
//		The compiler will require an explicit casting
		Integer i = (Integer) list.iterator().next();
		System.out.println(i);
		
		Number n1 = null;
		Integer i1 = 100;
		Double d1 = 123.123;
		
		n1 = i1;
		System.out.println("n1 instanceof Integer: " + (n1 instanceof Integer));
		Integer.compareUnsigned(0, 0);
		
		
		d1.isInfinite();
		
		i1.toHexString(0);
//		Number.compareUnsigned(0, 0);
		
		n1 = d1;
		System.out.println("n1 instanceof Double: " + (n1 instanceof Double));
		
		System.out.println(i1-d1);
		
//		Exception in thread "main" java.lang.ClassCastException: 
//		class java.lang.Double cannot be cast to class java.lang.Integer 
//		(java.lang.Double and java.lang.Integer are in module java.base of loader 'bootstrap')
//		at com.example.generics.Generics1.main(Generics1.java:37)
//		i1 = (Integer) n1;
		
//		List<Integer> ints = new ArrayList<>();
//		ints.add(1);
//		
		List<Number> nums = new ArrayList<>();
//		nums = ints;
		nums.add(1.1);
		Number n2 = 1.1;
		List<? extends Number> numsSuper = new ArrayList<>();
//		numsSuper.add((Number)n2);
//		numsSuper.add(n2);
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		
		numsSuper = ints;
		numsSuper.stream().forEach(n -> System.out.println(n.getClass()));
//		numsSuper.add(100);
		
		List<? super Integer> parent = new ArrayList<>();
		List<Number> nums2 = new ArrayList<>();
		nums2.add(1);
		nums2.add(1.1);
		parent = nums2;
//		parent.add(1.1);
		
		parent.stream().forEach(n -> System.out.println(n.getClass()));
	}

}
