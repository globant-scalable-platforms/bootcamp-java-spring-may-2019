package com.globant.bootcamp.spring.springcore.domain;


public class Score {
    private int player1;
    private int player2;
    private String message;
    
    public Score(final int count, final String message ) {
        this.player1 = count;
        this.player2 = count;
        this.message = message;
    }

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }

    public void setPlayer2(int player2) {
        this.player2 = player2;
    }

    public int getPlayer1() {
        return player1;
    }

    public int getPlayer2() {
        return player2;
    }

    public String getMessage() {
        return message;
    }

}
