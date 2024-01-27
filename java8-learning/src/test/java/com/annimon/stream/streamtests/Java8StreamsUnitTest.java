package com.annimon.stream.streamtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class Java8StreamsUnitTest {

	private static List<String> list;

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
    public void checkStreamCount_whenOperationMap_thanCorrect() {
        

        List<Detail> details = new ArrayList<>();
        details.add(new Detail());
        details.add(new Detail());
        List<String> streamFlatMap = details.stream().flatMap(detail -> detail.getParts().stream()).collect(Collectors.toList());
        System.out.println(streamFlatMap);
    }
}
