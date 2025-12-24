package com.example.java8.streams;

import java.util.function.Consumer;

public class StreamsMain {
	public static void main(String[] args) {
		Consumer<Object> co = new Consumer<Object>() {
			@Override
			public void accept(Object t) {
				System.out.println(t);
			}
		};
		
		Consumer<? super String> cs = co;
		
		display(co, "123");
		display(co, 123);
	}

	private static <T> void display(Consumer<T> action, T value) {
		action.accept(value);
	}
}
