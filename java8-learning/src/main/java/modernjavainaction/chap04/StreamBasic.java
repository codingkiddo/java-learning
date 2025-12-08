package modernjavainaction.chap04;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class StreamBasic {

	public static void main(String... args) {
		System.out.println("---");
		// Java 8
		getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
	}

	public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
		return dishes.stream().filter(dish -> dish.getCalories() < 400).sorted(comparing(Dish::getCalories))
				.map(Dish::getName).collect(toList());
	}
}
