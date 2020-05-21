package interview.programs.first;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Smoothie {

	private static final String RESTRICTED_INGREDIENT_MARK = "-";
	/*
	   The menu options, along with the ingredients needed for each are as follows.

		Classic: strawberry, banana, pineapple, mango, peach, honey
		Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt
		Greenie: green apple, lime, avocado, spinach, ice, apple juice
		Just Desserts: banana, ice cream, chocolate, peanut, cherry
	 */
	private static final Map<String, Set<String>> MENU;
	private static Pattern ORDER_FORMAT = Pattern.compile("^[a-zA-Z ]+((,(-?))?[a-zA-Z ]+,?)*$");

	/*
		Note: thread safe publication, if we wanted to have a dynamic menu (multiple readers-multiple writers)
		      then we will need to use concurrent data structures, such as ConcurrentHashMap and ConcurrentSkipListSet.
	 */
	static {
		MENU = new LinkedHashMap<>();
		MENU.put("Classic", construct("strawberry", "banana", "pineapple", "mango", "peach", "honey"));
		MENU.put("Freezie", construct("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"));
		MENU.put("Greenie", construct("green apple", "lime", "avocado", "spinach", "ice", "apple juice"));
		MENU.put("Just Desserts", construct("banana", "ice cream", "chocolate", "peanut", "cherry"));
	}

	public static String ingredients(String order) {
		if (order == null) {
			throw new IllegalArgumentException("order should be populated");
		}

		if (!ORDER_FORMAT.asPredicate().test(order)) {
			throw new IllegalArgumentException("invalid order format");
		}

		final String smoothie;
		final boolean shouldCheckForRestricted;
		if (order.contains(",")) {
			shouldCheckForRestricted = true;
			smoothie = order.split(",")[0];
		} else {
			smoothie = order;
			shouldCheckForRestricted = false;
		}

		Set<String> ingredients = getIngredients(smoothie);

		final TreeSet<String> resultIngredients = new TreeSet<>(ingredients);
		if (!shouldCheckForRestricted) {
			return serialize(resultIngredients);
		}

		processRestrictedIngredients(order, smoothie, resultIngredients);
		return serialize(resultIngredients);
	}

	private static Set<String> construct(String... input) {
		Set<String> r = new HashSet<>();
		Collections.addAll(r, input);
		return r;
	}

	private static Set<String> getIngredients(String smoothie) {
		Set<String> ingredients = MENU.get(smoothie); // O(1)
		if (ingredients == null) {
			throw new IllegalArgumentException("invalid smoothie ordered");
		}
		return ingredients;
	}

	private static void processRestrictedIngredients(String order, String smoothie, TreeSet<String> resultIngredients) {
		String[] splittedInfo = order.split(",");
		for (int i = 1; i < splittedInfo.length; i++) {

			String requestedIngredient = splittedInfo[i];

			// It is valid to have the allergens not present in the ordered smoothie. Those ingredients will just be ignored and no exception should be thrown.
			if (requestedIngredient.startsWith(RESTRICTED_INGREDIENT_MARK)) {
				requestedIngredient = requestedIngredient.replace(RESTRICTED_INGREDIENT_MARK, "");
				resultIngredients.remove(requestedIngredient); // O(logN)
			} else {
				// As adding new ingredients is not supported yet, any input with additional ingredients is considered invalid and an IllegalArgumentException should be thrown.
				throw new IllegalArgumentException("invalid ingredient: " + requestedIngredient + " requested for selected smoothie: " + smoothie);
			}
		}
	}

	private static String serialize(TreeSet<String> resultIngredients) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> iterator = resultIngredients.iterator();
		while (iterator.hasNext()) {
			String ingredient = iterator.next(); // O(1)
			sb.append(ingredient);
			if (iterator.hasNext())
				sb.append(",");
		}
		return sb.toString();
	}
}
