package com.openclassrooms.cardgame.game;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.controller.HighCardGameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.view.GameSwingView;

/**
 * On passe au game controller 3 paramètres : -le deck : "new Deck()" -la vue :
 * "CommandLineView ou "GameSwingView" (à initialiser avec .createAndShowGUI())
 * -les règles de calcul du gagnant : HighCardGameEvaluator ou
 * LowCardGameEvaluator
 * 
 * @author LBER
 *
 */
public class Game {

	public static void main(String[] args) {

		// si on veut une vue Swing :
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();

		GameController gameController = new GameController(new Deck(), gsv, new HighCardGameEvaluator());

		// si on veut une vue command line
		// GameController gameController = new GameController(new Deck(), new
		// CommandLineView(), new LowCardGameEvaluator());
		gameController.run();
	}
}
