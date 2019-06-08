package com.globant.bootcamp.spring.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.globant.bootcamp.spring.springcore.data.DataSource;
import com.globant.bootcamp.spring.springcore.domain.Game;
import com.globant.bootcamp.spring.springcore.domain.Score;

@Configuration
public class BeansConfiguration {
    
    @Bean
    @Scope("singleton")
    public Score scoreSingleton() {
        return new Score(0, "I'm a singleton bean");
    }
    
    @Bean
    @Scope("prototype")
    public Score scorePrototype() {
        return new Score(0, "I'm a prototype bean");
    }
    
    @Bean
    @Scope("singleton")
    public Game gameSingleton1() {
        return new Game("Player 1 (singleton) ->", 0, 0, false, "playing");
    }
    
    @Bean
    @Scope("singleton")
    public Game gameSingleton2() {
        return new Game("Player 2 (singleton) ->", 0, 0, false, "playing");
    }
    
    @Bean
    @Scope("prototype")
    public Game gamePrototype() {
        return new Game("Random number (prototype) ->", 0, 0, false, "playing");
    }
    
    @Bean
    public DataSource dataSource(){
        return new DataSource();
    }

}
