package com.example.generics;

public class GenericsBasics1 {

	public static void main(String[] args) {

		Object o1 = new Object();
		System.out.println("o1: " + o1);
		o1 = "A";
		o1 = 1;
		System.out.println("o1: " + o1);
		String s1 = (String) o1;
		System.out.println("s1: " + s1);
		
		
	}

}
