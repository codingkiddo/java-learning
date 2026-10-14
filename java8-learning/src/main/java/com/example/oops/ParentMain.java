package com.example.oops;

class Parent{

    void instanceMethod() {
        System.out.println("Parent instance method");
    }

    static void staticMethod() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {

    @Override
    void instanceMethod() {
        System.out.println("Child instance method");
    }

    // Hides Parent.staticMethod(); cannot use @Override
    static void staticMethod() {
        System.out.println("Child static method");
    }
}

public class ParentMain {
	public static void main(String[] args) {
		Parent reference = new Child();
		reference.instanceMethod(); // Child instance method
		reference.staticMethod();   // Parent static method
		
		Child child = (Child) reference;
		child.staticMethod();
	}
}