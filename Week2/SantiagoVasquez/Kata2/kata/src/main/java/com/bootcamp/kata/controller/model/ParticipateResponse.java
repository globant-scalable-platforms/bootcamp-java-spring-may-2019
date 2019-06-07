package com.bootcamp.kata.controller.model;

public class ParticipateResponse {

    private String winner;

    public ParticipateResponse() {
    }

    public ParticipateResponse(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
