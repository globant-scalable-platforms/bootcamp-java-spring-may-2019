package com.springbootcamp.game.repository;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springbootcamp.game.data.ScorePlayer;

@Repository("StageOne")
public class FirstStage implements IStage{
	
    private ScorePlayer scoreTotal;
    private ScorePlayer  scoreStage;

	public FirstStage(@Qualifier("scoreTotal")ScorePlayer scoreTotal, @Qualifier("scoreStage")ScorePlayer scoreStage) {
		this.scoreTotal = scoreTotal;
		this.scoreStage = scoreStage;
	}

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
