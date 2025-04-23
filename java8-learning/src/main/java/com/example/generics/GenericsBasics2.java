package com.example.generics;

public class GenericsBasics2 {

	public static void main(String[] args) {

		Object[] objs1 = new Object[2];
		String[] strs1 = new String[2];
		
		
		objs1 = strs1;
		objs1[0] = 1;
		objs1[1] = "A";
		
		System.out.println("objs1: " + objs1[0] + ":" + objs1[1]);
		System.out.println("strs1: " + strs1[0] + ":" + strs1[1]);
		
	}
}
