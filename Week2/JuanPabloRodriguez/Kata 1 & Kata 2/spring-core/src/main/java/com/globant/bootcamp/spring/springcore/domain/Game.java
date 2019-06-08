package com.globant.bootcamp.spring.springcore.domain;

public class Game {
	
	private String player;
	private int score;
	private int count;
	private boolean winner;
	private String status;
	
	public Game(final String player, final int score, final int count, final boolean winner, final String status) {
		this.player = player;
		this.score = score;
		this.count = count;
		this.winner = winner;
		this.status = status;
	}
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPlayer() {
		return player;
	}


	public boolean isWinner() {
		return winner;
	}


	public void setWinner(boolean winner) {
		this.winner = winner;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
