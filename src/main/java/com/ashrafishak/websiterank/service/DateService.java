package com.ashrafishak.websiterank.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ashrafishak.websiterank.dao.DateVisitedDAO;
import com.ashrafishak.websiterank.entity.DateVisited;

@Path("/dateVisited")
@Produces(MediaType.APPLICATION_JSON)
public class DateService {
	
	@GET
	public List<DateVisited> getAllDateVisited(){
		return DateVisitedDAO.getAllDateVisited();
	}

}
