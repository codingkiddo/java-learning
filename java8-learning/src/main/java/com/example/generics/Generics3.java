package com.example.generics;

class Calculator<T> {
	void display(T value) {
		System.out.println(value);
	}
}

public class Generics3 {
	public static void main(String[] args) {
		Calculator<Number> calculator = new Calculator<>();
		calculator.display(100);
		
		Number num = 101;
		System.out.println(num);
		
		Number price = 101.111;
		System.out.println(price);
	}
}
