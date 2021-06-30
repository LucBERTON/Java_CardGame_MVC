package com.openclassrooms.cardgame.controller;

import java.util.List;

import com.openclassrooms.cardgame.model.IPlayer;
import com.openclassrooms.cardgame.model.PlayingCard;

public class LowCardGameEvaluator implements GameEvaluator {

	@Override
	public IPlayer evaluateWinner(List<IPlayer> players) {
		IPlayer bestPlayer = null;
		int bestRank = 100;
		int bestSuit = 100;

		for (IPlayer player : players) {
			boolean newBestPlayer = false;

			if (bestPlayer == null) {
				// si pas encore de best player, le joueur actuel est le best
				newBestPlayer = true;
			} else {
				PlayingCard pc = player.getCard(0);
				int thisRank = pc.getRank().value();
				if (thisRank <= bestRank) {

					// si rang de la carte du player est plus bas que best, le joueur actuel est le
					// best
					if (thisRank < bestRank) {
						newBestPlayer = true;

						// si même rang et couleur de la carte du player est plus bas que best,
						// le joueur actuel est le best
					} else if (pc.getSuit().value() < bestSuit) {
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
