package com.covid.bo;

public class ResponseBO {
	
	private int status;
	private String statusMessage;
	private RegistrationBO registrationBO;
		
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public RegistrationBO getRegistrationBO() {
		return registrationBO;
	}

	public void setRegistrationBO(RegistrationBO registrationBO) {
		this.registrationBO = registrationBO;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}