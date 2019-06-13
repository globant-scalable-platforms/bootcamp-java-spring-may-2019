package com.globant.bootcamp.spring.springcore.controller;

import com.globant.bootcamp.spring.springcore.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GameController {

    @Autowired
    @Qualifier(value="gameSingleton")
    private Game game;

    @Autowired
    private ApplicationContext appContext;

    @RequestMapping(value="/game")
    public Game getInfoGame() {
        if((game.getAttemptsPlayerOne() + game.getAttemptsPlayerTwo()) == 6) {
            game.setStatus("finished");
        }

        return game;
    }

    @RequestMapping(value="/reset")
    public Game resetGame() {
        Game resetGame = new Game("None", "started");
        ConfigurableListableBeanFactory resetBean = ((ConfigurableApplicationContext)appContext).getBeanFactory();

        resetBean.destroySingletons();
        resetBean.registerSingleton("gameSingleton", resetGame);

        return resetGame;
    }
}
