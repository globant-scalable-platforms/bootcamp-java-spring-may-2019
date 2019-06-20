package com.springbootcamp.game.repository;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springbootcamp.game.data.ScorePlayer;

@Repository("StageThree")
public class FinalStage implements IStage{
	@Autowired
    @Qualifier(value="scoreTotal")
    private ScorePlayer scoreTotal;
    
    @Autowired
    @Qualifier(value="scoreStage")
    private ScorePlayer  scoreStage;
    
    public int play(int player) {
    	int score=new Random().nextInt(5000);
    	setScore(score,player);
    	return score;
    }

	private void setScore(int score, int player) {
		scoreStage.setPlayerScore(player, score+scoreStage.getPlayerScore(player));
    	scoreTotal.setPlayerScore(player, score+scoreTotal.getPlayerScore(player));
	}

}
