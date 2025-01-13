package com.example.generics;

import java.util.ArrayList;
import java.util.List;

public class SubtypeSuperMain {

	public static void main(String[] args) {

		Number n1 = 12;
		Integer i1 = 1;
		Object o1 = new Object();
		
		List<Object> listObjs = new ArrayList<>();
		listObjs.add("A");
		listObjs.add(new Object());
		listObjs.add(i1);
		listObjs.add(n1);
		
		
		List<Integer> listInts = new ArrayList<>();
//		listInts.add(o1);
//		listInts.add(n1);
		listInts.add(1);
		
		List<Number> listNumbers = new ArrayList<>();
		listNumbers.add(1.1);
		listNumbers.add(i1);
		
		List<? super Number> nums = listObjs; // Yes - Object Is Super Of Number
		nums.set(0, o1);
		nums.set(1, n1);
		nums.set(2, 11.11);
		System.out.println(nums.get(0).getClass().getTypeName());
		System.out.println(nums);
		
		nums.set(0, i1);
//		nums = listNumbers; // Yes - Number Is Super Of Number
//		List<? super Number> nums = listInts; // No - Integer Is Not Super Of Number
		
		
		List<? super Integer> ints = listInts; // Yes - Integer Is Super Of Integer
		ints = listNumbers; // Yes - Number Is Super Of Integer
		ints = listObjs; // Yes - Object Is Super Of Integer
	}

}
