package com.example.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionInterface {

	public static void main(String[] args) {

		Map<String, Integer> nameMap = new HashMap<>();
		nameMap.put("1", 100);
		System.out.println(nameMap);
		nameMap.computeIfAbsent("2", s -> s.length());
		System.out.println(nameMap);
		nameMap.computeIfPresent("2", (k, s) -> s+1);
		System.out.println(nameMap);
		
		
//		Function<Integer, String> intToString = s -> s.toString();
		Function<Integer, String> intToString = Object::toString;		
		Function<String, String> quote = s -> "'" + s + "'";
		
		Function<Integer, String> quoteIntToString = quote.compose(intToString);
		System.out.println(intToString.apply(5));
		System.out.println(quote.apply("5"));
		System.out.println(quoteIntToString.apply(5));
		
		
	}

	
}
