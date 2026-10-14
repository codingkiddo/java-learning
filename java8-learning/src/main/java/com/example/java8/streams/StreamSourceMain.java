package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSourceMain {

	public static void main(String[] args) {

		String products = "Laptop\nSmartphone\nHeadphones\nSmartwatch\nKeyboard\nMouse\nMonitor\nTablet\nCamera\nSpeaker\nLaptop\nHeadphones\nSmartphone\nLaptop\nMouse\nSmartwatch\nHeadphones\nMonitor\nSmartphone\nLaptop";
		List<String> names = Arrays.asList(products.split("\n"));
		
		Stream<String> namesStream = names.stream();
		
		Stream<String> pipelineMap = namesStream.map(n -> {
			System.out.println("Before Uppercase : " + n);
			return n.toUpperCase();
		});
		
		Stream<String> pipelineFilter = pipelineMap.filter(n -> {
			System.out.println("Checking: " + n);
			return n.startsWith("S");
		});
		
		System.out.println(pipelineFilter.count());
		
	}

}
