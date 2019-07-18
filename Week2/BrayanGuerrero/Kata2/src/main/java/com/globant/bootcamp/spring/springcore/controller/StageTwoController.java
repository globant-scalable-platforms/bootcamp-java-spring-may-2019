package com.globant.bootcamp.spring.springcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.bootcamp.spring.springcore.domain.Score;


@RestController
public class StageTwoController {
    
    @Autowired
    @Qualifier(value="scoreSingleton")
    private Score scoreTotal;
    
    @Autowired
    @Qualifier(value="scoreSingletonPlayer1")
    private Score scoreStage;
    
    @Autowired
    @Qualifier(value="scoreSingletonPlayer2")
    private Score scoreStage2;
    
    @Autowired
    @Qualifier(value="turnPrototype")
    private int turn;
    
    @RequestMapping(value="/stage-two")
    public List<Score> getScopes() {
    	
    	if(turn < 3) {
    		final List<Score> result = new ArrayList<>();
            scoreTotal.setCount(scoreTotal.getCount()+1);
            scoreStage2.setCount(scoreStage2.getCount()+1);
            turn = turn + 1;
            result.add(scoreTotal);
            result.add(scoreStage2);
            
            return result;
    	}
    	
    	return null;
        
    }    
}
