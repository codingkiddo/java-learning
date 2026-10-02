package com.example.ds;

import java.util.Arrays;

public class ArraysCopyMain {

	public static void main(String[] args) {

		int[] oldArray = {10, 20, 30, 40, 50};
		printArray(oldArray);
		int index = 2;
		int value = 25;

		int[] newArray = new int[oldArray.length + 1];

		// copy elements before insertion point
		System.arraycopy(oldArray, 0, newArray, 0, index);

		// insert
		newArray[index] = value;

		// copy remaining elements
		System.arraycopy(
		        oldArray,
		        index,
		        newArray,
		        index + 1,
		        oldArray.length - index
		);

		oldArray = newArray;
		printArray(oldArray);
		printArray(newArray);
	}

	private static void printArray(int a[]) {
		Arrays.stream(a).forEach(n -> System.out.print(n + " "));
		System.out.println();
	}
}
