# Java 8 Streams + MySQL Sakila

Run analytical queries against Sakila using **Java 8 Streams** on top of **JDBC**.

## Run
```bash
mvn -q -DskipTests package
java -DDB_URL="jdbc:mysql://localhost:3306/sakila?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useCursorFetch=true&defaultFetchSize=500"      -DDB_USER=root -DDB_PASS=root      -jar target/sakila-streams-java8-1.0.0-jar-with-dependencies.jar
```

## Docker MySQL (optional)
```yaml
# docker-compose.yml
services:
  mysql:
    image: mysql:8.0
    container_name: sakila-mysql
    ports: ["3306:3306"]
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: sakila
    volumes:
      - ./docker/init:/docker-entrypoint-initdb.d
```
Put `sakila-schema.sql` and `sakila-data.sql` in `docker/init/` and restart the container.

## Examples included
- Top actors by rentals
- Revenue per store per month
- Top categories by revenue
- Average rental duration by category
- Top co‑star pairs
- Top films by revenue
- Dormant customers (no rentals in last 6 months)
