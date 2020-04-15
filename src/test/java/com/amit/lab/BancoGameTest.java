package com.amit.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.amit.lab.model.Player;
import com.amit.lab.model.PlayerAction;
import com.amit.lab.model.TurnAction;

public class BancoGameTest {
	protected List<Player> players = Arrays.asList(new Player("A", "A"), new Player("B", "B"));

	protected BancoGame testObj = new BancoGame(players);

	@Test
	public void init() {
		assertNotNull(testObj.pack);
		assertNotNull(testObj.players);
		assertEquals(players.size(), testObj.players.size());
	}

	@Test
	public void start() {
		testObj.start();

		assertNotNull(testObj.leftCard);
		assertNotNull(testObj.rightCard);
		assertEquals(players.size() * BancoGame.INITIAL_AMOUNT, testObj.bancoAmt);
		assertEquals(-BancoGame.INITIAL_AMOUNT, testObj.players.get(0).getAmount());
	}

	@Test
	public void pass() {
		testObj.start();

		testObj.pass(new TurnAction(PlayerAction.PASS));

		assertEquals(1, testObj.currentPlayerIndex);
	}

}
