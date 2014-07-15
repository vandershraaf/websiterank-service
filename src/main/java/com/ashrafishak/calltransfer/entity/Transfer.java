package com.ashrafishak.calltransfer.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement (name = "transfer")
public class Transfer {
	
	

	private int id;
	private com.ashrafishak.calltransfer.entity.Date date;
	private Account account;
	private User user;
	private Agent agent;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public com.ashrafishak.calltransfer.entity.Date getDate() {
		return date;
	}
	
	@XmlElement
	public void setDate(com.ashrafishak.calltransfer.entity.Date date) {
		this.date = date;
	}
	public Account getAccount() {
		return account;
	}
	
	@XmlElement
	public void setAccount(Account account) {
		this.account = account;
	}
	public User getUser() {
		return user;
	}
	
	@XmlElement
	public void setUser(User user) {
		this.user = user;
	}
	public Agent getAgent() {
		return agent;
	}
	
	@XmlElement
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	@Override
	public String toString() {
		return "Transfer [id=" + id + ", date=" + date + ", account=" + account
				+ ", user=" + user + ", agent=" + agent + "]";
	}
	
	

}
