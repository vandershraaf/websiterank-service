package com.ashrafishak.calltransfer.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement (name = "account")
public class Account {
	
	private int id;
	private String acctNum;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcctNum() {
		return acctNum;
	}
	
	@XmlElement
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", acctNum=" + acctNum + "]";
	}
	
	

}
