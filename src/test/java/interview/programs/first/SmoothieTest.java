package interview.programs.first;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmoothieTest {

	@Test
	public void classicSmoothie() {
		assertEquals("banana,honey,mango,peach,pineapple,strawberry",
				Smoothie.ingredients("Classic"));
	}

	@Test
	public void classicSmoothieWithoutStrawberry() {
		assertEquals("banana,honey,mango,peach,pineapple",
				Smoothie.ingredients("Classic,-strawberry"));
	}

	@Test
	public void order1() {
		assertEquals("black currant,blackberry,blueberry,frozen yogurt,grape juice",
				Smoothie.ingredients("Freezie"));
	}

	@Test
	public void order1_1() {
		assertEquals("black currant,blueberry,grape juice",
				Smoothie.ingredients("Freezie,-blackberry,-frozen yogurt"));
	}

	@Test
	public void order2() {
		assertEquals("apple juice,avocado,green apple,ice,lime,spinach",
				Smoothie.ingredients("Greenie"));
	}

	@Test
	public void order2_2() {
		assertEquals("avocado,green apple,ice,lime",
				Smoothie.ingredients("Greenie,-spinach,-apple juice"));
	}

	@Test
	public void order3() {
		assertEquals("banana,cherry,chocolate,ice cream,peanut",
				Smoothie.ingredients("Just Desserts"));
	}

	@Test
	public void order3_3() {
		assertEquals("banana,cherry,ice cream",
				Smoothie.ingredients("Just Desserts,-peanut,-chocolate"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidMenu() {
		Smoothie.ingredients("xyz");
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidMenu2() {
		Smoothie.ingredients("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidIngredientRequest() {
		Smoothie.ingredients("Classic,chocolate");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullAsParam() {
		Smoothie.ingredients(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidParamFormat() {
		Smoothie.ingredients("Classic-afa,ae--aef");
	}


}
