package com.example.collection;

import java.util.ArrayList;
import java.util.List;

public class SubListTest {

	public static void main(String[] args) {

		List<Integer> ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		
		List<Integer> subLists = ints.subList(0, 0);
				
		System.out.println(subLists);
		
		subLists.addAll(List.of(10, 11, 12));
		
		System.out.println(ints);
	}

}
