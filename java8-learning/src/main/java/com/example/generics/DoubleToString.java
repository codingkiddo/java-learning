package com.example.generics;

import java.util.IdentityHashMap;

public class DoubleToString {

	public static void main(String[] args) {
		
//		On or before Java8
//		9.999999999999999E22
//		9.999999999999999E22
		System.out.println(1e23);
		System.out.println(Double.toString(1e23));
		
		
		IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
	}

}
