package com.ashrafishak.calltransfer.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "transfers")
public class Transfers {
	
	private ArrayList<Transfer> transfers;

	public Transfers (){
		this.transfers = new ArrayList<Transfer>();
	}
	
	public ArrayList<Transfer> getTransfers() {
		return transfers;
	}

	@XmlElementWrapper(name = "transferList")
	@XmlElement(name = "transfer")
	public void setTransfers(ArrayList<Transfer> transfers) {
		this.transfers = transfers;
	}
	

}
