package com.example.generics;

//class Calculator<T> {
//	void display(T value) {
//		System.out.println(value);
//	}
//}

//class Calculator<T> {
//	<T> void display(T value) {
//		System.out.println(value);
//	}
//}
//In above case <T> at line 10 hides the <T> at line 9 
//Calculator<Integer> calculator = new Calculator<>();
//calculator.display("Hundred");
//Works without any errors.

// Can also be written as follows
//class Calculator {
//	<T> void display(T value) {
//		System.out.println(value);
//	}
//}

public class Generics2 {
	public static void main(String[] args) {
		Calculator<Integer> calculator = new Calculator<>();
//		calculator.display("Hundred");
	}
}
