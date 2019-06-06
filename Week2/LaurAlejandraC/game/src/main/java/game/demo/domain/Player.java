package game.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private int currentScore;
    private List<Integer> scores;

    public Player(){
        currentScore = 0;
        scores = new ArrayList<>();
    }

    public int getCurrentScore(){
        return currentScore;
    }

    public List<Integer> getScores(){
        return scores;
    }

    private void addScore(int a){
        currentScore += a;
    }

    public void play(){
        Random random = new Random();
        int curScore = random.nextInt(5001);
        addScore(curScore);
        scores.add(curScore);
    }
}
