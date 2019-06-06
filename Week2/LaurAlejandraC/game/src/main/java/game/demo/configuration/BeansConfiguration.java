package game.demo.configuration;

import game.demo.domain.Game;
import game.demo.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeansConfiguration {

    @Bean
    @Scope("prototype")
    public Player player(){
        return new Player();
    }

    @Bean
    @Scope("singleton")
    @Autowired
    public Game game(final Player player1, final Player player2){
        return new Game(player1, player2);
    }
}
