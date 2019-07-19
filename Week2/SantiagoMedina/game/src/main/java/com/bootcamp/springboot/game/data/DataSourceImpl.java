package com.bootcamp.springboot.game.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bootcamp.springboot.game.domain.Player;

@Repository
public class DataSourceImpl implements DataSource{

	@Override
	public List<Player> simulatePlayers() {
		Player player1 = new Player();
		Player player2 = new Player();
		List<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		return players;
	}
	
}
