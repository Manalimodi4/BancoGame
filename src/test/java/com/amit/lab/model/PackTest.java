package com.amit.lab.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PackTest {

	@Test
	public void init() {
		Pack testObj = new Pack();

		assertEquals(52, testObj.cards.size());
	}

	@Test
	public void shuffle() {
		Pack testObj = new Pack();
		Card initialCard = testObj.get(0);

		testObj.shuffle();
		
		System.out.println(testObj.cards);
		assertNotEquals(initialCard, testObj.get(0));
	}
}
