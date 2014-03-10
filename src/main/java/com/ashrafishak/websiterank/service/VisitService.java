package com.ashrafishak.websiterank.service;

import java.util.ArrayList;
import java.util.Calendar;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ashrafishak.websiterank.dao.VisitsDAO;
import com.ashrafishak.websiterank.entity.*;
import com.ashrafishak.websiterank.util.SortBy;

@Path("visits") 
@Produces(MediaType.APPLICATION_JSON)
public class VisitService {

	// path: /service/visits/
	@GET
	@Produces (MediaType.APPLICATION_XML)
	public Visits getAllVisit(){
		return VisitsDAO.getAllWebsiteVisits();
	}
	
	
	// input = date
	// path: /service/visits/date/{date}?sortBy=[visit_asc, visit_desc, website_asc, website_desc]
	@GET
	@Path("/date/{date}")
	@Produces(MediaType.APPLICATION_XML)
	public Visits getVisitsByDate(@PathParam("date") String date, @DefaultValue("visit_desc") @QueryParam("sortBy") String sortBy){
		// TODO: We might want to avoid these if statements LOL
		SortBy type = SortBy.VISIT_DESC;
		if (sortBy.equals("visit_asc")){
			type = SortBy.VISIT_ASC;
		} else if (sortBy.equals("visit_desc")){
			type = SortBy.VISIT_DESC;
		} else if (sortBy.equals("website_asc")){
			type = SortBy.WEBSITE_ASC;
		} else if (sortBy.equals("website_desc")){
			type = SortBy.WEBSITE_DESC;
		}
		return VisitsDAO.getVisitsByDate(date, type);
	}
	
	// input = website
	// path: /service/visits/website/{website}?sortBy=[visit_asc, visit_desc, date_asc, date_desc]
	@GET
	@Path("/website/{website_name}")
	@Produces(MediaType.APPLICATION_XML)
	public Visits getVisitsByWebsite(@PathParam("website_name") String name, @DefaultValue("visit_desc") @QueryParam("sortBy") String sortBy){
		// TODO: We might want to avoid these if statements LOL
		SortBy type = SortBy.VISIT_DESC;
		if (sortBy.equals("visit_asc")){
			type = SortBy.VISIT_ASC;
		} else if (sortBy.equals("visit_desc")){
			type = SortBy.VISIT_DESC;
		} else if (sortBy.equals("date_asc")){
			type = SortBy.DATE_ASC;
		} else if (sortBy.equals("date_desc")){
			type = SortBy.DATE_DESC;
		}
		return VisitsDAO.getVisitsByWebsite(name, type);
		
	}
	
	
	
	
}
