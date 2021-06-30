package com.openclassrooms.cardgame.model;

public interface IPlayer {
	public void addCardTohand(PlayingCard pc);

	public PlayingCard getCard(int index);

	public PlayingCard removeCard();

	public String getName();
}
