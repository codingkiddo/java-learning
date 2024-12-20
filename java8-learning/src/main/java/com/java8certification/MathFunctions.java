package com.java8certification;

public class MathFunctions {

	public static void addToInt(int x, int amountToAdd) {
		x = x + amountToAdd;
	}
	
	public static void main(String[] args) {
		int a = 15; 
		int b = 10;
		
		MathFunctions.addToInt(b, a);
		System.out.println(a);
	}

}
