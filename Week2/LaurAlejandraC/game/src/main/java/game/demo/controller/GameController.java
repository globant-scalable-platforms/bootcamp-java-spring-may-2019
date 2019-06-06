package game.demo.controller;

import game.demo.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    Game curGame;

    @GetMapping(produces = "text/plain")
    public String getGameInformation(){
        StringBuilder sb = new StringBuilder();
        sb.append("Has game finished: " ).append(curGame.gameFinished());
        sb.append(System.getProperty("line.separator"));

        sb.append(curScores());

        if(curGame.gameFinished()){
            int scorePlayer1 = curGame.getPlayerScore(1);
            int scorePlayer2 = curGame.getPlayerScore(2);

            sb.append(System.getProperty("line.separator"));
            sb.append(" ----- WINNER: ");

            if(scorePlayer1 == scorePlayer2)
                sb.append("It's a tie!!");
            else
                sb.append("Player ").append(scorePlayer1 > scorePlayer2 ? "1" : "2");
        }

        return sb.toString();
    }

    @GetMapping(value = "/player1", produces = "text/plain")
    public String player1(){
        return play(1);
    }

    @GetMapping(value = "/player2", produces = "text/plain")
    public String player2(){
        return play(2);
    }

    private String curScores(){
        StringBuilder sb = new StringBuilder();

        sb.append("Player 1 score: ").append(curGame.getPlayerScore(1));
        sb.append(System.getProperty("line.separator"));

        sb.append("Player 2 score: ").append(curGame.getPlayerScore(2));
        sb.append(System.getProperty("line.separator"));

        return sb.toString();
    }

    private String play(int id){
        if(curGame.gameFinished())
            return "Game has already finished: " + curScores();

        if(curGame.getCurrentTurn() != id)
            return "Current turn: " + curGame.getCurrentTurn() + System.getProperty("line.separator") + curScores();

        curGame.play(id);

        return getGameInformation();
    }

}
