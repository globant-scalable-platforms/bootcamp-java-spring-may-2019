package com.globant.bootcamp.spring.springcore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.globant.bootcamp.spring.springcore.domain.Score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StageOneController {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    @Qualifier(value="scoreSingleton")
    private Score scoreTotal;

    @Autowired
    @Qualifier(value="scorePrototype")
    Score scoreStage;

    @RequestMapping(value="/stage-one")
    public List<Score> getScopes() {

        final List<Score> result = new ArrayList<>();
        Random random = new Random();
        int numPlayer1 = 0;
        int numPlayer2 = 0;
        for (int i = 0; i < 3; i++) {
            numPlayer1 = random.nextInt(5001);
            numPlayer2 = random.nextInt(5001);

            System.out.println("p1: "+numPlayer1+" p2: "+numPlayer2);

            if (numPlayer1 > numPlayer2) {
                scoreStage.setPlayer1(scoreStage.getPlayer1()+1);
                System.out.println("Gana P1");
            } else if (numPlayer2 > numPlayer1) {
                scoreStage.setPlayer2(scoreStage.getPlayer2()+1);
                System.out.println("Gana P2");
            }
        }

        if (scoreStage.getPlayer1() > scoreStage.getPlayer2()) {
            scoreTotal.setPlayer1(scoreTotal.getPlayer1()+1);
        } else if (scoreStage.getPlayer2() > scoreStage.getPlayer1()){
            scoreTotal.setPlayer2(scoreTotal.getPlayer2()+1);
        }

        result.add(scoreTotal);
        result.add(scoreStage);

        this.scoreStage = applicationContext.getBean("scorePrototype", Score.class);
        
        return result;
    }    
}
