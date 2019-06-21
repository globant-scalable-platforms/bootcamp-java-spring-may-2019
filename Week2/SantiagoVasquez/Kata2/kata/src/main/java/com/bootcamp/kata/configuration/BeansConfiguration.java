package com.bootcamp.kata.configuration;

import com.bootcamp.kata.data.HighScoreGameInterface;
import com.bootcamp.kata.data.HighScoreImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeansConfiguration {

    @Bean
    @Scope("singleton")
    public HighScoreGameInterface singletonGame() {
        return new HighScoreImpl();
    }

    @Bean
    @Scope("prototype")
    public HighScoreGameInterface prototypeGame() {
        return new HighScoreImpl();
    }
}
