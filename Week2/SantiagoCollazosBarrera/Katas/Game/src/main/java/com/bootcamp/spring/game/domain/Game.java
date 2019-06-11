/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.spring.game.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Collazos Barrera
 */
public class Game {
    
    public final static int ATTEMPS = 3;

    public final static int MIN = 0;
    public final static int MAX = 5000;

    private Player winningPlayer;  
    private String message;
    private int winningNumber;

    public Game() {
    }
    
    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public void setWinningPlayer(Player winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(int winningNumber) {
        this.winningNumber = winningNumber;
    }
    
    
}