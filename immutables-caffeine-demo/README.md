# Immutables + Caffeine + Spring Boot

A demo showing how to use **Immutables** for safe value objects and use them
as **Caffeine cache keys** in a Spring Boot REST service.

## Prereqs
- JDK 21+
- Maven 3.9+ (or use the Dockerfile)

## Run (local)

```bash
mvn -q -DskipTests package
java -jar target/immutables-caffeine-demo-0.1.0.jar
```

## Run (Docker)

```bash
docker build -t immutables-caffeine-demo:0.1.0 .
docker run --rm -p 8080:8080 immutables-caffeine-demo:0.1.0
```

## Try it

```bash
curl -s localhost:8080/api/devices/d-1 | jq .
curl -s localhost:8080/actuator/caches | jq .
```

## Notes

- Only `org.immutables:value` is required. There is **no** `org.immutables:jackson` artifact.
- Spring Boot's starter includes Jackson + modules; using `@JsonSerialize/@JsonDeserialize` is enough.
- If you previously tried to resolve `org.immutables:jackson` and Maven cached the failure, force updates or delete the cached path:
  ```bash
  mvn -U clean package
  # or
  rm -rf ~/.m2/repository/org/immutables/jackson
  ```
- Caffeine uses **W-TinyLFU** admission by default. We configure size + TTL in `CacheConfig`.
- `maven-compiler-plugin` sets `parameters=true` to play nicely with Spring 6 argument names.
