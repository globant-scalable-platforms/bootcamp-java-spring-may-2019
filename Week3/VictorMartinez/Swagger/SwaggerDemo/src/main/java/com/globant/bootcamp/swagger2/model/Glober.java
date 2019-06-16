package com.globant.bootcamp.swagger2.model;

import io.swagger.annotations.ApiModelProperty;

public class Glober {
	@ApiModelProperty(notes = "Name of the Glober",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Studio of the Glober",name="studio",required=true,value="test studio")
	private String studio;
	@ApiModelProperty(notes = "Country of the Glober",name="country",required=true,value="test country")
	private String country;

	public Glober() {
	}

	public Glober(String name, String studio, String country) {
		this.name = name;
		this.studio = studio;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getStudio() {
		return studio;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Glober [name=" + name + ", studio=" + studio + ", country=" + country + "]";
	}

}
