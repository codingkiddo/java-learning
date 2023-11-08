package com.example.bit.manipulation;

class GFG {
	public static void main(String[] args) {
		int number = -2;

//		 2 bit left shift operation
//		int ans = number << 2;
//		System.out.println(ans);

//		2 bit right shift operation
		System.out.println(number);
		System.out.println("Integer.toBinaryString(number): " + Integer.toBinaryString(number));
		System.out.println("Integer.toUnsignedString(-1): " + Integer.toUnsignedString(-1));
		System.out.println("Integer.toUnsignedString(number): " + Integer.toUnsignedString(number));
		System.out.println("Integer.toUnsignedString(1): " + Integer.toUnsignedString(1));
		System.out.println("Integer.toUnsignedString(2): " + Integer.toUnsignedString(2147483647));
		System.out.println(2147483647);
//		System.out.println(Math.pow(2, 16));
		
		int total = 1;
		for ( int i=1; i<=31; i++ ) {
			total = total * 2;
		}
		System.out.println(total);
		int ans = number >> 1;
		System.out.println(Integer.toBinaryString(ans));
		System.out.println(ans);
		ans = number >> 1;
		System.out.println(Integer.toBinaryString(ans));
		System.out.println(ans);

		String bits = "11111111111111111111111111111111";
		System.out.println("Length: " + bits.length());
		
	}
}