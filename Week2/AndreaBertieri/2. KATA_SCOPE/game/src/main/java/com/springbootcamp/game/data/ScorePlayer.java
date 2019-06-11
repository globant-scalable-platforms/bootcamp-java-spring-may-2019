package com.springbootcamp.game.data;

public class ScorePlayer {
	private int[] players = new int[2];
    
    public ScorePlayer(int player1Score, int player2Score) {
    	this.players[0]= player1Score;
    	this.players[1]= player2Score;
    }

	public int getPlayerScore(int player) {
		return players[player];
	}

	public void setPlayerScore(int player, int playerScore) {
		this.players[player] = playerScore;
	}

    
}
