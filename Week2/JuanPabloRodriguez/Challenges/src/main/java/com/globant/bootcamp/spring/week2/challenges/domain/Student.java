package com.globant.bootcamp.spring.week2.challenges.domain;

public class Student {
	
	private String name;
	private int identification;
	private int age;
	
	public Student(String name, int identification, int age) {
		super();
		this.name = name;
		this.identification = identification;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getIdentification() {
		return identification;
	}

	public int getAge() {
		return age;
	}

}
