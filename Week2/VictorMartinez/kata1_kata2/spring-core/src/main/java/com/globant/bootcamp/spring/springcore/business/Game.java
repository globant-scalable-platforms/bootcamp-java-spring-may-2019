package com.globant.bootcamp.spring.springcore.business;

import com.globant.bootcamp.spring.springcore.domain.Player;
import com.globant.bootcamp.spring.springcore.domain.PlayerPrototype;
import com.globant.bootcamp.spring.springcore.domain.PlayerSingleton;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class Game implements GameImpl {

    private ArrayList<Integer> scorePrototype;
    private ArrayList<Integer> scoreSingleton;

    public Game(){
    }


    public void compareScores(PlayerPrototype player1, PlayerSingleton player2) {
        this.scorePrototype = player1.randomNumbers();
        this.scoreSingleton = player2.randomNumbers();
    }

    public String getWinneMessage(){

        return (scoreSingleton.stream().mapToInt(num->num).sum()>=scorePrototype.stream().mapToInt(num->num).sum())?
                "Player 1 (Prototype Player) WON with  a score of "+ Integer.toString(scoreSingleton.stream().mapToInt(num->num).sum()):
                "Player 2 (Singleton Player) WON with  a score of "+ Integer.toString(scorePrototype.stream().mapToInt(num->num).sum());
    }


}
