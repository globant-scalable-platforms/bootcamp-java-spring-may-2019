package com.globant.bootcamp.spring.springcore.domain;


public class Game {
    private String winnerPlayer;
    private int winnerScore;
    private int attemptsPlayerOne;
    private int attemptsPlayerTwo;
    private String status;

    public Game(String winnerPlayer, String status) {
        this.winnerPlayer = winnerPlayer;
        this.status = status;
    }

    public String getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(String winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(int winnerScore) {
        this.winnerScore = winnerScore;
    }

    public int getAttemptsPlayerOne() {
        return attemptsPlayerOne;
    }

    public void setAttemptsPlayerOne(int attemps) {
        this.attemptsPlayerOne = attemps;
    }

    public int getAttemptsPlayerTwo() {
        return attemptsPlayerTwo;
    }

    public void setAttemptsPlayerTwo(int attemps) {
        this.attemptsPlayerTwo = attemps;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
