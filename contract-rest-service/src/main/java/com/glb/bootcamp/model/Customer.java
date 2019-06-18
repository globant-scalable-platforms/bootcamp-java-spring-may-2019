package com.glb.bootcamp.model;

import io.swagger.annotations.ApiModelProperty;

public class Customer {

	@ApiModelProperty(notes = "Customer id",name="id",required=true,value="test id")
	private Long id;
	@ApiModelProperty(notes = "Customer name",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Customer surname",name="surname",required=true,value="test surname")
	private String surname;

	public Customer() {
	}

	public Customer(Long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				'}';
	}
}
