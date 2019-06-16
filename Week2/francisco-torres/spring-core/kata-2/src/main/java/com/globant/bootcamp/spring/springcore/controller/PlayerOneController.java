package com.globant.bootcamp.spring.springcore.controller;

import java.util.Random;

import com.globant.bootcamp.spring.springcore.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.bootcamp.spring.springcore.domain.Score;


@RestController
public class PlayerOneController {
    
    @Autowired
    @Qualifier(value="gameSingleton")
    private Game game;
    
    @Autowired
    @Qualifier(value="scorePrototype")
    private Score score;
    
    @RequestMapping(value="/player-one")
    public Score getAttempt() {
        if(game.getAttemptsPlayerOne() == 3) {
            return score;
        }

        score.setCount(new Random().nextInt(5000) + score.getCount());
        game.setAttemptsPlayerOne(game.getAttemptsPlayerOne() + 1);
        score.setMessage("Attempt -> " + game.getAttemptsPlayerOne());

        if(game.getWinnerScore() < score.getCount()) {
            game.setWinnerPlayer("player-one");
            game.setWinnerScore(score.getCount());
        }

        return score;
    }
}
