package com.example.java8.methodref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;

import com.google.common.math.IntMath;


public class MethodRef01 {

	public static void main(String[] args) {

		List<Integer> integers = new ArrayList<>();
		integers.add(1); integers.add(2); integers.add(3);
		
//		Consumer<Integer> action = ( number ) -> {
//			IntMath.pow(number, 2); 
//		};
		
		Consumer<Integer> action = System.out::println;
		integers.forEach(action);
		
//		System.out.println(integers);
//		
//		List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
//		messages.forEach(word -> StringUtils.capitalize(word));
//		System.out.println(messages);
		
		System.out.println();
		
	}

}
