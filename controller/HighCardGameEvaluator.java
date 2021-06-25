package com.openclassrooms.cardgame.controller;

import java.util.List;

import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;

public class HighCardGameEvaluator implements GameEvaluator {

	@Override
	public Player evaluateWinner(List<Player> players) {
		Player bestPlayer = null;
		int bestRank = -1;
		int bestSuit = -1;

		for (Player player : players) {
			boolean newBestPlayer = false;

			if (bestPlayer == null) {
				// si pas encore de best player, le joueur actuel est le best
				newBestPlayer = true;
			} else {
				PlayingCard pc = player.getCard(0);
				int thisRank = pc.getRank().value();
				if (thisRank >= bestRank) {

					// si rang de la carte du player est mieux que best, le joueur actuel est le
					// best
					if (thisRank > bestRank) {
						newBestPlayer = true;

						// si même rang et couleur de la carte du player est mieux que best,
						// le joueur actuel est le best
					} else if (pc.getSuit().value() > bestSuit) {
						newBestPlayer = true;
					}
				}
			}
			// dans le cas où il y a un newBestPlayer, on récupère ses infos.
			if (newBestPlayer) {
				bestPlayer = player;
				PlayingCard pc = player.getCard(0);
				bestRank = pc.getRank().value();
				bestSuit = pc.getSuit().value();
			}
		}

		return bestPlayer;
	}

}
