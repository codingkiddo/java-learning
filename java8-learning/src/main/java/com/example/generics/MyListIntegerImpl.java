package com.example.generics;

import java.util.Arrays;

public class MyListIntegerImpl implements MyListInteger {

	private Integer[] integerData = new Integer[16];
	private int size=0;
	
	@Override
	public boolean add(Integer e) {
		if  ( size <=15 ) {
			integerData[size++] = e;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Integer get(int index) {
		return integerData[index];
	}
	
	@Override
	public Object[] toArray() {
        return Arrays.copyOf(integerData, size);
    }

	@Override
	public boolean addAll(MyListInteger c) {
		Object[] a = c.toArray();
        int numNew = a.length;
        arraycopy(a, 0, integerData, size, numNew);
        size += numNew;
        return numNew != 0;
	}

	private static void arraycopy(Object[] src, int srcPos, Object[] dest, int destPos, int length) {
		for(int i=destPos; i<=length; i++) { 
			dest[i] = src[i-1]; 
		}
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		return "MyListIntegerImpl [integerData=" + Arrays.toString(integerData) + "]";
	}

}
