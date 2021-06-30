package com.openclassrooms.cardgame.game;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.controller.HighCardGameEvaluator;
import com.openclassrooms.cardgame.model.DeckFactory;
import com.openclassrooms.cardgame.model.DeckFactory.DeckType;
import com.openclassrooms.cardgame.view.GameSwingPassiveView;
import com.openclassrooms.cardgame.view.GameSwingView;
import com.openclassrooms.cardgame.view.GameViewables;

/**
 * On passe au game controller 3 param�tres : -le deck :instanci� via
 * DeckFactory -la vue :"CommandLineView ou "GameSwingView" (� initialiser avec
 * .createAndShowGUI()) -les r�gles de calcul du gagnant :
 * HighCardGameEvaluatorou LowCardGameEvaluator note : on pourrait cr�er une
 * factory pour les GameEvaluator �galement
 * 
 * @author LBER
 *
 */
public class Game {

	public static void main(String[] args) {

		// on instancie la liste des vues
		GameViewables views = new GameViewables();

		// si on veut une vue Swing, on l'instancie :
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();

		views.addViewable(gsv);

		// On boucle pour instancier plusieurs vues passives
		for (int i = 0; i < 3; i++) {
			GameSwingPassiveView passiveView = new GameSwingPassiveView();
			passiveView.createAndShowGUI();

			views.addViewable(passiveView);

			// on attend un d�lai pour pouvoir d�placer les fenetres cr�es
			// sinon elles se superposent
			try {
				Thread.sleep(2500);
			} catch (InterruptedException err) {
				err.printStackTrace();
			}
		}

		GameController gameController = new GameController(DeckFactory.makeDeck(DeckType.Normal), views,
				new HighCardGameEvaluator());

		// si on veut une vue command line
		// GameController gameController = new GameController(new Deck(), new
		// CommandLineView(), new LowCardGameEvaluator());
		gameController.run();
	}
}
