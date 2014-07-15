package com.ashrafishak.calltransfer.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "agents")
public class Agents {
	
	private ArrayList<Agent> agents;

	public Agents(){
		this.agents = new ArrayList<Agent>();
	}
	
	public ArrayList<Agent> getAgents() {
		return agents;
	}

	@XmlElementWrapper(name = "agentList")
	@XmlElement(name = "agent")
	public void setAgents(ArrayList<Agent> agents) {
		this.agents = agents;
	}

	@Override
	public String toString() {
		return "Agents [agents=" + agents + "]";
	}
	
	
	
	
}
