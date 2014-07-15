package com.ashrafishak.calltransfer.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement (name = "response")
public class PostResponse {
	
	private String responseResult;

	public String getResponseResult() {
		return responseResult;
	}

	@XmlElement
	public void setResponseResult(String responseResult) {
		this.responseResult = responseResult;
	}
	
	

}
