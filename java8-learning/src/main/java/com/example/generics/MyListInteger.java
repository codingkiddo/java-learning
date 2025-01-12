package com.example.generics;

public interface MyListInteger {
	boolean add(Integer e);
	Integer get(int index);
	boolean addAll(MyListInteger c);
	Object[] toArray();
	int size();
}