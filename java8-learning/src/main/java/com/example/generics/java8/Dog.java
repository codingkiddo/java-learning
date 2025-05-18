package com.example.generics.java8;

//public class Dog extends Animal implements Comparable<Dog> {
public class Dog extends Animal {
	
	public Dog(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Dog [age=" + age + "]";
	}
	
}

