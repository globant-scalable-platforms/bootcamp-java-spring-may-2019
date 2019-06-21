package com.bootcamp.springboot.game.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.springboot.game.data.DataSource;
import com.bootcamp.springboot.game.domain.Player;
import com.bootcamp.springboot.game.domain.Score;
import com.bootcamp.springboot.game.service.GameSimulation;

@RestController
public class StageTwoController {
	
	@Autowired
    @Qualifier(value="scoreSingleton")
    private Score scoreTotal;
    
    @Autowired
    @Qualifier(value="scorePrototype")
    private Score scoreStage;
    
    @Autowired
    private GameSimulation gamesimulation;
    
    @Autowired
    private DataSource datasource;
    
    @RequestMapping(value="/stage-two")
    public List<Score> getScopes() {
    	scoreStage.setMessage("I'm the local Score for the stage-two (Prototype)");
    	List<Player> players = datasource.simulatePlayers();
    	int resultGame = gamesimulation.comparePlayers(players.get(0), players.get(1));
    	if (resultGame == 1) {
    		scoreTotal.setCountPlayer1(scoreTotal.getCountPlayer1()+1);
    		scoreStage.setCountPlayer1(scoreStage.getCountPlayer1()+1);
    	}else if (resultGame == 2) {
    		scoreTotal.setCountPlayer2(scoreTotal.getCountPlayer2()+1);
    		scoreStage.setCountPlayer2(scoreStage.getCountPlayer2()+1);
    	}
    	
    	scoreStage.setPlayer1(players.get(0));
		scoreStage.setPlayer2(players.get(1));
    	
    	
        final List<Score> result = new ArrayList<>();
        
        result.add(scoreTotal);
        result.add(scoreStage);
        
        return result;
    }

}
