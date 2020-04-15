package com.amit.lab;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.amit.lab.model.Player;
import com.amit.lab.model.PlayerAction;
import com.amit.lab.model.TurnAction;

@Controller
public class BancoController {

	protected BancoGame game;

	public void start(List<Player> players) {
		this.game = new BancoGame(players);
	}

	public void pass() {
		this.game.pass(new TurnAction(PlayerAction.PASS));
	}

	public void bet(int amount) {
		this.game.bet(new TurnAction(game.players.get(game.currentPlayerIndex), PlayerAction.BET, amount));
	}

	public void banco() {
		this.game.bet(new TurnAction(game.players.get(game.currentPlayerIndex), PlayerAction.BANCO, game.bancoAmt));
	}

	public void addPlayer(Player player) {
		this.game.addPlayer(player);
	}

	public void removePlayer(Player player) {
		this.game.removePlayer(player);
	}
}
