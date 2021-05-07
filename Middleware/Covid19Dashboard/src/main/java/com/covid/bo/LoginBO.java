package com.covid.bo;

public class LoginBO {
	private int password;
	private String userEmail;
	
	public int getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password.hashCode();
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
