package com.bootcamp.springRest.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class Student {

	@NotNull
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastName;
	
	private Integer age;

	private float average;
	
	private LocalDate date;
	
	public Student() {}
	
	public Student(Integer id, Integer age, String name, String lastName, int days) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.average = 0;
		this.date = LocalDate.now().minusDays(days);
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
