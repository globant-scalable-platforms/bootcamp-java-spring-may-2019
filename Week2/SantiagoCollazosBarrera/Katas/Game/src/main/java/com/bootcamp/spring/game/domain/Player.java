/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.spring.game.domain;

/**
 *
 * @author Santiago Collazos Barrera
 */
public class Player {
    
    
    private int id;
    private String name;
    private int attemps;
    private int winningNumber;
    private String message;
    private boolean winner;

    public Player(int id, String name) {
        this.id = id;
        this.name = name+String.valueOf(id);
        this.attemps = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttemps() {
        return attemps;
    }

    public void setAttemps(int attemps) {
        this.attemps = attemps;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(int winningNumber) {
        this.winningNumber = winningNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
    
    
    
    
    
    
}
