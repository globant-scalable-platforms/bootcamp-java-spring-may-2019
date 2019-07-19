package com.globant.bootcamp.spring.springcore.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.bootcamp.spring.springcore.domain.Score;


@RestController
public class StageOneController {
	
	private static int MIN_RANDOM = 0;
	private static int MAX_RANDOM = 5;
    
	@Autowired
    @Qualifier(value="scoreSingleton")
    private Score turnsGeneral;
    
    @Autowired
    @Qualifier(value="scoreSingletonPlayer1")
    private Score playerOne;
    
    @Autowired
    @Qualifier(value="scoreSingletonPlayer2")
    private Score playerTwo;
    
    @Autowired
    @Qualifier(value="turnPrototype")
    private Integer turn;
    
    @RequestMapping(value="/stage-one")
    public String getScopes() {
    	
    	if(turn < 3) {
    		StringBuilder mensaje = new StringBuilder();
    		turnsGeneral.setCount(turnsGeneral.getCount()+1);
    		int score = generateRandom(MIN_RANDOM, MAX_RANDOM);
			playerOne.setCount(playerOne.getCount()+score);
            turn = turn + 1;
            
            mensaje.append("Player 1 gets "+score+", current score: "+playerOne.getCount());
            
            if(turnsGeneral.getCount() == 6) {
        		if (playerOne.getCount() > playerTwo.getCount()) {
            		mensaje.append("\nPlayer 1 has won with a score of: "+playerOne.getCount());
            	} else if (playerTwo.getCount() > playerOne.getCount()) {
            		mensaje.append("\nPlayer 2 has won with a score of: "+playerTwo.getCount());
            	} else {
            		mensaje.append("\nthe two players had the same points: "+playerOne.getCount());
            	}
        	}
            return mensaje.toString();
    	}
    	
    	if(turnsGeneral.getCount() == 6) {
    		if (playerOne.getCount() > playerTwo.getCount()) {
        		return "Player 1 has won with a score of: "+playerOne.getCount();
        	} else if (playerTwo.getCount() > playerOne.getCount()) {
        		return "Player 2 has won with a score of: "+playerTwo.getCount();
        	} else {
        		return "the two players had the same points: "+playerOne.getCount();
        	}
    	}
    	
    	return "Player 1 doesn´t have more turns. Player 1 score: "+playerOne.getCount();
        
    }
    
    public int generateRandom(final int min, final int max) {
    	Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
    }
    
}
