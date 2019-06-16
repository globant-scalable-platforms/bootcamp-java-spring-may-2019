package com.bootcamp.springboot.game.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.springboot.game.domain.Player;

@Service
public class GameSimulationImpl implements GameSimulation{

	@Override
	public int comparePlayers(Player player1, Player player2) {
		List<Integer> results = new ArrayList<>();
		results.add(compareTwoNumbers(player1.getNumber1(),player2.getNumber1()));
		results.add(compareTwoNumbers(player1.getNumber2(),player2.getNumber2()));
		results.add(compareTwoNumbers(player1.getNumber3(),player2.getNumber3()));

		return result(results);
	}
	
	private Integer compareTwoNumbers (int numberA , int numberB) {
		if(numberA > numberB) {
			return 1;
		}else if (numberA < numberB){
			return 2;
		}else {
			return 0;
		}
	}
	
	private int result(List<Integer> totalResults) {
		int winsPlayer1 = 0;
		int winsPlayer2 = 0;
		int result = 0;
		
		for(Integer win : totalResults) {
			if(win == 1) {
				winsPlayer1 ++;
			}else if (win == 2) {
				winsPlayer2 ++;
			}
		}
		
		if(winsPlayer1 > winsPlayer2) {
			result = 1;
		}else if(winsPlayer1 < winsPlayer2) {
			result = 2;
		}
		
		return result;
		
	}

}
