package com.bootcamp.springboot.game.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Score {
	
	private int countPlayer1;
	private int countPlayer2;
    private String message;   
    private Player player1;
    private Player player2;
    
    public Score(int countPlayer1, int countPlayer2, String message) {
        this.countPlayer1 = countPlayer1;
        this.countPlayer2 = countPlayer2;
        this.message = message;
    }

    public void setPlayer1(Player player1) {
    	this.player1 = player1;
    }
    
    public Player getPlayer1() {
    	return player1;
    }
    
    public void setPlayer2(Player player2) {
    	this.player2 = player2;
    }
    
    public Player getPlayer2() {
    	return player2;
    }
    
    public int getCountPlayer1() {
        return countPlayer1;
    }

    public void setCountPlayer1(int countPlayer1) {
        this.countPlayer1 = countPlayer1;
    }
    
    public int getCountPlayer2() {
        return countPlayer2;
    }

    public void setCountPlayer2(int countPlayer2) {
        this.countPlayer2 = countPlayer2;
    }
    
    public void setMessage(String message) {
    	this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
