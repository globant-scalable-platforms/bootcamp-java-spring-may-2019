/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.spring.game.controller;

import com.bootcamp.spring.game.domain.Game;
import com.bootcamp.spring.game.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santiago Collazos Barrera
 */
@RestController
@RequestMapping("/game")
public class GameController {

    
    
    @Autowired
    @Qualifier(value = "gameSingleton")
    private Game game;

    @Autowired
    @Qualifier(value = "playerPrototype")
    private Player player1;

    @Autowired
    @Qualifier(value = "playerPrototype")
    private Player player2;

    @GetMapping("/player-one")
    public Object getResultPlayerOne() {
        if ((player1.getAttemps() == player2.getAttemps()) && player1.getAttemps() == game.ATTEMPS) {
            //mostrar ganador
            if(player1.getWinningNumber() > player2.getWinningNumber()){
                assingWinnerValues(player1);
                return game;
            }
            assingWinnerValues(player2);
            return game;
        }
        if (player1.getAttemps() < game.ATTEMPS) {
            int number = getRandom();
            if (number > player1.getWinningNumber()) {
                player1.setWinningNumber(number);
            }
            player1.setAttemps(player1.getAttemps() + 1);
        } else {
            //Intentos finalizados
            player1.setMessage("Ended attemps");
        }
        return player1;
    }

    @GetMapping("/player-two")
    public Object getResultPlayerTwo() {
        if ((player1.getAttemps() == player2.getAttemps()) && player2.getAttemps() == game.ATTEMPS) {
            //mostrar ganador
            if(player2.getWinningNumber() > player1.getWinningNumber()){                
                assingWinnerValues(player2);
                return player2;
            }
            assingWinnerValues(player1);
            return game;
        }
        if (player2.getAttemps() < game.ATTEMPS) {
            int number = getRandom();
            if (number > player2.getWinningNumber()) {
                player2.setWinningNumber(number);
            }
            player2.setAttemps(player2.getAttemps() + 1);
        } else {
            //Intentos finalizados
            player2.setMessage("Ended attemps"); 
        }
        return player2;
    }

    private int getRandom() {
        return (int)(game.MAX * Math.random());
    }
    private void assingWinnerValues(Player winner){
        game.setWinningPlayer(winner);
        game.setWinningNumber(winner.getWinningNumber());
        game.setMessage(winner.getName()+" you're the winner!!!");
        winner.setWinner(true);
        
    }

}
