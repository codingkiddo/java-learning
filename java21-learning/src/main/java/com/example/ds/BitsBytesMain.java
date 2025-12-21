package com.example.ds;

public class BitsBytesMain {

	public static void main(String[] args) {

		int x = 0B10101000;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(~x|(x-1)));
		
	}

}
