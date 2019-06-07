package com.globant.bootcamp.spring.springcore.controller;

import com.globant.bootcamp.spring.springcore.business.Game;
import com.globant.bootcamp.spring.springcore.business.GameImpl;
import com.globant.bootcamp.spring.springcore.data.GameDAO;
import com.globant.bootcamp.spring.springcore.domain.Player;
import com.globant.bootcamp.spring.springcore.domain.PlayerPrototype;
import com.globant.bootcamp.spring.springcore.domain.PlayerSingleton;
import com.globant.bootcamp.spring.springcore.domain.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class GameController {

    private Game game;
    private PlayerSingleton playerSingleton;
    private PlayerPrototype playerPrototype;

    @Autowired
    private ApplicationContext context;


    @Autowired
    public GameController(final Game game, final PlayerPrototype playerPrototype, final PlayerSingleton playerSingleton){
        this.game = game;
        this.playerPrototype = playerPrototype;
        this.playerSingleton = playerSingleton;

    }


    @RequestMapping(value="/Game", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String playGame() {
        restartPlayers();
        game.compareScores(playerPrototype, playerSingleton);
        return  "Round # "+playerSingleton.getscoreHistory().size()+" : \r\n \r\n"+
                "  Result "+game.getWinneMessage()+"\r\n\r\n"
                + "         History Player Prototype " + playerPrototype.getscoreHistory().toString()+" \r\n"
                + "         History Player Singletone" + playerSingleton.getscoreHistory().toString()+" \r\n";
    }

    public void restartPlayers(){
        this.playerSingleton  = context.getBean(PlayerSingleton.class);
        this.playerPrototype  = context.getBean(PlayerPrototype.class) ;
    }


}