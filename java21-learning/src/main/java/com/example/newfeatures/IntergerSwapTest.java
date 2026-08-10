package com.example.newfeatures;

public class IntergerSwapTest {

	public static void main(String[] args) {

		Integer a = 100;
		Integer b = 200;
		
		System.out.println("Before swap : a=" + a + ", b="+ b);
		swap(a, b);
		System.out.println("After swap : a=" + a + ", b="+ b);
		
	}
	
	static void swap(Integer a, Integer b) {
		
		Integer temp = a;
		a = b;
		b = temp;
		
	}

}
