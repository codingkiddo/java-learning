package com.example.java8.streams;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MiniCollectors {

	private MiniCollectors() {
    }
	
	BiConsumer<Integer, Integer> biConsumer = new BiConsumer<Integer, Integer>() {
		@Override
		public void accept(Integer t, Integer u) {
			System.out.println("Bi");
		}
	};

	public static <T> MiniCollector<T, long[], Long> counting() {
		return new MiniCollector<T, long[], Long>() {

			@Override
			public Supplier<long[]> supplier() {
				return () -> new long[1];
			}

			@Override
			public BiConsumer<long[], T> accumulator() {
				return (counter, element) -> counter[0]++;
			}

			@Override
			public Function<long[], Long> finisher() {
				return counter -> counter[0];
			}
		};
	}
	
	
}
