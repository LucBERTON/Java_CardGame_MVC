package com.openclassrooms.cardgame.model;

import java.util.ArrayList;

public class NormalDeck extends Deck {

	public NormalDeck() {
		cards = new ArrayList<PlayingCard>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				System.out.println("on cr?? la carte [" + rank + "][" + suit + "]");
				cards.add(new PlayingCard(rank, suit));
			}
		}

		shuffle();
	}
}
