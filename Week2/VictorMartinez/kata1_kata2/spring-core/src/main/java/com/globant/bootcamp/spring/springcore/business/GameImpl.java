package com.globant.bootcamp.spring.springcore.business;

import com.globant.bootcamp.spring.springcore.domain.PlayerPrototype;
import com.globant.bootcamp.spring.springcore.domain.PlayerSingleton;
import org.springframework.stereotype.Service;

@Service
public interface GameImpl {


        public void compareScores(PlayerPrototype player1, PlayerSingleton player2);
        public String getWinneMessage();

}
