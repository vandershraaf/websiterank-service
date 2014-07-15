package com.ashrafishak.calltransfer.entity;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement (name = "dateTag")
public class Date {
	
	private int id;
	private java.util.Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.util.Date getDate() {
		return date;
	}
	
	@XmlElement
	public void setDate (java.util.Date date){
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Date [id=" + id + ", date=" + date + "]";
	}
	
	/*
	public void setDate(java.sql.Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		this.date = cal.getTime();
	}
	*/
	
	

}
