package com.example.hello;

import java.util.List;
import java.util.ArrayList;

public class HelloMain {
	public static void main(String[] args) throws Exception {

		MySQLAccess db = new MySQLAccess();
		db.readDataBase();
		
		System.out.println("Say hello");

		List<String> names = new ArrayList<>();
		names.add("Vinod");
		names.add("Kumar");
		names.add("M");

		names.stream().forEach(name -> System.out.println(name.length()));
	}
}
