package com.geeksforgeeks.dynamic_programming;

public class SumOfFibbUsingRecursion {

	private static int sum( int n ) {
		if ( n <= 1) {
			return 1;
		} 
		return sum(n-1) + sum(n-2);
	}
	public static void main(String[] args) {
		int n = 5;
		System.out.println(sum(n));
	}
}
