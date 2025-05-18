package com.example.generics.java8;

public class Animal implements Comparable<Animal> {
	protected int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Animal o) {
		return this.age - o.getAge();
	}
}
