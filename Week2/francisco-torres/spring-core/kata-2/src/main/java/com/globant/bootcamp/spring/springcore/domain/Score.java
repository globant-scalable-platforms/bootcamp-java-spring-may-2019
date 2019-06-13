package com.globant.bootcamp.spring.springcore.domain;


public class Score {
    private int count;
    private String message;
    
    public Score(final int count, final String message) {
        this.count = count;
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) { this.message = message; }


}
