package game.demo.domain;

import java.util.Random;

public class Player {
    private int currentScore;

    public Player(){
        currentScore = 0;
    }

    public int getCurrentScore(){
        return currentScore;
    }

    private void addScore(int a){
        currentScore += a;
    }

    public void play(){
        Random random = new Random();
        addScore(random.nextInt(5001));
    }
}
