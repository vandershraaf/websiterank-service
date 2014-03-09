package com.ashrafishak.websiterank.service;

import java.util.ArrayList;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ashrafishak.websiterank.entity.*;

@Path("visits") 
@Produces(MediaType.APPLICATION_JSON)
public class VisitService {

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_XML)
	public Website getDummy1(){
		return getWebsite();
	}
	
	@GET
	@Path("/date/{date}")
	@Produces(MediaType.APPLICATION_XML)
	public Visits getVisitsByDate(@PathParam("date") DateVisited date){
		return getDummy();
	}
	
	@GET
	@Path("/website/{website_name}")
	@Produces(MediaType.APPLICATION_XML)
	public Visits getVisitsByWebsite(@PathParam("website_name") String name){
		return getDummy(name);
	}
	
	
	// For testing purpose only 
	public Visits getDummy(){
		Visits visits = new Visits();
		Website website = new Website();
		website.setName("google.com");
		DateVisited date = new DateVisited();
		date.setDateVisited(Calendar.getInstance().getTime());
		Visit v = new Visit();
		v.setWebsite(website);
		v.setDate(date);
		v.setVisitCount(10000);
		ArrayList<Visit> list = new ArrayList<Visit>();
		list.add(v);
		visits.setVisitList(list);
		return visits;
	}
	
	// For testing purpose only 
	public Visits getDummy(String websiteName){
		Visits visits = new Visits();
		Website website = new Website();
		website.setName(websiteName);
		DateVisited date = new DateVisited();
		date.setDateVisited(Calendar.getInstance().getTime());
		Visit v = new Visit();
		v.setWebsite(website);
		v.setDate(date);
		v.setVisitCount(10000);
		ArrayList<Visit> list = new ArrayList<Visit>();
		list.add(v);
		visits.setVisitList(list);
		return visits;
	}
	
	public Website getWebsite(){
		Website website = new Website();
		website.setName("google.com");
		return website;
	}
	
}
