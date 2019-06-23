/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.spring.game.configuration;

import com.bootcamp.spring.game.domain.Game;
import com.bootcamp.spring.game.domain.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Santiago Collazos Barrera
 */
@Configuration
public class BeansConfiguration {
    
    private int id=1;    

    @Bean
    @Scope("prototype")
    public Player playerPrototype(){
        return new Player(id++,"Player");
    }
    
    @Bean
    @Scope("singleton")
    public Game gameSingleton(){
        return new Game();
    }
    
}
