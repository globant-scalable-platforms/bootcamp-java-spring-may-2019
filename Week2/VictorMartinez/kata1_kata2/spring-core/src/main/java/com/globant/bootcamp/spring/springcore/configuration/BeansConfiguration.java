package com.globant.bootcamp.spring.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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

  /*  @Bean
    @Scope("setScoreSingletonPlayer")
    public Score scorePlayerSingleton(Player player) {return new Score(player.getScorePlayer().getCount(), "Singleton "+player.getPlayerName()); }

    @Bean
    @Scope("setScorePrototypePlayer")
    public Score scorePlayerPrototype(Player player) {return new Score(player.getScorePlayer().getCount(), "Prototype "+player.getPlayerName()); }
    */

}
