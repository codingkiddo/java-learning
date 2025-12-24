package com.example.java8.streams;

import java.util.function.Consumer;

public class StreamsMain2 {

	static <T> void use(Consumer<? super T> action, T value) {
		action.accept(value);
	}

	public static void main(String[] args) {
		use(System.out::println, "hi"); // ✅ ok (print(String) or print(Object))
		use(System.out::println, 42); // ✅ ok (print(int) via unboxing)
		use(System.out::println, 3.14); // ✅ ok (print(double))
		
		Object o1 = "100";
		use(System.out::println, o1); // ✅ 

		java.util.function.Consumer<Object> c = System.out::print;
		c.accept("hello");
	}

}
