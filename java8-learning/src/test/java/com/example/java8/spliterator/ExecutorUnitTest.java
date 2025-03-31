package com.example.java8.spliterator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorUnitTest {

	Article article;

	@Before
	public void init() {
		article = new Article(Arrays.asList(new Author("Ahmad", 0), new Author("Eugen", 0), new Author("Alice", 1),
				new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0),
				new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0),
				new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1),
				new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1),
				new Author("Mike", 0), new Author("Michał", 0), new Author("Loredana", 1)), 0);
	}

	@Test
    public void givenAStreamOfIntegers_whenProcessedSequentialCustomSpliterator_countProducesRightOutput() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        
        CustomSpliterator customSpliterator = new CustomSpliterator(numbers);
        AtomicInteger sum = new AtomicInteger();
        
        customSpliterator.forEachRemaining(sum::addAndGet);
        
        assertThat(sum.get()).isEqualTo(15);
	}
}
