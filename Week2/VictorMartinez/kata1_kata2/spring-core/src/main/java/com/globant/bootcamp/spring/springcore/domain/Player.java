package com.globant.bootcamp.spring.springcore.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Player {
    public int defaultOpportunities = 3;
    public int defaultRange = 5;
    public String playerName;
    public ArrayList<Integer> Score;
    public TreeMap<Integer, ArrayList<Integer>> scoreHistory;


    public Player(String playerName){
        this.playerName = playerName;
        Score = new ArrayList<Integer>();
        scoreHistory = new TreeMap<Integer, ArrayList<Integer>>();

    }

    public Player(Player Pl){
        this.playerName = Pl.getPlayerName();
        this.scoreHistory = Pl.getscoreHistory();
    }

    public int getRandomNumber(){
        return (int)Math.floor(Math.random()*defaultRange);
    }

    public ArrayList<Integer> randomNumbers(){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i =0; i<defaultOpportunities;i++){
            nums.add(getRandomNumber());
        }
        if (scoreHistory.isEmpty()){ this.scoreHistory.put(1, nums);} else{ this.scoreHistory.put(scoreHistory.lastKey()+1, nums);}
        return nums;
    }

    public String getPlayerName(){
        return this.playerName;
    }
    public ArrayList<Integer> getScorePlayer(){
        return this.Score;
    }

    public TreeMap<Integer, ArrayList<Integer>> getscoreHistory(){
        return this.scoreHistory;
    }

}
