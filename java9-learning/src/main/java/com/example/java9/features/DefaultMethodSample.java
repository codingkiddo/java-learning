package com.example.java9.features;

interface Util {
	default int getNumberOfCore() {
		return helper();
	}
//  Java 9 supports private functions in Interface.
	private int helper() {
		return 4;
	}
	
	public static int foo() {
		return fooHelper();
	}
	
	private static int fooHelper() {
		return 100;
	}
}

public class DefaultMethodSample {
	public static void main(String[] args) {
		System.out.println("Ok");
	}
}
