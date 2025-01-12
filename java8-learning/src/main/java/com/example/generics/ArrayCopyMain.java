package com.example.generics;

import java.lang.reflect.Array;

class ArrayCopy {
	
	
	
}

//public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
//    @SuppressWarnings("unchecked")
//    T[] copy = ((Object)newType == (Object)Object[].class)
//        ? (T[]) new Object[newLength]
//        : (T[]) Array.newInstance(newType.getComponentType(), newLength);
//    System.arraycopy(original, 0, copy, 0,
//                     Math.min(original.length, newLength));
//    return copy;
//}

public class ArrayCopyMain {

	private static final int DEFAULT_CAPACITY = 10;
	
//	private static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
//		System.out.println((Object)newType);
//		System.out.println((Object)Object[].class);
//		System.out.println((Object)newType == (Object)Object[].class);
//		System.out.println(newType.getComponentType());
//		System.out.println(Array.newInstance(newType.getComponentType(), newLength));
//		System.out.println(Array.newInstance(newType.getComponentType(), newLength) instanceof String[]);
//		System.out.println(Array.newInstance(newType.getComponentType(), newLength).getClass().isArray());
//		
//		Integer[] sourceData = new Integer[5];
//		for(int i=0; i<5; i++) { sourceData[i] = i+100; }
//		
//		Integer[] destData = new Integer[5];
//		
//		arraycopy(sourceData, sourceData.length, destData, destData.length, Math.min(sourceData.length, destData.length));
//		for(int i=0; i<5; i++) { System.out.println(destData[i]); }
//		
//		return null;
//	}
//	
//	private static void arraycopy(Object[] src, int srcPos, Object[] dest, int destPos, int length) {
//		for(int i=0; i<5; i++) { 
//			dest[i] = src[i]; 
//		}
//	}

	
	private static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
		
		Integer[] sourceData = new Integer[5];
		for(int i=0; i<5; i++) { sourceData[i] = i+100; }
		
		Integer[] destData = new Integer[5];
		
		arraycopy(sourceData, sourceData.length, destData, destData.length, Math.min(sourceData.length, destData.length));
		for(int i=0; i<5; i++) { System.out.println(destData[i]); }
		
		return null;
	}
	
	private static void arraycopy(Object[] src, int srcPos, Object[] dest, int destPos, int length) {
		for(int i=0; i<5; i++) { 
			dest[i] = src[i]; 
		}
	}
	
	public static void main(String[] args) {

		Object[] elementData = new Object[DEFAULT_CAPACITY];
		Integer[] integersData = new Integer[DEFAULT_CAPACITY];
		
		copyOf(elementData, DEFAULT_CAPACITY);
		copyOf(integersData, DEFAULT_CAPACITY);
		
	}
	
	private static <T> T[] copyOf(T[] original, int newLength) {
		copyOf(original, newLength, original.getClass());
		return original;
	}
}
