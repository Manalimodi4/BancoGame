package com.amit.lab.model;

public class TurnResult {
	protected Card resultCard;

	protected BetResult betResult;

	public TurnResult(BetResult betResult) {
		this(null, betResult);
	}

	public TurnResult(Card resultCard, BetResult betResult) {
		this.resultCard = resultCard;
		this.betResult = betResult;
	}

	public Card getResultCard() {
		return resultCard;
	}

	public void setResultCard(Card resultCard) {
		this.resultCard = resultCard;
	}

	public BetResult getBetResult() {
		return betResult;
	}

	public void setBetResult(BetResult betResult) {
		this.betResult = betResult;
	}
}
