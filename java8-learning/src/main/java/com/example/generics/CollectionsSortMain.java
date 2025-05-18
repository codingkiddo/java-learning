package com.example.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.generics.java8.Dog;

public class CollectionsSortMain {

	public static void main(String[] args) {

		Dog d1 = new Dog(111);
		Dog d2 = new Dog(2);
		
		List<Dog> dogs = new ArrayList<>();
		dogs.add(d1);
		dogs.add(d2);

		System.out.println(dogs);
		Collections.sort(dogs);
		System.out.println(dogs);
		
		
//		List<? extends Animal> animals = new ArrayList<Animal>();
//		animals.add(new Dog());
		
//		List<? super Animal> animals = new ArrayList<Animal>();
//		animals.add(d1);
		
	}
	
}
