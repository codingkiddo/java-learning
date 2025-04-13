package com.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//interface MyList<E> {
//	boolean add(E e);
//	boolean addAll(Collection<? extends E> c);
//	E get(int index);
//}

class MyListImpl<E> implements MyList<E> {

	private Object elementData[] = new Object[16];
	private int size=0;

	@Override
	public boolean addAll(Collection<? extends E> c) {
		if  ( ( size+c.size() ) <= 15 ) {
			for ( int i=0; i<c.size(); i++ ) {
				elementData[size++] = null;
			}
			return true;
		} else {
			return false;
		}
	}
	
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
		MyList<Integer> ints = new MyListImpl<>();
		ints.add(100);
		Number n1 = 123.123;
//		ints.add(n1);
		System.out.println(ints.get(0));
		System.out.println(ints);
		Integer integer1 = 123;
		List<? extends Object> numsExt = new ArrayList<>();
		
		List<? extends Object> numsExt2 = new ArrayList<Number>();
		List<? extends Object> numsExt3 = new ArrayList<Integer>();
		List<? extends Object> numsExt4 = new ArrayList<String>();
		
//		List<? extends Number> numsExt = new ArrayList<Number>();
//		numsExt.add(integer1);
		
//		MyList<Number> nums = new MyListImpl<>();
//		nums.add(100);
//		Integer n1 = 123;
//		Double d1 = 0.05;
//		nums.add(n1);
//		nums.add(d1);
//		System.out.println(nums.get(0));
//		System.out.println(nums);
		
		List<? super Number> numsReal1 = new ArrayList<Object>();
		numsReal1.add(1);
		List<? super Number> numsReal2 = new ArrayList<Number>();
		numsReal2.add(1.1);
		List<? super Number> numsReal3 = new ArrayList<>();
		numsReal3.add(1000L);
		
		MyList<? super Number> nums = new MyListImpl<Object>();
		nums.add(100);
		Integer n3 = 123;
		Number d1 = 0.05;
		nums.add(n3);
		nums.add(d1);
		System.out.println(nums.get(0));
		System.out.println(nums);
		
		
	}
}
