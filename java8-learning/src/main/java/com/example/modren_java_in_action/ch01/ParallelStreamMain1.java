package com.example.modren_java_in_action.ch01;

import java.util.stream.Stream;

public class ParallelStreamMain1 {

	public static void main(String[] args) {
		new ParallelStreamMain1().go();
	}

	public void go() {
		long sum = Stream.iterate(1, a -> a + 1).limit(1_000_000_000).reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		
		System.out.println(Stream.iterate(1,  a -> a + 1));
		
		System.out.println("<---End--->");
	}
}
