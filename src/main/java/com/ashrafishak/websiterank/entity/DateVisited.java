package com.ashrafishak.websiterank.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement(name = "date")
public class DateVisited {
	
	private int id;
	private java.util.Date dateVisited;
	
	public DateVisited(){
		
	}

	public java.util.Date getDateVisited() {
		return dateVisited;
	}

	public void setDateVisited(java.util.Date dateVisited) {
		this.dateVisited = dateVisited;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	

	
	
	

}
