package com.baeldung.iteratorguide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CollctionsFrequencyMain {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("A");
		
		System.out.println("A: " + frequency(list, "A"));
		
		
		List<String> values = null;
		System.out.println("A: " + frequency(values, "A"));
	}

	public static int frequency(Collection<?> c, Object o) {
//		Objects.requireNonNull(c);
		
		int result = 0;
		if ( o == null ) {
			for ( Object e : c) {
				if ( e == null) 
					result++;
			}
		} else {
			for ( Object e : c) {
				if ( e.equals(o)) 
					result++;
			}
		}
		return result;
	}
}
