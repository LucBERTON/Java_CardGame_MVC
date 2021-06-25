package com.openclassrooms.cardgame.view;

import java.util.Scanner;

import com.openclassrooms.cardgame.controller.GameController;

public class CommandLineView implements GameViewable {

	GameController controller;
	Scanner keyboard = new Scanner(System.in);

	@Override
	public void setController(GameController gameController) {
		this.controller = gameController;
	}

	@Override
	public void promptForPlayerName() {
		System.out.println("Enter player name");
		String name = keyboard.nextLine();
		if (name.isEmpty()) {
			controller.startGame();
		} else {
			controller.addPlayer(name);
		}

	}

	@Override
	public void promptForFlip() {
		System.out.println("Press enter to reveal cards");
		keyboard.nextLine();
		controller.flipCards();

	}

	@Override
	public void promptForNewGame() {
		System.out.println("Press enter to start a new game or +q to exit");
		controller.nextAction(keyboard.nextLine());
	}

	@Override
	public void showPlayerName(int playerId, String playerName) {
		System.out.println("[" + playerId + "]" + playerName);
	}

	@Override
	public void showFaceDownCardForPlayer(int playerId, String playerName) {
		System.out.println("[" + playerId + "]" + playerName + ": [Card not yet flipped]");

	}

	@Override
	public void showCardForPlayer(int i, String playerName, String rank, String suit) {
		System.out.println("[" + i + "]" + playerName + " : " + rank + " of " + suit);

	}

	@Override
	public void showWinner(String playerName) {
		System.out.println("The Winner is " + playerName + "!");

	};
}