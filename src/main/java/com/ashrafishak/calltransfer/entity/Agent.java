package com.ashrafishak.calltransfer.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement (name = "agent")
public class Agent {
	
	private int id;
	private String username;
	
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
	@Override
	public String toString() {
		return "Agent [id=" + id + ", username=" + username + "]";
	}
	
	

}
