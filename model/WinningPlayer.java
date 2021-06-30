package com.openclassrooms.cardgame.model;

/**
 * Décorateur pour affichage du joueur gagnant
 * 
 * @author LBER
 *
 */
public class WinningPlayer implements IPlayer {

	IPlayer winner;

	public WinningPlayer(IPlayer player) {
		this.winner = player;
	}

	@Override
	public void addCardTohand(PlayingCard pc) {
		winner.addCardTohand(pc);
	}

	@Override
	public PlayingCard getCard(int index) {
		return winner.getCard(index);
	}

	@Override
	public PlayingCard removeCard() {
		return winner.removeCard();
	}

	@Override
	public String getName() {
		return "***** " + winner.getName() + " *****";
	}

}
