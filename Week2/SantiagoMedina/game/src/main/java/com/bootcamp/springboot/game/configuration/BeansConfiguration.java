package com.bootcamp.springboot.game.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.bootcamp.springboot.game.domain.Score;


@Configuration
public class BeansConfiguration {
	
	@Bean
    @Scope("singleton")
    public Score scoreSingleton() {
        return new Score(0,0, "I'm the total score (Singleton)");
    }
    
    @Bean
    @Scope("prototype")
    public Score scorePrototype() {
        return new Score(0,0, "I'm a prototype bean and I'm the partial score for differents battles");
    }
	

}
