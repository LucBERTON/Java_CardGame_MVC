package com.openclassrooms.cardgame.controller;

import java.util.List;

import com.openclassrooms.cardgame.model.Player;

public interface GameEvaluator {
	Player evaluateWinner(List<Player> players);
}