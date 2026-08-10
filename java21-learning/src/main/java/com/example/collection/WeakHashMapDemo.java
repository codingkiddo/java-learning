package com.example.collection;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
	public static void main(String[] args) throws Exception {
		Map<User, String> map = new WeakHashMap<>();

		User user = new User("Vinod");

		map.put(user, "metadata");

		System.out.println("Before null: " + map.size());

		user = null;

		System.gc();

		Thread.sleep(1000);

		System.out.println("After GC: " + map.size());
	}
}

class User {
	String name;

	User(String name) {
		this.name = name;
	}
}