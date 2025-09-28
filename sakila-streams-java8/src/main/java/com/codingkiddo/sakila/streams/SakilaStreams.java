package com.codingkiddo.sakila.streams;

import java.sql.*;
import java.sql.Date;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class SakilaStreams {

	static class Actor {
		final int id;
		final String firstName, lastName;

		Actor(int id, String f, String l) {
			this.id = id;
			this.firstName = f;
			this.lastName = l;
		}
	}

	static class Film {
		final int id;
		final String title;

		Film(int id, String title) {
			this.id = id;
			this.title = title;
		}
	}

	static class FilmActor {
		final int filmId, actorId;

		FilmActor(int filmId, int actorId) {
			this.filmId = filmId;
			this.actorId = actorId;
		}
	}

	static class Category {
		final int id;
		final String name;

		Category(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}

	static class FilmCategory {
		final int filmId, categoryId;

		FilmCategory(int filmId, int categoryId) {
			this.filmId = filmId;
			this.categoryId = categoryId;
		}
	}

	static class Customer {
		final int id;
		final String firstName, lastName;
		final int storeId;

		Customer(int id, String f, String l, int s) {
			this.id = id;
			this.firstName = f;
			this.lastName = l;
			this.storeId = s;
		}
	}

	static class RentalRow {
		final int rentalId, filmId, storeId, customerId;
		final Timestamp rentalDate, returnDate;
		final double amount;

		RentalRow(int rentalId, int filmId, int storeId, int customerId, Timestamp rentalDate, Timestamp returnDate,
				double amount) {
			this.rentalId = rentalId;
			this.filmId = filmId;
			this.storeId = storeId;
			this.customerId = customerId;
			this.rentalDate = rentalDate;
			this.returnDate = returnDate;
			this.amount = amount;
		}
	}

	interface RowMapper<T> {
		T map(ResultSet rs) throws SQLException;
	}

	static <T> Stream<T> streamQuery(Connection c, String sql, RowMapper<T> mapper, Object... params) {
		try {
			final PreparedStatement ps = c.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			try {
				ps.setFetchSize(500);
			} catch (Exception ignored) {
			}
			for (int i = 0; i < params.length; i++)
				ps.setObject(i + 1, params[i]);
			final ResultSet rs = ps.executeQuery();

			Spliterator<T> spliterator = new Spliterators.AbstractSpliterator<T>(Long.MAX_VALUE,
					Spliterator.ORDERED | Spliterator.NONNULL) {
				boolean fetched = false;
				boolean has = false;

				void fetch() {
					if (fetched)
						return;
					try {
						has = rs.next();
						fetched = true;
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}

				@Override
				public boolean tryAdvance(java.util.function.Consumer<? super T> action) {
					fetch();
					if (!has)
						return false;
					fetched = false;
					try {
						action.accept(mapper.map(rs));
						return true;
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
			};
			return StreamSupport.stream(spliterator, false).onClose(() -> {
				try {
					rs.close();
				} catch (Exception ignored) {
				}
				try {
					ps.close();
				} catch (Exception ignored) {
				}
			});
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	static Connection open() throws Exception {
		String url = System.getProperty("DB_URL", System.getenv().getOrDefault("DB_URL",
				"jdbc:mysql://localhost:3306/sakila?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useCursorFetch=true&defaultFetchSize=500"));
		String user = System.getProperty("DB_USER", System.getenv().getOrDefault("DB_USER", "root"));
		String pass = System.getProperty("DB_PASS", System.getenv().getOrDefault("DB_PASS", "root"));
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, pass);
	}

	public static void main(String[] args) throws Exception {
		try (Connection c = open()) {
			System.out.println("Connected: " + c.getMetaData().getURL());

			Map<Integer, Actor> actorById = streamQuery(c, "SELECT actor_id, first_name, last_name FROM actor",
					rs -> new Actor(rs.getInt(1), rs.getString(2), rs.getString(3))).collect(toMap(a -> a.id, a -> a));

			Map<Integer, Film> filmById = streamQuery(c, "SELECT film_id, title FROM film",
					rs -> new Film(rs.getInt(1), rs.getString(2))).collect(toMap(f -> f.id, f -> f));

			Map<Integer, String> categoryNameById = streamQuery(c, "SELECT category_id, name FROM category",
					rs -> new Category(rs.getInt(1), rs.getString(2))).collect(toMap(cat -> cat.id, cat -> cat.name));

			Map<Integer, Set<Integer>> actorIdsByFilm = streamQuery(c, "SELECT film_id, actor_id FROM film_actor",
					rs -> new FilmActor(rs.getInt(1), rs.getInt(2)))
					.collect(groupingBy(fa -> fa.filmId, mapping(fa -> fa.actorId, toSet())));

			Map<Integer, Set<Integer>> categoryIdsByFilm = streamQuery(c,
					"SELECT film_id, category_id FROM film_category",
					rs -> new FilmCategory(rs.getInt(1), rs.getInt(2)))
					.collect(groupingBy(fc -> fc.filmId, mapping(fc -> fc.categoryId, toSet())));

			Stream<RentalRow> rentals = streamQuery(c,
					"SELECT r.rental_id, i.film_id, i.store_id, r.customer_id, r.rental_date, r.return_date, "
							+ "       COALESCE((SELECT p.amount FROM payment p WHERE p.rental_id = r.rental_id LIMIT 1), 0) AS amount "
							+ "FROM rental r JOIN inventory i ON r.inventory_id = i.inventory_id",
					rs -> new RentalRow(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getTimestamp(6), rs.getDouble(7)));

			// 1) Top-10 actors by rentals
			List<String> topActorsByRentals = rentals
					.flatMap(rr -> actorIdsByFilm.getOrDefault(rr.filmId, Collections.emptySet()).stream())
					.collect(groupingBy(Function.identity(), counting())).entrySet().stream()
					.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(10)
					.map(e -> actorById.get(e.getKey()).firstName + " " + actorById.get(e.getKey()).lastName + " : "
							+ e.getValue())
					.collect(toList());
			System.out.println("[Top 10 actors by rentals]");
			topActorsByRentals.forEach(System.out::println);

			// Rentals stream consumed; recreate
			rentals = streamQuery(c,
					"SELECT r.rental_id, i.film_id, i.store_id, r.customer_id, r.rental_date, r.return_date, "
							+ "       COALESCE((SELECT p.amount FROM payment p WHERE p.rental_id = r.rental_id LIMIT 1), 0) AS amount "
							+ "FROM rental r JOIN inventory i ON r.inventory_id = i.inventory_id",
					rs -> new RentalRow(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getTimestamp(6), rs.getDouble(7)));

			// 2) Revenue per store per month
			Map<Integer, Map<YearMonth, Double>> revenueByStoreMonth = rentals.collect(groupingBy(rr -> rr.storeId,
					groupingBy(rr -> YearMonth.from(rr.rentalDate.toLocalDateTime()), summingDouble(rr -> rr.amount))));
			System.out.println("[Revenue per store per month] sample:");
			revenueByStoreMonth.entrySet().stream().limit(1).forEach(e -> {
				Integer store = e.getKey();
				e.getValue().entrySet().stream().sorted(Map.Entry.comparingByKey()).limit(5).forEach(
						me -> System.out.printf(" store %d | %s -> %.2f%n", store, me.getKey(), me.getValue()));
			});

			// 3) Top-5 categories by revenue
			rentals = streamQuery(c,
					"SELECT r.rental_id, i.film_id, i.store_id, r.customer_id, r.rental_date, r.return_date, "
							+ "       COALESCE((SELECT p.amount FROM payment p WHERE p.rental_id = r.rental_id LIMIT 1), 0) AS amount "
							+ "FROM rental r JOIN inventory i ON r.inventory_id = i.inventory_id",
					rs -> new RentalRow(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getTimestamp(6), rs.getDouble(7)));

			List<String> topCategories = rentals
					.flatMap(rr -> categoryIdsByFilm.getOrDefault(rr.filmId, Collections.emptySet()).stream()
							.map(catId -> new AbstractMap.SimpleEntry<>(catId, rr.amount)))
					.collect(groupingBy(Map.Entry::getKey, summingDouble(Map.Entry::getValue))).entrySet().stream()
					.sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()).limit(5)
					.map(e -> categoryNameById.get(e.getKey()) + " : " + String.format("%.2f", e.getValue()))
					.collect(toList());
			System.out.println("[Top 5 categories by revenue]");
			topCategories.forEach(System.out::println);

			// 4) Average rental duration by category (hours)
			rentals = streamQuery(c,
					"SELECT r.rental_id, i.film_id, i.store_id, r.customer_id, r.rental_date, r.return_date, "
							+ "       COALESCE((SELECT p.amount FROM payment p WHERE p.rental_id = r.rental_id LIMIT 1), 0) AS amount "
							+ "FROM rental r JOIN inventory i ON r.inventory_id = i.inventory_id",
					rs -> new RentalRow(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getTimestamp(6), rs.getDouble(7)));

			Map<String, Double> avgHoursByCategory = rentals.filter(rr -> rr.returnDate != null).flatMap(rr -> {
				long hours = ChronoUnit.HOURS.between(rr.rentalDate.toLocalDateTime(), rr.returnDate.toLocalDateTime());
				return categoryIdsByFilm.getOrDefault(rr.filmId, Collections.emptySet()).stream()
						.map(catId -> new AbstractMap.SimpleEntry<>(categoryNameById.get(catId), (double) hours));
			}).collect(groupingBy(Map.Entry::getKey, averagingDouble(Map.Entry::getValue)));
			System.out.println("[Avg rental hours by category] sample:");
			avgHoursByCategory.entrySet().stream().limit(5)
					.forEach(e -> System.out.printf(" %s -> %.2f h%n", e.getKey(), e.getValue()));

			// 5) Top co-star pairs
			List<String> topPairs = actorIdsByFilm.values().stream().flatMap(set -> {
				List<Integer> ids = new ArrayList<>(set);
				List<AbstractMap.SimpleEntry<Integer, Integer>> pairs = new ArrayList<>();
				for (int i = 0; i < ids.size(); i++)
					for (int j = i + 1; j < ids.size(); j++)
						pairs.add(new AbstractMap.SimpleEntry<>(ids.get(i), ids.get(j)));
				return pairs.stream();
			}).collect(groupingBy(Function.identity(), counting())).entrySet().stream()
					.sorted(Map.Entry.<AbstractMap.SimpleEntry<Integer, Integer>, Long>comparingByValue().reversed())
					.limit(10).map(e -> {
						Actor a = actorById.get(e.getKey().getKey());
						Actor b = actorById.get(e.getKey().getValue());
						return String.format("%s %s + %s %s : %d films", a.firstName, a.lastName, b.firstName,
								b.lastName, e.getValue());
					}).collect(toList());
			System.out.println("[Top 10 co-star pairs]");
			topPairs.forEach(System.out::println);

			// 6) Top films by revenue
			rentals = streamQuery(c,
					"SELECT r.rental_id, i.film_id, i.store_id, r.customer_id, r.rental_date, r.return_date, "
							+ "       COALESCE((SELECT p.amount FROM payment p WHERE p.rental_id = r.rental_id LIMIT 1), 0) AS amount "
							+ "FROM rental r JOIN inventory i ON r.inventory_id = i.inventory_id",
					rs -> new RentalRow(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getTimestamp(6), rs.getDouble(7)));

			List<String> topFilms = rentals.collect(groupingBy(rr -> rr.filmId, summingDouble(rr -> rr.amount)))
					.entrySet().stream().sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()).limit(10)
					.map(e -> filmById.get(e.getKey()).title + " : " + String.format("%.2f", e.getValue()))
					.collect(toList());
			System.out.println("[Top 10 films by revenue]");
			topFilms.forEach(System.out::println);

			// 7) Dormant customers (no rentals in last 6 months)
			LocalDate cutoff = LocalDate.now().minusMonths(6);
			Set<Integer> recentCustomers = streamQuery(c,
					"SELECT DISTINCT r.customer_id FROM rental r WHERE r.rental_date >= ?", rs -> rs.getInt(1),
					Date.valueOf(cutoff)).collect(toSet());

			Map<Integer, Customer> customers = streamQuery(c,
					"SELECT customer_id, first_name, last_name, store_id FROM customer",
					rs -> new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)))
					.collect(toMap(cu -> cu.id, cu -> cu));

			List<String> dormant = customers.values().stream().filter(cu -> !recentCustomers.contains(cu.id))
					.sorted(Comparator.comparing((Customer cu) -> cu.storeId).thenComparing(cu -> cu.lastName))
					.limit(20).map(cu -> "store " + cu.storeId + " -> " + cu.firstName + " " + cu.lastName)
					.collect(toList());
			System.out.println("[Dormant customers (sample 20)]");
			dormant.forEach(System.out::println);
		}
	}
}
