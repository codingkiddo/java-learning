package com.example.java8.streams;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class MiniStream<T> {

	private final T source;
	private boolean consumed;

	private MiniStream(Iterable<T> source) {
		this.source = Objects.requireNonNull(source);
	}

	public static <T> MiniStream<T> from(Iterable<T> source) {
		return new MiniStream<>(source);
	}

	public void forEach(Consumer<? super T> action) {
		Objects.requireNonNull(action);
		if (consumed) {
			throw new IllegalStateException("Stream has already been consumed");
		}
		consumed = true;
		Iterator<T> iterator = source.iterator();
		while (iterator.hasNext() ) {
			T element = iterator.next();
			action.accept(element);
		}
 	}
}
