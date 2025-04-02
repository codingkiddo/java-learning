package com.example.java8.features;

@FunctionalInterface
public interface PredicateEx<T> {
	public boolean test(T t);
}
