package com.springbootcamp.game.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.springbootcamp.game.data.ScorePlayer;
import com.springbootcamp.game.repository.IStage;

public class GameControl {
	
	@Autowired
	@Qualifier("StageOne")
	private IStage stageOne;
	
	@Autowired
	@Qualifier("StageTwo")
	private IStage stageTwo;
	
	@Autowired
	@Qualifier("StageThree")
	private IStage stageThree;
    
    private ScorePlayer scoreTotal;
    Scanner scanner = new Scanner(System.in);
    
    @Autowired
	public GameControl(ScorePlayer scoreTotal) {
		this.scoreTotal=scoreTotal;
	}

	public void initSession() {
		
	    System.out.println("***GAME OF CHANCE - ARE YOU LUCKY?***");
	    System.out.println("**Every gamer will have three shifts**");
	    System.out.println("Press Enter to Continue");
	    scanner.nextLine();
	    	runShift(stageOne);
	    	runShift(stageTwo);
	    	runShift(stageThree);
	    	winnerIs();
	}


	private void winnerIs() {
		if(scoreTotal.getPlayerScore(0)>scoreTotal.getPlayerScore(1))
		{System.out.println("We have a winner!!!! .... PLAYER 1 Congratulations!!!!");}
		else {System.out.println("We have a winner!!!! .... PLAYER 2 Congratulations!!!!");
		}
	}

	private void runShift(IStage stage) {
		 for (int i=0;i<2;i++) {
	        System.out.println("Player "+(i+1)+" Press Enter to Play:");
		    scanner.nextLine();
		    System.out.println(stageOne.play(i));
		 }
	}
    
  
}
