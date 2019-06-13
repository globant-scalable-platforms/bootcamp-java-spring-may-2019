package com.bootcamp.springboot.game.domain;

import java.util.Random;

public class Player {
	
	private int number1;
	private int number2;
	private int number3;
	
	public Player() {
		this.number1 = randomNumber();
		this.number2 = randomNumber();
		this.number3 = randomNumber();
	}
	
	private int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(6); //Obtain a number between 0 - 5
		return number;
	}

	public int getNumber1() {
		return number1;
	}

	public int getNumber2() {
		return number2;
	}

	public int getNumber3() {
		return number3;
	}
	

}
