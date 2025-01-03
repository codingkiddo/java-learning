package com.example.java8.features;

@FunctionalInterface
public interface FunctionalIntWithDefault {

	default String sayHello() {
		return "Hello";
	}
	
	String sayHelloWorld();
}
