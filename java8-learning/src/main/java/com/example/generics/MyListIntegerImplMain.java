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
		
		
		Integer iArray[] = new Integer[2];
		iArray[0] = 1; iArray[1] = 2;
		
		Double[] dArray = new Double[2];
		dArray[0] = 1d; dArray[1] = 2d;
		
		String[] sArray = new String[2];
		sArray[0] = "1"; sArray[1] = "2";
		
		Object[] objArray = iArray;
		objArray = dArray;
		System.out.println(objArray instanceof Double[]);
		System.out.println(((Double) objArray[0]).isInfinite());
		objArray = sArray;
		System.out.println(objArray instanceof Double[]);
		System.out.println(((Double) objArray[0]).isInfinite());
		
	}

}
