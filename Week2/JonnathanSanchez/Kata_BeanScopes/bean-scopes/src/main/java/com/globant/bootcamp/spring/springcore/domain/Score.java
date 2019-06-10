package com.globant.bootcamp.spring.springcore.domain;


public class Score {
    private String message;
    private int number;
    private int attempt;

    
    public Score(final String message, final int number, final int attempt) {
        this.message = message;
        this.number = number;
        this.attempt = attempt;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(final int attempt) {
        this.attempt = attempt;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }
}
