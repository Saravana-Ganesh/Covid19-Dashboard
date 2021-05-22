package com.covid.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.covid.constants.TableConstants;
@Entity
@Table(name = TableConstants.USER_DETAIL_MASTER,schema="SYSTEM")
public class RegistrationBO {
	@Id
	@Column(name = "ID",unique=true)
	private int id = 0;
	@Column(name = "IS_Active")
	private int isActive = 0;
	@Column(name = "USER_NAME")
	private String name;
	@Column(name = "PASSWORD")
	private int password1;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
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
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}	
	public void setId(int id) {
		this.id =id;
	}
	public int getId() {
		return id;
	}
}
