package com.example.java8.features;

@FunctionalInterface
public interface FunctionalEx<T, R> {
	public R apply(T t) throws Exception; 
}
