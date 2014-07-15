package com.ashrafishak.calltransfer.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.ashrafishak.calltransfer.dao.UserDAO;
import com.ashrafishak.calltransfer.entity.User;
import com.ashrafishak.calltransfer.util.HibernateUtil;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {
	
	@GET
	@Path("/user/login")
	public User login(@QueryParam("username") String username){
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = UserDAO.getUserByUsername(username, session);
		session.close();
		HibernateUtil.shutdown();
		return user;
	}
	
	/*
	@GET
	@Path("/user/logout")
	public Integer logout(String username){
		if (UserDAO.getUserByUsername(username) != null){
			return 1;
		} else {
			return 0;
		}
	}
	*/
}
