package com.example.threads.basics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableFutureMain {

	public static void main(String[] args) {

		Callable<Integer> task = () -> {
			return 100/0;
		};
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(task);
		try {
			System.out.println("Before - ");
			System.out.println(future.get());
			System.out.println("After - ");
		} catch (InterruptedException | ExecutionException e) {
			executorService.close();
			e.printStackTrace();
		};
		
	}

}
