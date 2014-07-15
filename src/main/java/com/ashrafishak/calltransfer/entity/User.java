package com.ashrafishak.calltransfer.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement (name = "user")
public class User {
	
	private int id;
	private String username;
	private String apiToken;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	
	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}
	public String getApiToken() {
		return apiToken;
	}
	
	@XmlElement
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", apiToken="
				+ apiToken + "]";
	}
	
	
	
	
	

}
