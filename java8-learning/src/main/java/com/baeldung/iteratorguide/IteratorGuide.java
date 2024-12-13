package com.baeldung.iteratorguide;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class IteratorGuide {

	public static void main(String[] args) {
		List<String> items = new ArrayList<>();
		items.add("1");
		items.add("2");
		items.add("3");
		items.add("4");
		items.add("5");
		items.add("6");
		items.add("7");
		items.add("8");
		items.add("9");
		items.add("10");
		items.add("11");

		System.out.println(items.stream().mapToInt(e -> Integer.parseInt(e)).sum());
		
		
		IntBinaryOperator op = Integer::sum;
		
		Iterator<String> iterator = items.iterator();
//		while (iterator.hasNext()) {
//			String next = iterator.next();
//			System.out.println(next);
//		}
		System.out.println("<---------> OK");
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
			iterator.remove();
			break;
		}
		System.out.println("<--------->");
		iterator.forEachRemaining(e->System.out.println(e));
		 
	}
}
