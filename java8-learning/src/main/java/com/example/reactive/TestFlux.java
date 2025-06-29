package com.example.reactive;

import java.util.List;

import reactor.core.publisher.Flux;

public class TestFlux {

	public static void main(String[] args) {

		List<Integer> list = Flux.just(1, 2, 3, 4, 5)
			.filter(n -> n%2==0)
			.map(n -> n*2)
			.log()
			.collectList()
			.block();
		
		System.out.println(list);

	}

}
