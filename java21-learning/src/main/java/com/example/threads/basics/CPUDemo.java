package com.example.threads.basics;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class CPUDemo {

	public static void main(String[] args) {
		
		int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors = " + processors);
        System.out.println("ForkJoinPool common parallelism = " + ForkJoinPool.getCommonPoolParallelism());
        
        long start = System.currentTimeMillis();
        
        long sum = IntStream.rangeClosed(1, 10_00_000).parallel()
        		.mapToLong(i -> {
        			System.out.println("Task " + i + " running on " + Thread.currentThread().getName());
        			busyWork();
        			return i;
        		}).sum();

        long end = System.currentTimeMillis();
        
        System.out.println("Sum = " + sum);
        System.out.println("Time = " + (end - start) + " ms");
	}

	private static void busyWork() {
		long x = 0;
		for ( int i=0; i<50_00_000; i++) {
			x += i;
		}
		if ( x == -1) {
			System.out.println("Impossible");
		}
	}
}
