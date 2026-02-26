package com.codingkiddo.time;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortTimes {
	public static void main(String[] args) {
		
		List<String> times = new ArrayList<>(
				List.of("2026-01-23T12:00:00.000Z", "2026-01-22T10:00:00.000Z", "2026-01-23T09:30:00.000Z"));

		times.sort(Comparator.comparing(Instant::parse));
		System.out.println(times);
	}
}
