package com.globant.bootcamp.spring.springcore.data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.TreeMap;


public class GameDAO {

    private String message;
    private String lastResult;
    private TreeMap<Integer, ArrayList<Integer>> historyPlayer1;
    private TreeMap<Integer, ArrayList<Integer>> historyPlayer2;

    public GameDAO(String message, String result, TreeMap<Integer, ArrayList<Integer>> historyPLayer1, TreeMap<Integer, ArrayList<Integer>> historyPlayer2) {
        this.message        = (message==null)? "No Message": message;
        this.lastResult     = (result==null )? "No Result " : result;
        this.historyPlayer1 = historyPLayer1;
        this.historyPlayer2 = historyPlayer2;
    }



}
