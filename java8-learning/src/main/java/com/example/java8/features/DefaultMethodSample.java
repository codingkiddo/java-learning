package com.example.java8.features;

interface Util {
	default int getNumberOfCore() {
		return helper();
	}

//	As of Java 8 it is not possible. Java 9 onwards 
//	private int helper() {
//		return 4;
//	}
	
	public int helper();
	
	static int foo() {
		return 100;
	}
}

public class DefaultMethodSample {

	public static void main(String[] args) {
		System.out.println(Util.foo());
		System.out.println("Ok");
	}

}
