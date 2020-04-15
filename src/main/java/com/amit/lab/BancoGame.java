package com.amit.lab;

import java.util.List;

import com.amit.lab.model.BetResult;
import com.amit.lab.model.Card;
import com.amit.lab.model.GameInfo;
import com.amit.lab.model.Pack;
import com.amit.lab.model.Player;
import com.amit.lab.model.TurnAction;
import com.amit.lab.model.TurnResult;

public class BancoGame {

	private static final int MAX_CARDS_REQUIRED_FOR_TURN = 3;

	protected static final long INITIAL_AMOUNT = 10;

	protected List<Player> players;

	protected Pack pack = new Pack();

	protected int bancoAmt;

	protected int cardIndex;

	protected Card leftCard;

	protected Card rightCard;

	protected int currentPlayerIndex = 0;

	public BancoGame(List<Player> players) {
		this.players = players;
	}

	public GameInfo start() {
		this.cardIndex = 0;
		players.forEach(e -> deductInitialAmt(e));
		this.pack.shuffle();
		this.pack.shuffle();
		return this.next(null, null);
	}

	public GameInfo next(TurnAction previousAction, TurnResult previousResult) {
		validatePack();
		this.leftCard = this.pack.get(cardIndex++);
		this.rightCard = this.pack.get(cardIndex++);
		return getGameInfo(previousAction, previousResult);
	}

	private GameInfo getGameInfo(TurnAction previousAction, TurnResult previousResult) {
		GameInfo gameInfo = new GameInfo(this.players, currentPlayerIndex, bancoAmt, leftCard, rightCard);
		gameInfo.setPreviousAction(previousAction);
		gameInfo.setPreviousResult(previousResult);
		return gameInfo;
	}

	private void validatePack() {
		if (this.cardIndex + MAX_CARDS_REQUIRED_FOR_TURN >= this.pack.getTotalCards()) {
			this.pack.shuffle();
			this.cardIndex = 0;
		}
	}

	private void deductInitialAmt(Player player) {
		player.add(-INITIAL_AMOUNT);
		this.bancoAmt += INITIAL_AMOUNT;
	}

	public void pass(TurnAction action) {
		this.moveToNextPlayer();
		this.next(action, new TurnResult(BetResult.PASS));
	}

	public void addPlayer(Player player) {
		if (gameInProgress()) {
			throw new RuntimeException("Game in progress");
		}
		this.players.add(player);
	}

	private boolean gameInProgress() {
		return false;
	}

	public GameInfo bet(TurnAction turnAction) {
		Card betCard = this.pack.get(cardIndex++);
		if (betCard.isBetween(leftCard, rightCard)) {
			return handleBet(turnAction, betCard, turnAction.getAmount(), BetResult.WIN);
		}
		return handleBet(turnAction, betCard, -turnAction.getAmount(), BetResult.LOSS);
	}

	public GameInfo banco(TurnAction turnAction) {
		Card betCard = this.pack.get(cardIndex++);
		if (betCard.isBetween(leftCard, rightCard)) {
			return handleBet(turnAction, betCard, this.bancoAmt, BetResult.GAME_END);
		}
		return handleBet(turnAction, betCard, -this.bancoAmt, BetResult.LOSS);
	}

	private GameInfo handleBet(TurnAction turnAction, Card betCard, int amount, BetResult result) {
		this.players.get(currentPlayerIndex).add(amount);
		moveToNextPlayer();
		this.bancoAmt -= amount;
		return this.getGameInfo(turnAction, new TurnResult(betCard, result));
	}

	private void moveToNextPlayer() {
		currentPlayerIndex = ((currentPlayerIndex + 1) % players.size());
	}

	public void removePlayer(Player player) {
		this.players.remove(player);
	}
}
