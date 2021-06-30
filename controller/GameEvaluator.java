package com.openclassrooms.cardgame.controller;

import java.util.List;

import com.openclassrooms.cardgame.model.IPlayer;

public interface GameEvaluator {
	IPlayer evaluateWinner(List<IPlayer> players);
}