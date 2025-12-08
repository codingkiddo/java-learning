package com.codingkiddo.streams;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

/**
 * Run with:
 *   mvn -q -DskipTests package
 *   java -jar target/java8-streams-examples-1.0.0-jar-with-dependencies.jar
 */
public class StreamPlayground {

    // ==== Model types ====
    public static class Sale {
        public final String region, product;
        public final int units;
        public Sale(String region, String product, int units) {
            this.region = region; this.product = product; this.units = units;
        }
        @Override public String toString(){ return region + ":" + product + "=" + units; }
    }

    public static class User { public final int id; public final String name; public User(int id,String name){this.id=id;this.name=name;} }
    public static class Order { public final int userId; public final String item; public Order(int userId,String item){this.userId=userId;this.item=item;} }

    // ==== Utilities ====
    @SafeVarargs
    public static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
        Set<List<?>> seen = ConcurrentHashMap.newKeySet();
        return t -> {
            List<?> keys = Arrays.stream(keyExtractors).map(f -> f.apply(t)).collect(toList());
            return seen.add(keys);
        };
    }

    public static Collector<Integer, List<Integer>, Double> medianCollector() {
        return Collector.of(
            ArrayList::new,
            List::add,
            (left, right) -> { left.addAll(right); return left; },
            list -> {
                if (list.isEmpty()) return Double.NaN;
                Collections.sort(list);
                int n = list.size(), mid = n/2;
                return (n % 2 == 1) ? list.get(mid)
                        : (list.get(mid-1) + list.get(mid)) / 2.0;
            }
        );
    }

    // ==== Data ====
    private static List<Sale> sales() {
        return Arrays.asList(
            new Sale("APAC","Laptop", 12),
            new Sale("APAC","Phone", 35),
            new Sale("APAC","Tablet", 17),
            new Sale("EMEA","Laptop", 22),
            new Sale("EMEA","Phone", 9),
            new Sale("EMEA","Tablet", 41),
            new Sale("AMER","Laptop", 27),
            new Sale("AMER","Phone", 33),
            new Sale("AMER","Tablet", 19)
        );
    }

    public static void main(String[] args) throws Exception {
        System.out.println("== Java 8 Streams Complex Examples ==");
        exampleMultiLevelGroupingTopK();
        exampleGroupingSummaryStats();
        exampleWindowing();
        exampleLeftJoin();
        exampleToMapMerging();
        exampleMedianCollector();
        exampleDistinctByMultipleFields();
        exampleFileTreeStreaming();
        exampleBigDecimalParallelReduction();
        exampleBatching();
        System.out.println("== Done ==");
    }

    // 1) Multi-level grouping with Top-K per group
    static void exampleMultiLevelGroupingTopK() {
        List<Sale> sales = sales();
        Map<String, List<Sale>> topKByRegion =
            sales.stream().collect(groupingBy(s -> s.region,
                collectingAndThen(
                    toCollection(() -> new TreeSet<>(
                        Comparator.<Sale>comparingInt(s -> s.units).reversed()
                                  .thenComparing(s -> s.product))),
                    ts -> ts.stream().limit(2).collect(toList())
                )));
        System.out.println("[Top-2 by region] " + topKByRegion);
    }

    // 2) Grouping + summary statistics
    static void exampleGroupingSummaryStats() {
        List<Sale> sales = sales();
        Map<String, IntSummaryStatistics> statsByRegion =
            sales.stream().collect(groupingBy(s -> s.region, summarizingInt(s -> s.units)));
        statsByRegion.forEach((r, st) ->
            System.out.println("[Stats] " + r + " avg=" + st.getAverage() + " max=" + st.getMax()));
    }

    // 3) Windowing with indices (pairs & triples)
    static void exampleWindowing() {
        List<Integer> nums = Arrays.asList(3, 5, 8, 13, 21, 34);
        List<int[]> pairs = IntStream.range(0, nums.size() - 1)
            .mapToObj(i -> new int[]{ nums.get(i), nums.get(i+1) })
            .collect(toList());

        List<List<Integer>> triples = IntStream.range(0, nums.size() - 2)
            .mapToObj(i -> Arrays.asList(nums.get(i), nums.get(i+1), nums.get(i+2)))
            .collect(toList());

        System.out.println("[Pairs] " + pairs.stream().map(p -> "(" + p[0] + "," + p[1] + ")").collect(joining(", ")));
        System.out.println("[Triples] " + triples);
    }

    // 4) Left join between two collections
    static void exampleLeftJoin() {
        List<User> users = Arrays.asList(new User(1,"Ana"), new User(2,"Ben"), new User(3,"Cid"));
        List<Order> orders = Arrays.asList(new Order(1,"Book"), new Order(1,"Pen"), new Order(3,"Bag"));
        Map<Integer, List<Order>> ordersByUser = orders.stream().collect(groupingBy(o -> o.userId));

        List<String> userOrdersLeft = users.stream()
            .flatMap(u -> {
                List<Order> os = ordersByUser.getOrDefault(u.id, Collections.emptyList());
                return os.isEmpty()
                    ? Stream.of(u.name + " -> <no orders>")
                    : os.stream().map(o -> u.name + " -> " + o.item);
            }).collect(toList());
        System.out.println("[Left Join] " + userOrdersLeft);
    }

    // 5) Robust toMap with merging + order preservation
    static void exampleToMapMerging() {
        List<Sale> sales = sales();
        Map<String, Integer> unitsByProduct =
            sales.stream().collect(toMap(
                s -> s.product,
                s -> s.units,
                Integer::sum,
                LinkedHashMap::new
            ));
        System.out.println("[toMap merge] " + unitsByProduct);
    }

    // 6) Custom Collector: median
    static void exampleMedianCollector() {
        List<Integer> nums = Arrays.asList(3, 5, 8, 13, 21, 34);
        double median = nums.stream().collect(medianCollector());
        System.out.println("[Median] " + median);
    }

    // 7) Distinct by multiple fields
    static void exampleDistinctByMultipleFields() {
        List<Sale> sales = new ArrayList<>(sales());
        sales.add(new Sale("APAC","Laptop", 999)); // duplicate key pair (region, product)
        List<Sale> distinct = sales.stream()
            .filter(distinctByKeys(s -> s.region, s -> s.product))
            .collect(toList());
        System.out.println("[Distinct(region,product)] size=" + distinct.size());
    }

    // 8) File tree streaming + content aggregation
    static void exampleFileTreeStreaming() {
        try {
            Path root = Paths.get(".");
            long totalJavaLines = Files.walk(root)
                .filter(p -> p.toString().endsWith(".java"))
                .flatMap(p -> {
                    try { return Files.lines(p); } catch (IOException e) { return Stream.<String>empty(); }
                })
                .count();
            System.out.println("[FileStats] total .java lines under '.' = " + totalJavaLines);
        } catch (IOException e) {
            System.out.println("[FileStats] skipped: " + e.getMessage());
        }
    }

    // 9) Parallel reduction with BigDecimal (associative combiner)
    static void exampleBigDecimalParallelReduction() {
        List<BigDecimal> money = Arrays.asList(
            new BigDecimal("10.10"),
            new BigDecimal("20.30"),
            new BigDecimal("0.60")
        );
        BigDecimal sum = money.parallelStream()
            .reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add);
        System.out.println("[BigDecimal sum] " + sum);
    }

    // 12) Fixed-size batching
    static void exampleBatching() {
        List<Integer> big = IntStream.rangeClosed(1, 23).boxed().collect(toList());
        int batchSize = 5;
        List<List<Integer>> batches = IntStream.iterate(0, i -> i + batchSize)
            .limit((big.size() + batchSize - 1) / batchSize)
            .mapToObj(i -> big.subList(i, Math.min(i + batchSize, big.size())))
            .collect(toList());
        System.out.println("[Batches] " + batches);
    }
}
