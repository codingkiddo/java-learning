package com.example.generics;

import java.util.ArrayList;
import java.util.List;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class LowerBoundedWildcards2 {

	public static void main(String[] args) {

		List<Dog> dogs = new ArrayList<Dog>();
		List<? super Cat> cats = new ArrayList<Cat>();
//		
//		add(dogs);
//		add(cats); // NOT OK
		
		List<Animal> animals = new ArrayList<Animal>();
		add(animals);
	}

	private static void add(List<? super Animal> dogs) {
		dogs.add(new Dog());
		dogs.add(new Animal()); 
		dogs.add(new Cat()); 
	}
}
