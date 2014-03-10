package com.ashrafishak.websiterank.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ashrafishak.websiterank.dao.WebsiteDAO;
import com.ashrafishak.websiterank.entity.Website;

@Path("/website")
@Produces(MediaType.APPLICATION_JSON)
public class WebsiteService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Website> getAllWebsite(){
		return WebsiteDAO.getAllWebsite();
	}
}
