package com.globant.bootcamp.spring.springcore.configuration;

import com.globant.bootcamp.spring.springcore.domain.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.globant.bootcamp.spring.springcore.domain.Score;

@Configuration
public class BeansConfiguration {

    @Bean
    @Scope("singleton")
    public Game gameSingleton() {
        return new Game("None", "started");
    }

    @Bean
    @Scope("prototype")
    public Score scorePrototype() {
        return new Score(0, "Game started");
    }

}
