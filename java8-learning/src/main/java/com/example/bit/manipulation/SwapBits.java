package com.example.bit.manipulation;

public class SwapBits {
	
	public static void main(String... args) {
		new SwapBits().swapOddEvenBits(100);
	}
	
	public void swapOddEvenBits(int x) {
		
		System.out.println(0x1);
		System.out.println(0xa);
		System.out.println(((x & 0xaaaaaaaa) >> 1));
		System.out.println(((x & 0x55555555) << 1));
		System.out.println("(x & 0xaaaaaaaa) >> 1) : " + ((x & 0xaaaaaaaa) >> 1));
		int result =  ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
		System.out.println("RESULT : " + result);
		
		
		int number = 2;
		int ans = number >> 1;
		System.out.println("number >> 2 = " + ans);
		System.out.println("number >> 2 = " + Integer.toBinaryString(ans));
		
		ans = number << 1;
		System.out.println("number << 2 = " + ans);
		System.out.println("number << 2 = " + Integer.toBinaryString(ans));
		
		int a = 60;          int b = -60;        int c = 0;
	      System.out.println("60  = " + Integer.toBinaryString(a));
	      System.out.println("-60 = " + Integer.toBinaryString(b));

	      //signed shift
	      c = a >> 1;
	      System.out.println("60 >> 1  = " + c);
	      System.out.println("60 >> 1  = " + Integer.toBinaryString(c));

	      //unsigned shift
	      c = a >>> 1;
	      System.out.println("60 >>> 1 = " + c );
	      System.out.println("60 >>> 1 = " + Integer.toBinaryString(c) );

	      c = b >> 1;
	      System.out.println("-60 >> 1  = " + c );
	      System.out.println("-60 >> 1  = " + Integer.toBinaryString(c) );

	      c = b >>> 1;        
	      System.out.println("-60 >>> 1  = " + c );
	      System.out.println("-60 >>> 1 = " + Integer.toBinaryString(c));

	}
}
