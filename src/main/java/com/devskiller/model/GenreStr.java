package com.devskiller.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GenreStr {
	@Id
	private String name;

	public GenreStr() {
		
	}
	
	public GenreStr(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}