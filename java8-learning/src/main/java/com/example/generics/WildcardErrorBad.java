package com.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WildcardErrorBad {

	public static void main(String[] args) {
//		List<? super Number> ints = new ArrayList<>(Arrays.asList(1, 2, 3));
//		foo(ints);
		
//		Integer[] intArray = {1, 2, 3, 4, 5};
//	    List<String> stringList = fromArrayToList(intArray, Object::toString);
//	    System.out.println(stringList);
	    
	    List<?> list = Arrays.asList(1, "1", true, 'Z');
	    printvalues(list);
	}
	
	private static void printvalues(List<?> list) {
		
		for(Object o : list) {
			System.out.println(o.getClass().getSimpleName());
		}
		
	}
	
	private static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
		
		
		System.out.println(mapperFunction);
        return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
    }
	
//	private static <T> void foo(List<? super T> i) {
//        i.add(4);
//        i.set(i.size()-1, 5);
//        i.add(4.4);
//        System.out.println(i);
//    }

}
