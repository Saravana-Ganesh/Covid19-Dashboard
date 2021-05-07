package com.covid.bo;

public class EmailBO {
	private String mailSubject;
	private String mailBodyContent;
	private String[] toMailList;
	
	public String getMailSubject() {
		return mailSubject;
	}
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	public String getMailBodyContent() {
		return mailBodyContent;
	}
	public void setMailBodyContent(String mailBodyContent) {
		this.mailBodyContent = mailBodyContent;
	}
	public String[] getToMailList() {
		return toMailList;
	}
	public void setToMailList(String[] toMailList) {
		this.toMailList = toMailList;
	}
	
}
