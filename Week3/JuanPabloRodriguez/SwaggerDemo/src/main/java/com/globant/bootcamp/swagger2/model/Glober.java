package com.globant.bootcamp.swagger2.model;

import io.swagger.annotations.ApiModelProperty;

public class Glober {
	@ApiModelProperty(notes = "Identification of the Glober",name="id",required=true,value="test id")
	private String id;
	@ApiModelProperty(notes = "Name of the Glober",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Studio of the Glober",name="studio",required=true,value="test studio")
	private String studio;
	@ApiModelProperty(notes = "Country of the Glober",name="country",required=true,value="test country")
	private String country;

	public Glober() {
	}

	public Glober(String id, String name, String studio, String country) {
		this.id = id;
		this.name = name;
		this.studio = studio;
		this.country = country;
	}

	public String getId() {
		return id;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Glober [id=" + id + ", name=" + name + ", studio=" + studio + ", country=" + country + "]";
	}

}
