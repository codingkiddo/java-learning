package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchPrefixFrequencyMain {

	public static void main(String[] args) {

//		String products = "Laptop\nSmartphone\nHeadphones\nSmartwatch\nKeyboard\nMouse\nMonitor\nTablet\nCamera\nSpeaker\nLaptop\nHeadphones\nSmartphone\nLaptop\nMouse\nSmartwatch\nHeadphones\nMonitor\nSmartphone\nLaptop";
//		String names[] = products.split("\n");
//		List<String> list = Arrays.asList(names);
//
//		for (String n : list) {
//			System.out.println(n);
//		}
//
//		Function<String, String> function = Function.identity();

		String products = "Smartphone\nSmartwatch\nSmart TV\nLaptop\nSmart Speaker\n"
				+ "Smartphone\nSmartwatch\nSmart TV\nSmartphone\nSmart Light\n"
				+ "Smartwatch\nSmart TV\nSmartphone\nSmart Speaker\nSmartwatch\n"
				+ "Smartphone\nSmart Camera\nSmart TV\nHeadphones\nSmartphone";

		String prefix = "smart";

		Map<String, Long> counts = Arrays.stream(products.split("\n"))
				.filter(name -> name.toLowerCase(Locale.ROOT).startsWith(prefix.toLowerCase(Locale.ROOT)))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		counts.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
				.limit(3).forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

	}

}
