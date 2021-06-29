package com.covid.bo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dinesh")
public class TestMongoBO {
	public TestMongoBO() {
		
	}
	public TestMongoBO(int id,String name,String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	@Id
	private int id=1;
	private String name="Saravana Ganesh The Legend In Google";
	private String city="Mountain View, California";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}	
