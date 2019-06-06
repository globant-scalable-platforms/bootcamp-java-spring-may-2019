package game.demo.domain;

public class Game {
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

    public boolean play(int id){
        Player playerAttempting = getPlayer(id);

        if(playerAttempting == null || id != currentTurn || gameFinished())
            return false;

        playerAttempting.play();
        if(currentTurn == 2)
            attempts--;
        currentTurn = currentTurn == 2 ? 1 : 2;

        return true;
    }

    public boolean gameFinished(){
        return attempts <= 0;
    }

    public int getPlayerScore(int id){
        Player player = getPlayer(id);
        if(player != null)
            return player.getCurrentScore();
        return -1;
    }

    public int getCurrentTurn(){
        return currentTurn;
    }
}
