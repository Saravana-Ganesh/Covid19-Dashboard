package com.covid.bo;

import java.util.List;

public class ResponseBO {
	
	private int status;
	private int tokenID;	
	private RegistrationBO registrationBO;
	private List<Object[]> results;
	
	
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

	public int getTokenID() {
		return tokenID;
	}

	public void setTokenID(int tokenID) {
		this.tokenID = tokenID;
	}

	public List<Object[]> getResults() {
		return results;
	}

	public void setResults(List<Object[]> results) {
		this.results = results;
	}

	
}
