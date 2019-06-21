package game.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class Game {
    @Autowired
    private ApplicationContext applicationContext;

    private Player player1;
    private Player player2;
    private int currentTurn;
    private int attempts;

    public Game(final Player player1, final Player player2){
        this.player1 = player1;
        this.player2 = player2;
        currentTurn = 1;
        attempts = 3;
    }

    private Player getPlayer(int id){
        if(id == 1)
            return player1;
        if(id == 2)
            return player2;
        return null;
    }

    public void play(int id){
        Player playerAttempting = getPlayer(id);

        if(playerAttempting == null || id != currentTurn || gameFinished())
            return;

        playerAttempting.play();
        if(currentTurn == 2)
            attempts--;
        currentTurn = currentTurn == 2 ? 1 : 2;
    }

    public boolean gameFinished(){
        return attempts <= 0;
    }

    public int getPlayerScore(int id){
        Player player = getPlayer(id);
        if(player != null)
            return player.getTotalScore();
        return -1;
    }

    public String getScores(int id){
        Player player = getPlayer(id);
        if(player != null)
            return player.getTotalScore() + ", " + player.getScores();
        return "";
    }

    public int getCurrentTurn(){
        return currentTurn;
    }

    public void resetGame(){
        this.player1 = applicationContext.getBean(Player.class);
        this.player2 = applicationContext.getBean(Player.class);
        currentTurn = 1;
        attempts = 3;
    }
}
