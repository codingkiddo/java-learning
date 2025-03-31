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
		System.out.println("n1 instanceof Integer: " + (n1 instanceof Double));
		
		System.out.println(i1-d1);
		
//		List<Integer> ints = new ArrayList<>();
//		ints.add(1);
//		
//		List<? extends Number> nums = new ArrayList<>();
//		nums = ints;
//		nums.add(1.1);
		
		List<? super Integer> numsSuper = new ArrayList<>();
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		numsSuper = ints;
		numsSuper.add(100);
		
	}

}
