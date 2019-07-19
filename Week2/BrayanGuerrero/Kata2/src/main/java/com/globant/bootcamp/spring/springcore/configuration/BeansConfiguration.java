package com.globant.bootcamp.spring.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.globant.bootcamp.spring.springcore.domain.Score;

@Configuration
public class BeansConfiguration {
    
    @Bean
    @Scope("singleton")
    public Score scoreSingletonPlayer1() {
        return new Score(0, "I'm a singleton bean");
    }
    
    @Bean
    @Scope("singleton")
    public Score scoreSingletonPlayer2() {
        return new Score(0, "I'm a singleton bean");
    }
    
    @Bean
    @Scope("singleton")
    public Score scoreSingleton() {
        return new Score(0, "I'm a singleton bean");
    }
    
    @Bean
    @Scope("singleton")
    public Integer turnGeneralSingleton() {
        return new Integer(0);
    }
    
    @Bean
    @Scope("prototype")
    public Integer turnPrototype() {
    	return new Integer(0);
    }

}
