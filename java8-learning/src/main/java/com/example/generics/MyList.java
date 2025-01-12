package com.example.generics;

import java.util.Collection;

public interface MyList<E> {
	boolean add(E e);
	boolean addAll(Collection<? extends E> c);
	E get(int index);
}