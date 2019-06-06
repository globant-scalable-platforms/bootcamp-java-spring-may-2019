package game.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private int totalScore;
    private List<Integer> scores;

    public Player(){
        totalScore = 0;
        scores = new ArrayList<>();
    }

    int getTotalScore(){
        return totalScore;
    }

    List<Integer> getScores(){
        return scores;
    }

    private void addScore(int a){
        totalScore += a;
    }

    void play(){
        Random random = new Random();
        int curScore = random.nextInt(5001);
        addScore(curScore);
        scores.add(curScore);
    }
}
