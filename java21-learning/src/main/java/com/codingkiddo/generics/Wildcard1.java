package com.codingkiddo.generics;

import java.lang.constant.Constable;
import java.util.List;

public class Wildcard1 {

	public static void main(String[] args) {
		Integer n1 = 100;
		System.out.println(n1.describeConstable().get());;
		List<Integer> numbers = List.of(1, 2, 3);
		printNumberWithType(numbers);
	}

	private static void addNumber(List<? super Integer> nums) {
		nums.add(100);
	}
	
//	private static <T extends Number> void printNumberWithType(List<T> nums) {
//		System.out.println(nums.get(0).describeConstable().get()); // ❌ Won't compile!
//	}
	
	private static <T extends Number & Constable> void printNumberWithType(List<T> nums) {
	    nums.get(0).describeConstable().get(); // ✅ now compiler knows T has it
	}

	void print(List<String> list) {}
	void print(List<Integer> list) {} // ❌ same after erasure
}
