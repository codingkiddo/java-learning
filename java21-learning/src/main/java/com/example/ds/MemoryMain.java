package com.example.ds;

public class MemoryMain {

	public static void main(String[] args) {

		int[] big = new int[100000000 * 1024 * 1024];
		for ( int l = 0; l<100000000 * 1024 * 1024; l++) {
			big[l] = 100000000 * 1024 * 1024;
		}
		System.out.println(big.length);
	}

}
