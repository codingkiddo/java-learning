package com.codingkiddo.asm;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureListOfListExample {

    public static void main(String[] args) {

        List<CompletableFuture<List<User>>> usersFutures = List.of(
                CompletableFuture.supplyAsync(() -> List.of(
                        new User(1L, "Alice"),
                        new User(2L, "Bob")
                )),
                CompletableFuture.supplyAsync(() -> List.of(
                        new User(3L, "Charlie"),
                        new User(4L, "David")
                )),
                CompletableFuture.supplyAsync(() -> List.of(
                        new User(5L, "Eve"),
                        new User(6L, "Frank")
                ))
        );

        CompletableFuture<Map<Long, String>> userMapFuture =
                CompletableFuture.allOf(usersFutures.toArray(new CompletableFuture[0]))
                        .thenApply(v ->
                                usersFutures.stream()
                                        .map(CompletableFuture::join)   // List<User>
                                        .flatMap(List::stream)          // User
                                        .collect(Collectors.toMap(
                                                User::getId,
                                                User::getName
                                        ))
                        );

        Map<Long, String> result = userMapFuture.join();

        System.out.println(result);
    }

    static class User {
        private final Long id;
        private final String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}