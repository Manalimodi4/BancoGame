package com.amit.lab.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

	Player testObj = new Player("TEST", "1", 100);
	
	@Test
	public void init() {
		testObj = new Player("TEST", "1");
		
		assertEquals(0, testObj.amount);
		assertEquals("TEST", testObj.name);
		assertEquals("1", testObj.id);
	}

	@Test
	public void init_withAmt() {
		assertEquals(100, testObj.getAmount());
		assertEquals("TEST", testObj.getName());
		assertEquals("1", testObj.getId());
	}
	
	@Test
	public void add_negative() {
		testObj.add(-20);

		assertEquals(80, testObj.getAmount());
	}
	
	@Test
	public void add_positive() {
		testObj.add(20);
		
		assertEquals(120, testObj.getAmount());
	}
}
