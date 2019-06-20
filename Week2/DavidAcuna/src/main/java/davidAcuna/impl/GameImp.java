package davidAcuna.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import davidAcuna.domain.Game;
import davidAcuna.domain.GameStatus;
import davidAcuna.domain.Player;

@Component
public class GameImp {
	

	/**
	 * Show the status of the game
	 *                   
	 * @return status of the game
	 */
	public GameStatus getGameStatus(Player currentPlayerAttempt, Player competitorAttempt, Integer gameAttempts, Boolean showInfo) {
		if(showInfo) {
			return new GameStatus("Player one attempts: " + currentPlayerAttempt.getAttempt() + ". Competitor attempts: " + competitorAttempt.getAttempt() + ". Game total: " + gameAttempts, currentPlayerAttempt.getResults(), competitorAttempt.getResults());				
		}else {
			return new GameStatus("You have reached the maximum number of attempts", currentPlayerAttempt.getResults(), competitorAttempt.getResults());
		}
	}

	/**
	 * Make a player's move and determine if he has the possibility to make more attempts
	 *                   
	 * @return Valid play if a player have attempts, invalid otherwise
	 */
	public Boolean play(Player currentPlayer, Player competitor, Game game) {
		
		if(currentPlayer.getAttempt()<3) {
			Integer value = generateNumber();
			currentPlayer.setAttempt(currentPlayer.getAttempt()+1);
			currentPlayer.getResults().add(value);
			game.setAttempts(game.getAttempts()+1);
			return true;
		}else {
			return false;
		}
		
	}

	/**
	 * Generates a random number
	 *                   
	 * @return Random number
	 */
	private Integer generateNumber() {
		return new Random().ints(0, 5000).findFirst().getAsInt();		
	}

	public GameStatus determineWinner(List<Integer> resultsPlayerOne, List<Integer> resultsPlayerTwo) {
			
		if (resultsPlayerOne.equals(resultsPlayerTwo)) {
			return new GameStatus("The game ended in a draw ", resultsPlayerOne, resultsPlayerTwo);			
		}
		
		Long total = IntStream
		         .range(0, resultsPlayerOne.size())
		         .filter(idx -> resultsPlayerOne.get(idx) > resultsPlayerTwo.get(idx))
		         .count();
		
		if (total > 1){
			Integer totalOne = resultsPlayerOne.stream()
					.mapToInt(Integer::intValue)
					.sum();
			return new GameStatus("Player one is the champion after winning : " + total + " out of 3 attempts. Total score : " + totalOne, resultsPlayerOne, resultsPlayerTwo);	
		}else {
			Integer totalTwo = resultsPlayerTwo.stream()
					.mapToInt(Integer::intValue)
					.sum();
			return new GameStatus("Player two is the champion after winning : " + (3 - total) + " out of 3 attempts. Total score : " + totalTwo, resultsPlayerOne, resultsPlayerTwo);
		}
	}



}
