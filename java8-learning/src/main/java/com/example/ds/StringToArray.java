package com.example.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringToArray {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("Vinod");
		names.add("Kumar");
		
		String[] to = names.toArray(new String[0]);
		Arrays.asList(to).stream().forEach(s -> System.out.println(s));
		System.out.println(to.length);
		
	}

}
