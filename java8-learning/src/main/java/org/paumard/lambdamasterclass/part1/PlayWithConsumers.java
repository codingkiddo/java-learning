package org.paumard.lambdamasterclass.part1;

import java.util.function.Consumer;

public class PlayWithConsumers {

	public static void main(String[] args) {
		Consumer<String> consumer = System.out::println;
	}
}
