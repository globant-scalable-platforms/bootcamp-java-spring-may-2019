package com.globant.bootcamp.spring.springcore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.bootcamp.spring.springcore.domain.Score;


@RestController
public class PlayerTwoController {

    @Autowired
    @Qualifier(value = "scoreSingleton")
    private Score scoreTotal;

    @Autowired
    @Qualifier(value = "scorePrototype")
    private Score scorePlayer;

    @RequestMapping(value = "/player-two")
    public List<Score> getScopes() {
        final List<Score> result = new ArrayList<>();

        if (scoreTotal.getAttempt() == 6) {
            result.add(scoreTotal);
        }else{
            if (scorePlayer.getAttempt() < 3) {

                Random rand = new Random();
                rand.nextInt(5000);

                scorePlayer.setMessage("Player 2");

                scorePlayer.setNumber(rand.nextInt(5000));
                if (scorePlayer.getNumber() > scoreTotal.getNumber()) {
                    scoreTotal.setNumber(scorePlayer.getNumber());
                    scoreTotal.setMessage(scorePlayer.getMessage() + " won!!");
                }

                scorePlayer.setAttempt(scorePlayer.getAttempt() + 1);
                scoreTotal.setAttempt(scoreTotal.getAttempt() + 1);

            } else {
                scorePlayer.setMessage("No more attempts are allowed");
            }

            result.add(scorePlayer);
        }

        return result;
    }
}

