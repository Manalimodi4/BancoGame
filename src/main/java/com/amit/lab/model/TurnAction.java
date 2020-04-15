package com.amit.lab.model;

public class TurnAction {
	protected Player previousPlayer;

	protected PlayerAction action;

	protected int amount;

	public TurnAction(PlayerAction action) {
		this.action = action;
	}

	public TurnAction(Player previousPlayer, PlayerAction action, int amount) {
		this.previousPlayer = previousPlayer;
		this.action = action;
		this.amount = amount;
	}

	public Player getPreviousPlayer() {
		return previousPlayer;
	}

	public void setPreviousPlayer(Player previousPlayer) {
		this.previousPlayer = previousPlayer;
	}

	public PlayerAction getAction() {
		return action;
	}

	public void setAction(PlayerAction action) {
		this.action = action;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
