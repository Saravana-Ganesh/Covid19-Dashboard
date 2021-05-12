package com.covid.bo;

public class RegistrationBO {
	private String name;
	private int password1;
	private String email;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		if(password1.length()>5)
			this.password1 = password1.hashCode();		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
		
}
