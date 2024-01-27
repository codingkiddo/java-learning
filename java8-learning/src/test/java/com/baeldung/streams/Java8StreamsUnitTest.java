package com.baeldung.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Java8StreamsUnitTest {

	private static List<String> list;

	@Test
	public void test() {
		assertEquals("A", "A");
	}

	@BeforeAll
	public static void init() {
		list = new ArrayList<>();
		list.add("One");
		list.add("OneAndOnly");
		list.add("Derek");
		list.add("Change");
		list.add("factory");
		list.add("justBefore");
		list.add("Italy");
		list.add("Italy");
		list.add("Thursday");
		list.add("");
		list.add("");
	}

	@Test
	public void checkStreamCount_whenCreating_givenDifferentSources() {
		String[] arr = new String[] { "a", "b", "c" };
		Stream<String> streamArr = Arrays.stream(arr);
		assertEquals(streamArr.count(), 3);

		long count = list.stream().distinct().count();
		assertEquals(count, 9);

		System.out.println(list);
		System.out.println(list.stream().collect(Collectors.toList()));
		System.out.println(list.stream().distinct().collect(Collectors.toList()));
	}

	@Test
	public void checkStreamCount_whenOperationFilter_thanCorrect() {
		System.out.println("<------  checkStreamCount_whenOperationFilter_thanCorrect  ------>");
		Collection<String> result = list.stream().filter(s -> s.isEmpty()).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(result);
		System.out.println("<------  checkStreamCount_whenOperationFilter_thanCorrect  ------>");
	}

	@Test
	public void checkStreamCount_whenOperationMap_thanCorrect() {
		System.out.println("<------  checkStreamCount_whenOperationMap_thanCorrect  ------>");
		List<String> uris = new ArrayList<>();
		uris.add("C:\\My.txt");
		
		Stream<Path> streamMap = uris.stream().map(uri -> Paths.get(uri));
		assertEquals(streamMap.count(), 1);

		List<Detail> details = new ArrayList<>();
		details.add(new Detail());
		details.add(new Detail());
		List<String> result = new ArrayList<>();
		result.add("A");
		System.out.println(details.stream().flatMap(detail -> detail.getParts().stream()).collect(Collectors.toList()));
		details.stream().map(detail -> detail.getParts().stream()).forEach(s->s.map(str->result.add(str)));
		System.out.println(result);
	}
}
