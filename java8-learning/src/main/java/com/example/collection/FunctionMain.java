package com.example.collection;

import java.util.function.Function;

public class FunctionMain {

	public static void main(String[] args) {

		Function<Integer, Integer> fn = Function.<Integer>identity();
		System.out.println(fn);
		
	}

}
