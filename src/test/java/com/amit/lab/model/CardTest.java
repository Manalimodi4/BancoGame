package com.amit.lab.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardTest {
	private Card testObj = new Card(Suit.CLUB, "10", 10);

	@Test
	public void init() {
		assertEquals(10, testObj.value);
	}

	@Test
	public void isBetween_whenTrue() {
		boolean result = testObj.isBetween(new Card(Suit.CLUB, "11", 11), new Card(Suit.DIAMOND, "1", 1));

		assertTrue(result);
	}

	@Test
	public void isBetween_whenFalse() {
		boolean result = testObj.isBetween(new Card(Suit.CLUB, "11", 11), new Card(Suit.DIAMOND, "13", 13));

		assertFalse(result);
	}

	@Test
	public void isBetween_whenMatchesLeftCard() {
		boolean result = testObj.isBetween(new Card(Suit.HEART, "10", 10), new Card(Suit.DIAMOND, "13", 13));

		assertFalse(result);
	}

	@Test
	public void isBetween_whenMatchesRightCard() {
		boolean result = testObj.isBetween(new Card(Suit.HEART, "9", 9), new Card(Suit.DIAMOND, "10", 10));

		assertFalse(result);
	}
}
