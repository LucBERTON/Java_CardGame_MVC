package com.openclassrooms.cardgame.model;

public class Player implements IPlayer {
	private String name;
	private Hand hand;

	public Player(String name) {
		super();
		this.name = name;
		hand = new Hand();
	}

	@Override
	public void addCardTohand(PlayingCard pc) {
		hand.addCard(pc);
	}

	@Override
	public PlayingCard getCard(int index) {
		return hand.getCard(index);
	}

	@Override
	public PlayingCard removeCard() {
		return hand.removeCard();
	}

	@Override
	public String getName() {
		return name;
	}
}
