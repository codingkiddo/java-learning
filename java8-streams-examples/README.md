# Java 8 Streams — Complex Examples

## Run
```bash
# In project root:
mvn -q -DskipTests package
java -jar target/java8-streams-examples-1.0.0-jar-with-dependencies.jar
```

## Test
```bash
mvn -q test
```

## What’s inside
- Multi-level grouping with Top‑K per group
- Downstream collectors + summary stats
- Windowing (pairs/triples)
- Left join using maps + flatMap
- Robust toMap with merge + LinkedHashMap
- Custom median collector
- Distinct by multiple fields
- File tree streaming
- Parallel BigDecimal reduction
- Fixed-size batching
