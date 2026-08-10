package com.example.collection;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationExceptionMain {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("A");
		names.add("B");
		names.add("C");
		
		for ( String name : names ) {
			names.add(name);
		}
	}

}
