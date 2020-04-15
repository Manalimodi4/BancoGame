package com.amit.lab.model;

import java.util.List;

public class GameInfo {

	protected List<Player> players;

	protected long bancoAmt;

	protected Card leftCard;

	protected Card rightCard;

	protected TurnAction previousAction;

	protected TurnResult previousResult;

	protected int currentPlayerIndex;

	public GameInfo(List<Player> players, int currentPlayerIndex, long bancoAmt, Card leftCard, Card rightCard) {
		this.players = players;
		this.currentPlayerIndex = currentPlayerIndex;
		this.bancoAmt = bancoAmt;
		this.leftCard = leftCard;
		this.rightCard = rightCard;
	}

	public long getBancoAmt() {
		return bancoAmt;
	}

	public void setBancoAmt(long bancoAmt) {
		this.bancoAmt = bancoAmt;
	}

	public Card getLeftCard() {
		return leftCard;
	}

	public void setLeftCard(Card leftCard) {
		this.leftCard = leftCard;
	}

	public Card getRightCard() {
		return rightCard;
	}

	public void setRightCard(Card rightCard) {
		this.rightCard = rightCard;
	}

	public TurnAction getPreviousAction() {
		return previousAction;
	}

	public void setPreviousAction(TurnAction previousAction) {
		this.previousAction = previousAction;
	}

	public TurnResult getPreviousResult() {
		return previousResult;
	}

	public void setPreviousResult(TurnResult previousResult) {
		this.previousResult = previousResult;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}
}
