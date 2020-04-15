package com.amit.lab.model;

public class Player {
	protected String name;
	
	protected String id;
	
	protected long amount;
	
	public Player(String name, String id, long amount) {
		this.name = name;
		this.id = id;
		this.amount = amount;
	}
	
	public Player(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public void add(long amount) {
		this.amount += amount;
	}
}
