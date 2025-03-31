package com.example.java8.spliterator;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main01 {

	public static void main(String[] args) {

		List<Article> articles = Stream.generate(() -> new Article("Java"))
				.limit(35000)
				.collect(Collectors.toList());
		
		Spliterator<Article> spliterator = articles.spliterator();
		while (spliterator.tryAdvance( article -> article.setName(article.getName() + " published in medium !!!") )) 
		
		System.out.println(articles.size());
	}

}
