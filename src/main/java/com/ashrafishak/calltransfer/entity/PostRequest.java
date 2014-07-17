package com.ashrafishak.calltransfer.entity;

public class PostRequest {
	
	private String account;
	private String agent;
	private String date;
	private String user;
	private String apiToken;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAgent() {
		return agent;
	}
	
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getApiToken() {
		return apiToken;
	}
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	
	@Override
	public String toString() {
		return "PostRequest [account=" + account + ", agent=" + agent
				+ ", date=" + date + ", user=" + user + ", apiToken="
				+ apiToken + "]";
	}
	
	
	
	

}
