package com.ashrafishak.websiterank.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "visits")
public class Visits {

	private ArrayList<Visit> visitList;
	
	public Visits(){
		
	}

	public ArrayList<Visit> getVisitList() {
		return visitList;
	}

	@XmlElementWrapper(name = "visitList")
	@XmlElement(name = "visit")
	public void setVisitList(ArrayList<Visit> visitList) {
		this.visitList = visitList;
	}
	
	
}
