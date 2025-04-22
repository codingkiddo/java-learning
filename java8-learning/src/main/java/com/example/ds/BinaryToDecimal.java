package com.example.ds;

import java.math.BigInteger;

public class BinaryToDecimal {
	static int binaryToDecimal(int n) {
		int num = n;
		int dec_value = 0;

		// Initializing base
		// value to 1, i.e 2^0
		int base = 1;

		int temp = num;
		while (temp > 0) {
			int last_digit = temp % 10;
			temp = temp / 10;

			dec_value += last_digit * base;

			base = base * 2;
		}

		return dec_value;
	}

	static String decToBinary(int n) {
		System.setProperty("file.encoding", "UTF-32");
        StringBuilder bin = new StringBuilder();

        while (n > 0) {
            int bit = n % 2;
            bin.append((char) ('0' + bit));
            n /= 2;
        }

        bin.reverse();
        return bin.toString();
    }

	
	// Driver Code
	public static void main(String[] args) {
		int num = 0010100;
		System.out.println(binaryToDecimal(num));
		System.out.println(Integer.toBinaryString(0));
		BigInteger i = new BigInteger("01010100", 2);
		System.out.println(i);
	}

}
