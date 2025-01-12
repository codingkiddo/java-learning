package com.example.generics;

public class MyListIntegerImplMain {

	public static void main(String[] args) {

		MyListInteger list = new MyListIntegerImpl();
		list.add(100);
		System.out.println(list);
		MyListInteger addOn = new MyListIntegerImpl();
		addOn.add(200);
		addOn.add(300);
		list.addAll(addOn);
		System.out.println(list);
		System.out.println(list.size());
		
	}

}
