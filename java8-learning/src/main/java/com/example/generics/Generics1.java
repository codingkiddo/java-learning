package com.example.generics;

import java.util.LinkedList;
import java.util.List;

public class Generics1 {

	public static void main(String[] args) {

		List list = new LinkedList();
		list.add(new Integer(11));
//		Integer i = list.iterator().next();
//		The compiler will require an explicit casting
		Integer i = (Integer) list.iterator().next();
		System.out.println(i);
		
	}

}
