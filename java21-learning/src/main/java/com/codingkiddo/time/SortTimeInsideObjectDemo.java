package com.codingkiddo.time;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortTimeInsideObjectDemo {

	public static void main(String[] args) {

		List<PeriodEntry> periods = new ArrayList<>();

		PeriodEntry p1 = new PeriodEntry();
		p1.setPeriod("2024-01-23T12:00:00.000Z");
		p1.setWebsite_blocks(List.of(mockWebsiteBlock("www.amazon.com", 14, "category:shopping")));

		PeriodEntry p2 = new PeriodEntry();
		p2.setPeriod("2025-01-22T10:00:00.000Z");
		p2.setWebsite_blocks(List.of(mockWebsiteBlock("www.temu.com", 1, "category:shopping")));

		PeriodEntry p3 = new PeriodEntry();
		p3.setPeriod("2026-01-23T09:30:00.000Z");
		p3.setWebsite_blocks(List.of(mockWebsiteBlock("gum.criteo.com", 10, "category:shopping")));

		PeriodEntry p4 = new PeriodEntry(); // null period example (will go last)
		p4.setPeriod(null);
		p4.setWebsite_blocks(List.of(mockWebsiteBlock("dis.criteo.com", 2, "category:shopping")));

		periods.add(p1);
		periods.add(p2);
		periods.add(p3);
		periods.add(p4);

		System.out.println("Original:");
		periods.forEach(System.out::println);
		
		// 1) Sort objects by time ASC
	    sortPeriodsAscNullLast(periods);
	    System.out.println("\nSorted ASC (by period):");
	    periods.forEach(System.out::println);

	}

	public static void sortPeriodsAscNullLast(List<PeriodEntry> list) {
		Comparator.comparing((PeriodEntry p) -> p.getPeriod() == null ? null : Instant.parse(p.getPeriod()),
				Comparator.nullsLast(Comparator.reverseOrder()));

	}

	public static WebsiteBlock mockWebsiteBlock(String domain, int count, String... categories) {
		WebsiteBlock wb = new WebsiteBlock();
		wb.setDomain(domain);
		wb.setCount(count);
		wb.setCategories(Arrays.asList(categories));
		return wb;
	}

}
