package com.example.generics;

import java.util.ArrayList;
import java.util.List;



public class MyListMain2 {
	public static void main(String[] args) {
//		MyList<Integer> ints = new MyListImpl<>();
//		ints.add(100);
//		Number n1 = 123.123;
//		ints.add(n1);
//		System.out.println(ints.get(0));
//		System.out.println(ints);
		
//		MyList<Number> nums = new MyListImpl<>();
//		nums.add(100);
//		Integer n1 = 123;
//		Double d1 = 0.05;
//		nums.add(n1);
//		nums.add(d1);
//		System.out.println(nums.get(0));
//		System.out.println(nums);
		
		
		MyList<? super Number> nums = new MyListImpl<>();
		nums.add(100);
		Integer n1 = 123;
		Number d1 = 0.05;
		nums.add(n1);
		nums.add(d1);
		System.out.println(nums.get(0));
		System.out.println(nums);
		
		List<? extends String> names = new ArrayList<>();
//		names.add("VINOD");
	}
}
