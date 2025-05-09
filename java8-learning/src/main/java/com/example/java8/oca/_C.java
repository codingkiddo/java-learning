package com.example.java8.oca;

public class _C {

	private static int $;
	
	public static void main(String[] args) {
//		The local variable a_b may not have been initialized
		String a_b = null;
		System.out.println($);
		System.out.println(a_b);
		
	}

}

//1. What is the result of the following class? (Choose all that apply)
//1: public class _C {
//2: private static int $;
//3: public static void main(String[] main) {
//4: String a_b;
//5: System.out.print($);
//6: System.out.print(a_b);
//7: } }
//A. Compiler error on line 1.
//B. Compiler error on line 2.
//C. Compiler error on line 4.
//D. Compiler error on line 5.
//E. Compiler error on line 6.
//F. 0null
//G. nullnull

// Answer is E. Compiler error on line 6. The local variable a_b may not have been initialized