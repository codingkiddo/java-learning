package com.example.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerCompare {

	public static void main(String[] rgs) {
		
		Integer i1 = 130;
		Integer i2 = 130;
		
		System.out.println(i1 == i2);
		
		Integer n1 = 2000;
		Integer n2 = 2000;
		
		System.out.println(n1 == n2);
		

		List<Building> buildings = new ArrayList<>();
		buildings.add(new Building());
		Collections.sort(buildings);
	}
}
