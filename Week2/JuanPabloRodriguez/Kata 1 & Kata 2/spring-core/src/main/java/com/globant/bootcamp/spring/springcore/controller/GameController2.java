package com.globant.bootcamp.spring.springcore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.bootcamp.spring.springcore.domain.Game;

@RestController
public class GameController2 {

	// stores the max value of the player 1
	@Autowired
	@Qualifier(value = "gameSingleton1")
	private Game gameTotalPlayer1;

	// stores the max value of the player 2
	@Autowired
	@Qualifier(value = "gameSingleton2")
	private Game gameTotalPlayer2;

	// stores the value for each turn of this player
	@Autowired
	@Qualifier(value = "gamePrototype")
	private Game gameTurn;

	@RequestMapping(value = "/game-player2")
	public List<Game> getGame() {

		final List<Game> result = new ArrayList<>();

		//player have 3 turns
		if (gameTotalPlayer2.getCount() != 3) {
			
			int randomNum = ThreadLocalRandom.current().nextInt(0, 5000 + 1);

			gameTurn.setScore(randomNum);
			gameTotalPlayer2.setScore(gameTotalPlayer2.getScore() + randomNum);			
			gameTotalPlayer2.setCount(gameTotalPlayer2.getCount() + 1);

		}
		
		//if both finish, find the winner
		else if(gameTotalPlayer1.getCount() == 3 && gameTotalPlayer2.getCount() == 3) {
			gameTotalPlayer1.setStatus("finished");
			gameTotalPlayer2.setStatus("finished");
			gameTurn.setStatus("finished");
			gameTurn.setScore(0);
			//if player 1 win
			if(gameTotalPlayer1.getScore() > gameTotalPlayer2.getScore()) {
				gameTotalPlayer1.setWinner(true);
			}
			
			//if player 2 win
			else {
				gameTotalPlayer2.setWinner(true);
			}
		}
		
		//if player 2 finish but player 1 not
		else {
			
			gameTotalPlayer2.setStatus("waiting for player 1 to finish");

		}
		
		result.add(gameTurn);
		result.add(gameTotalPlayer2);
		return result;

	}

}
