package com.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		
		List<? extends Number> nums = ints;
		
		System.out.println(nums.get(0));
//		Double price = (Double) nums.get(0);
		System.out.println(nums.get(0) instanceof Double); // false
	}

}
