package com.ashrafishak.calltransfer.service;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.ashrafishak.calltransfer.dao.AccountDAO;
import com.ashrafishak.calltransfer.dao.AgentDAO;
import com.ashrafishak.calltransfer.dao.DateDAO;
import com.ashrafishak.calltransfer.dao.TransferDAO;
import com.ashrafishak.calltransfer.dao.UserDAO;
import com.ashrafishak.calltransfer.entity.Account;
import com.ashrafishak.calltransfer.entity.Agent;
import com.ashrafishak.calltransfer.entity.PostRequest;
import com.ashrafishak.calltransfer.entity.PostResponse;
import com.ashrafishak.calltransfer.entity.Transfers;
import com.ashrafishak.calltransfer.entity.User;
import com.ashrafishak.calltransfer.util.HibernateUtil;

@Path("transfers")
@Produces(MediaType.APPLICATION_JSON)
public class TransferService {
	
	
	// date form param in YYYY-MM-DD
	@POST
	@Path("/transfer/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public PostResponse putSingleTransfer (PostRequest request){
		System.out.println(request);
		String acctNum = request.getAccount();
		String user = request.getUser();
		String apiToken = request.getApiToken();
		String agent = request.getAgent();
		String date = request.getDate();
		Session sess = HibernateUtil.getSessionFactory().openSession();
		PostResponse pr = null;
		if (UserDAO.validateUser(user, apiToken, sess)){
			AccountDAO.putAccountByNum(acctNum, sess);
			Account account = AccountDAO.getAccountByNum(acctNum, sess);
			AgentDAO.putAgentByUsername(agent, sess);
			Agent agentObj = AgentDAO.getAgentByUsername(agent, sess);
			Calendar cal = Calendar.getInstance();
			String[] split = date.split("-");
			cal.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]));
			DateDAO.putDateByDate(cal.getTime(), sess);
			com.ashrafishak.calltransfer.entity.Date dateObj = DateDAO.getDateByDate(cal.getTime(), sess);
			User userObj = UserDAO.getUserByUsername(user, sess);
			Integer result = TransferDAO.putSingleTransfer(account.getAcctNum(), agentObj.getUsername(), dateObj.getDate(), userObj.getUsername(), sess);
			pr = new PostResponse();
			if (result == 0){
				pr.setResponseResult("FAILURE");
			} else {
				pr.setResponseResult("SUCCESS");
			}
		} else {
			pr = new PostResponse();
			pr.setResponseResult("FAILURE: API token not valid");
		}
		sess.close();
		HibernateUtil.shutdown();
		return pr;
		
		
	}
	
	@GET
	@Path("/today")
	public Transfers getTodayTransfers(@QueryParam("user") String user, @QueryParam("apiToken") String apiToken){
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transfers transfers = null;
		if (UserDAO.validateUser(user, apiToken, sess)){
			Calendar cal = Calendar.getInstance();
			transfers = TransferDAO.getTransfersByDate(cal.getTime(), sess);
		} 
		sess.close();
		HibernateUtil.shutdown();
		return transfers;
	}
	
	

}
