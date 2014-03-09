package com.ashrafishak.websiterank.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement (name = "visit")
@XmlType (propOrder = {"date", "website", "visitCount"})
public class Visit {
	
	
	private Website website;
	private DateVisited date;
	private int visitCount;
	
	public Visit(){
		
	}

	public Website getWebsite() {
		return website;
	}

	@XmlElement
	public void setWebsite(Website website) {
		this.website = website;
	}

	public DateVisited getDate() {
		return date;
	}

	@XmlElement
	public void setDate(DateVisited date) {
		this.date = date;
	}

	public int getVisitCount() {
		return visitCount;
	}

	@XmlElement
	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

}
