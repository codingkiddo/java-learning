package com.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Generics5 {

	public static void main(String[] args) {

//		List ints = Arrays.asList(1, 2, 3);
//		int s = 0;
//		
//		for ( Iterator it = ints.iterator(); it.hasNext(); ) {
////			int n = ((Integer) it.next()).intValue();
//			int n = (int) it.next();
//			s += n;
//		}
//		System.out.println(s);
		
//		List<Integer> ints = new ArrayList<Integer>();
//		ints.add(1);
//		ints.add(2);
//		
//		List<? extends Number> nums = ints;
//		Number n = 200;
////		nums.add(n); // Not permitted
//		
//		System.out.println(nums.get(0));
////		Double price = (Double) nums.get(0);
//		System.out.println(nums.get(0) instanceof Double); // false
		
		
//		List<? extends Number> nums = new ArrayList<Number>();
//		List<Integer> ints = Arrays.asList(1, 2);
//		List<Double> dbls = Arrays.asList(2.78, 3.14);
//		nums.addAll(ints);
//		nums.addAll(dbls);
//		
//		nums.add(100);
//		
//		assert nums.toString().equals("[1, 2, 2.78, 3.14]");
		
		
//		List<Object> objs = Arrays.<Object>asList(2, 3.14, "Four");
//		System.out.println(objs.get(1) instanceof String);
//		System.out.println(objs);
//		
//		List<Integer> ints = Arrays.<Integer>asList(5, 6);
//		System.out.println(ints);
//		
//		Collections.copy(objs, ints);
//		System.out.println(objs);
		
		List<? super Integer> nums = new ArrayList<Number>();
		Number n = 200;
		nums.add(n);
		
	}

}
