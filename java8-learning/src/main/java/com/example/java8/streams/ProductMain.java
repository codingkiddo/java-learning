package com.example.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductMain {

	public static void main(String[] args) {

		String products = "Smartphone\nLaptop\nSmartwatch\nHeadphones";

		String prefix = "smart";
		String normalizedPrefix = prefix.toLowerCase(Locale.ROOT);

		MiniStream<String> source = MiniStream.of(products.split("\n"));

		MiniStream<String> filtered = source.filter(name -> {
			System.out.println("Checking: " + name);

			return name.toLowerCase(Locale.ROOT).startsWith(normalizedPrefix);
		});

		System.out.println("Pipeline created");

		filtered.forEach(name -> System.out.println("Accepted: " + name));

		MiniStream.of(products.split("\n")).filter(name -> name.startsWith("Smart")).filter(name -> name.length() > 8)
				.forEach(System.out::println);
		
		
		System.out.println("===================================");
		
		List<String> matches = MiniStream.of(products.split("\n")).filter(name -> {
			System.out.println("Checking: " + name);

			return name.toLowerCase(Locale.ROOT).startsWith(normalizedPrefix);
		}).collect(() -> new ArrayList<String>(), (list, name) -> list.add(name));
		System.out.println("Result: " + matches);
		
		System.out.println("===================================");
		
		long count = MiniStream.of(products.split("\n"))
	            .filter(name -> {
	                System.out.println("Checking: " + name);

	                return name.toLowerCase(Locale.ROOT)
	                    .startsWith(normalizedPrefix);
	            })
	            .collect(MiniCollectors.counting());

	        System.out.println("Matching products: " + count);

	}

}
