package davidAcuna.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import davidAcuna.domain.Game;
import davidAcuna.domain.Player;
import davidAcuna.domain.Score;

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
    
    //    Game Configuration
    @Bean
    @Scope("prototype")
    @Autowired
    public Player playerScope() {
        return new Player();
    }
    
    @Bean
    @Scope("singleton")
    @Autowired 
    public Game gameSingleton() {
        return new Game();
    }

}
