package com.bootcamp.springboot.game.data;

import java.util.List;

import com.bootcamp.springboot.game.domain.Player;

public interface DataSource {

	List<Player> simulatePlayers();
	
}
