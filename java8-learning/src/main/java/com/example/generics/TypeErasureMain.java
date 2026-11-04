package com.example.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureMain {

	public static void main(String[] args) {

		List<Integer> integers = new ArrayList<Integer>();
		List<? extends Number> numbers = integers;
		
	}

}
