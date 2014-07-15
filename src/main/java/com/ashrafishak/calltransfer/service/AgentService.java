package com.ashrafishak.calltransfer.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;

import com.ashrafishak.calltransfer.dao.AgentDAO;
import com.ashrafishak.calltransfer.dao.UserDAO;
import com.ashrafishak.calltransfer.entity.Agent;
import com.ashrafishak.calltransfer.entity.Agents;
import com.ashrafishak.calltransfer.util.HibernateUtil;

@Path("agents")
@Produces(MediaType.APPLICATION_JSON)
public class AgentService {
	
	@GET
	public Agents getAgentsByChar(@QueryParam("prefix") String prefix, @QueryParam("user") String user, @QueryParam("apiToken") String apiToken){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Agents agents = null;
		if (UserDAO.validateUser(user, apiToken, session)){
			agents = AgentDAO.getAgentsByChar(prefix, session);
		} 
		session.close();
		HibernateUtil.shutdown();
		return agents;
	}
	
	
	

}
