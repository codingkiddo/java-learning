package com.example.collection;

import java.util.ArrayList;
import java.util.List;

public class HandlingNulls {

	public static void main(String[] args) {

		List<? super Integer> ints1 = new ArrayList<Integer>();
		List<? super Integer> ints2 = new ArrayList<Number>();
		List<? super Integer> ints3 = new ArrayList<Object>();
		
		List<? super Integer> ints4 = new ArrayList<String>();
		
		
		
		List<? extends Number> nums1 = new ArrayList<Number>();
		List<? extends Number> nums2 = new ArrayList<Integer>();
		List<? extends Number> nums3 = new ArrayList<String>();
		
	}

}
