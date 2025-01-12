package com.example.generics;

import java.lang.reflect.Array;


//public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
//    @SuppressWarnings("unchecked")
//    T[] copy = ((Object)newType == (Object)Object[].class)
//        ? (T[]) new Object[newLength]
//        : (T[]) Array.newInstance(newType.getComponentType(), newLength);
//    System.arraycopy(original, 0, copy, 0,
//                     Math.min(original.length, newLength));
//    return copy;
//}

public class ArrayCopyMain2 {

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
		
		@SuppressWarnings("unchecked")
		 T[] copy = ((Object)newType == (Object)Object[].class)
		            ? (T[]) new Object[newLength]
		            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
		
		arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
		
		return copy;
	}
	
	private static void arraycopy(Object[] src, int srcPos, Object[] dest, int destPos, int length) {
		for(int i=0; i<5; i++) { 
			dest[i] = src[i]; 
		}
	}
	
	public static void main(String[] args) {

		Integer[] sourceData = new Integer[5];
		for(int i=0; i<5; i++) { sourceData[i] = i+100; }
		
		Object[] copy =  copyOf(sourceData, sourceData.length, sourceData.getClass());
		for(int i=0; i<5; i++) { System.out.println(copy[i]); }
		
	}
	
}
