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
        return new Score(0, "Soy el Singleton");
    }
    
    @Bean
    @Scope("prototype")
    public Score scorePrototype() {
        return new Score(0, "Soy el Prototype");
    }

}
