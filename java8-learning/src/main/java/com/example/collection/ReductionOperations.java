package com.example.collection;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReductionOperations {

	public static void main(String[] args) {

		int[] nums = { 2, 6, 4, 2, 8, 9, 3 };

		List<Integer> numbers = new ArrayList<Integer>(nums.length);
		for (Integer n : nums) {
			numbers.add(n);
		}

		int sum = 0;
		for (int x : numbers) {
			sum += x;
		}
		System.out.println("SUM: " + sum);

		sum = numbers.stream().reduce(0, (x, y) -> x + y);
		System.out.println("SUM: " + sum);

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		sum = list.stream().reduce(0, (x, y) -> {
			System.out.println(String.format("x=%d,y=%d", x, y));
			return x + y;
		});
		System.out.println("SUM: " + sum);
		
		Integer[] array = {11, 14, 17, 11, 48, 33, 29, 11, 17, 22, 11, 48, 18};
		System.out.println(Arrays.stream(array).collect(Collectors.groupingBy(p->p, Collectors.counting())));
		
		Arrays.stream(array).collect(Collectors.groupingBy(p -> p, Collectors.counting()))
        .entrySet().stream().filter(t -> t.getValue() > 1)
        .forEach(key -> System.out.println(key.getKey() + ": " + key.getValue()));
		
		System.out.println(Arrays.stream(array).collect(Collectors.toSet()));
		
		Arrays.stream(array).collect(Collectors.toSet())
		  .stream()
		  .map(v -> new SimpleEntry<>(v, Collections.frequency(list, v)))
		  .filter(v -> v.getValue() > 1)
		  .forEach(v -> System.out.println(v.getKey() + "::" + v.getValue()));

		Map<Integer, Long> occurrences = Arrays.stream(array)
			    .collect(Collectors.groupingBy(
			        Function.identity(), 
			        Collectors.counting()));

		System.out.println(occurrences);
	}

}
