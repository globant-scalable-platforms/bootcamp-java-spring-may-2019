package com.springbootcamp.game.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import com.springbootcamp.game.data.ScorePlayer;
import com.springbootcamp.game.controller.GameControl;

@SpringBootConfiguration
@ComponentScan(basePackages = "com.springbootcamp.game")
public class BeansConfiguration {
    
    @Bean
    @Scope("singleton")
    public ScorePlayer scoreTotal() {
        return new ScorePlayer(0,0);
    }
    
    @Bean
    @Scope("prototype")
    public ScorePlayer scoreStage() {
        return new ScorePlayer(0,0);
    }
    @Bean
    public GameControl gameControl() {
        return new GameControl(scoreTotal());
    }
    
    public static void main(String[] args)  {
       ApplicationContext applicationContext = SpringApplication.run(BeansConfiguration.class, args);
       GameControl gameControl = applicationContext.getBean(GameControl.class);
       gameControl.initSession();
    }
    
   
}