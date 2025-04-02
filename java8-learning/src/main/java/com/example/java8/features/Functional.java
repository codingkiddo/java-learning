package com.example.java8.features;

@FunctionalInterface
public interface Functional<T, R> {
	R apply(T t);
}
