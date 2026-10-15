package com.example.java8.streams;

import java.util.function.Predicate;

public class PredicateMain {

	public static void main(String[] args) {

		Predicate<Boolean> predicateBoolean1 = new Predicate<Boolean>() {
			@Override
			public boolean test(Boolean t) {
				return false;
			}
		};
		
		Predicate<Boolean> predicateBoolean2 = value -> false;
		
		Predicate<Boolean> predicateBoolean3 = new Predicate<Boolean>() {
			
			@Override
			public boolean test(Boolean t) {
				return false;
			}
		};
		
		Predicate<String> startsWithSmart = name -> name.startsWith("Smart");
		
		PredicateMain.test(false);
		PredicateMain.test(new Boolean(true));
		
		PredicateMain.testInt(0);
		PredicateMain.testInt(new Integer(0));
		
	}
	

	private static void testInt(Integer integer1) {
		System.out.println("testInt(Integer integer1) + " + integer1);
	}
	
	private static void testInt(int integer1) {
		System.out.println("testInt(int integer1) + " + integer1);
	}
	
	private static void test(Boolean b1) {
		System.out.println("static test(Boolean b1) + " + b1);
	}
	
    private static void test(boolean b1) {
    	System.out.println("static test(boolean b1) + " + b1);
	}
    
    private void test2(Boolean b1) {
		System.out.println("test2(Boolean b1) + " + b1);
	}
	
    private void test2(boolean b1) {
    	System.out.println("test2(boolean b1) + " + b1);
	}

}
