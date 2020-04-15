package com.amit.lab.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Pack {
	private static final List<Suit> SUITS = Arrays.asList(Suit.values());

	protected List<Card> cards = new ArrayList<>();

	public Pack() {
		SUITS.forEach(e -> createCards(e));
	}

	private void createCards(Suit suit) {
		IntStream.range(1, 14).boxed().forEach(e -> cards.add(new Card(suit, "" + e, e)));
	}

	public void shuffle() {
		Collections.shuffle(this.cards);
	}

	public Card get(int index) {
		return this.cards.get(index);
	}
	
	public int getTotalCards() {
		return this.cards.size();
	}
}
