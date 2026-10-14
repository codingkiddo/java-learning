package com.codingkiddo.interview;

public class StringNullShortCircuit {

	public static void main(String[] args) {
		
		String name = null;
		System.out.println(checkNameIsNullOrEmpty(name));
		
	}
	
	private static boolean checkNameIsNullOrEmpty(String name) {
//		return name != null && name.isEmpty();
		return name != null && name.isEmpty();
//		return name != null & name.isEmpty();
	}
}
