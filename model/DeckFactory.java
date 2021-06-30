package com.openclassrooms.cardgame.model;

public class DeckFactory {
	public enum DeckType {
		Normal, // 52 cartes
		Small, // 32 cartes
		Test // cas particuliers pour test
	}

	public static Deck makeDeck(DeckType deckType) {
		switch (deckType) {
		case Normal -> new NormalDeck();
		case Small -> new SmallDeck();
		case Test -> new TestDeck();
		}

		// fallback
		return new NormalDeck();

	}
}
