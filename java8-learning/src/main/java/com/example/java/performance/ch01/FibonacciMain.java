package com.example.java.performance.ch01;

public class FibonacciMain {

	public static void main(String[] args) {
		FibonacciMain obj = new FibonacciMain();
		obj.doTest();
	}

	private void doTest() {
//		Main loop
		double l;
		int nWarmups = 50;
		for (int i = 0; i < nWarmups; i++) {
			l = fibImpl1(1000);
		}
		long then = System.currentTimeMillis();
		for (int i = 0; i < nWarmups; i++) {
			l = fibImpl1(1000);
		}
		long now = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (now - then));
	}

	private int fibImpl1(int n) {
		if (n < 0) {
			return 0;
		}
		int fib[] = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
//		Initialize the result
		int sum = fib[0] + fib[1];
//		Add remaining terms
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
			sum = +fib[i];
		}
		return sum;
//		
	}
}
