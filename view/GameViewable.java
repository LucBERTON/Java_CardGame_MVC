package com.openclassrooms.cardgame.view;

import com.openclassrooms.cardgame.controller.GameController;

public interface GameViewable {

	public void setController(GameController gameController);

	public void promptForPlayerName();

	public void promptForFlip();

	public void promptForNewGame();

	public void showPlayerName(int playerId, String playerName);

	public void showFaceDownCardForPlayer(int playerId, String playerName);

	public void showCardForPlayer(int i, String playerName, String rank, String suit);

	public void showWinner(String playerName);
}
