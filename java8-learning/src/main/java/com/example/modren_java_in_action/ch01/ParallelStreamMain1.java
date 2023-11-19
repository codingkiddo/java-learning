package com.example.modren_java_in_action.ch01;

import java.util.stream.Stream;

public class ParallelStreamMain1 {

	public static void main(String[] args) {
		ParallelStreamMain1 obj = new ParallelStreamMain1();
		obj.go_stream();
		obj.go_parallel_stream();
	}

	public void go_stream() {
		long sum = Stream.iterate(1, a -> a + 1).limit(1_000_000_000).reduce(0, (a, b) -> a + b);
		System.out.println(sum);
//		System.out.println(Stream.iterate(1,  a -> a + 1));
		System.out.println("<---End--->");
	}
	
	public void go_parallel_stream() {
		long sum = Stream.iterate(1, a -> a + 1).limit(1_000_000_000).parallel().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
//		System.out.println(Stream.iterate(1,  a -> a + 1));
		System.out.println("<---End--->");
	}
}
