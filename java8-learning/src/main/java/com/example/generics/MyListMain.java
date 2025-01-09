package com.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface MyList<E> {
	boolean add(E e);
	E get(int index);
}

class MyListImpl<E> implements MyList<E> {

	private Object elementData[] = new Object[16];
	private int size=0;
	
	@Override
	public boolean add(E e) {
		if  ( size <=15 ) {
			elementData[size++] = e;
			return true;
		} else {
			return false;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		return (E) elementData[index];
	}

	@Override
	public String toString() {
		return "MyListImpl [elementData=" + Arrays.toString(elementData) + "]";
	}
}

public class MyListMain {
	public static void main(String[] args) {
//		MyList<Integer> ints = new MyListImpl<>();
//		ints.add(100);
//		Number n1 = 123.123;
//		ints.add(n1);
//		System.out.println(ints.get(0));
//		System.out.println(ints);
		
//		MyList<Number> nums = new MyListImpl<>();
//		nums.add(100);
//		Integer n1 = 123;
//		Double d1 = 0.05;
//		nums.add(n1);
//		nums.add(d1);
//		System.out.println(nums.get(0));
//		System.out.println(nums);
		
		
		MyList<? super Number> nums = new MyListImpl<>();
		nums.add(100);
		Integer n1 = 123;
		Number d1 = 0.05;
		nums.add(n1);
		nums.add(d1);
		System.out.println(nums.get(0));
		System.out.println(nums);
		
		List<? extends String> names = new ArrayList<>();
		names.add("VINOD");
	}
}
