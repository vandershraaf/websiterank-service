package com.ashrafishak.calltransfer.service;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import com.ashrafishak.calltransfer.dao.AccountDAO;
import com.ashrafishak.calltransfer.dao.AgentDAO;
import com.ashrafishak.calltransfer.dao.DateDAO;
import com.ashrafishak.calltransfer.dao.TransferDAO;
import com.ashrafishak.calltransfer.dao.UserDAO;
import com.ashrafishak.calltransfer.entity.Account;
import com.ashrafishak.calltransfer.entity.Agent;
import com.ashrafishak.calltransfer.entity.Agents;
import com.ashrafishak.calltransfer.entity.Transfer;
import com.ashrafishak.calltransfer.entity.Transfers;
import com.ashrafishak.calltransfer.entity.User;
import com.ashrafishak.calltransfer.util.HibernateUtil;

public class TestService {
	
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Account acct = AccountDAO.getAccountByNum("535039855772233", session);
		Agent agent = AgentDAO.getAgentByUsername("pavolio", session);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 6, 7);
		System.out.println(cal);
		com.ashrafishak.calltransfer.entity.Date date = DateDAO.getDateByDate(cal.getTime(), session);
		
		User user = UserDAO.getUserByUsername("mishak", session);		
		System.out.println(acct.getAcctNum());
		System.out.println(agent.getUsername());
		System.out.println(date.getDate());
		System.out.println(user.getApiToken());
		
		Transfer transfer = TransferDAO.getSingleTransfer(acct.getAcctNum(), agent.getUsername(), date.getDate(), user.getUsername(), session);
		System.out.println(transfer.getUser().getApiToken());
		
		// PUT
		//AccountDAO.putAccountByNum("129039855772233");
		//AgentDAO.putAgentByUsername("karen");
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2014, 6, 30);
		/*
		DateDAO.putDateByDate(cal2.getTime());
		*/
		//UserDAO.putUserByUsername("ashrafishak", "t2473u86gjpy0qg0fc08");
		//TransferDAO.putSingleTransfer("129039855772233", "karen", cal2.getTime(), "ashrafishak");
		/*
		Transfer t = TransferDAO.getSingleTransfer("129039855772233", "karen", cal2.getTime(), "ashrafishak");
		System.out.println(t.getUser().getApiToken());
		System.out.println(t.getUser().getUsername());
		*/
		
		Agents agents = AgentDAO.getAgentsByChar("p", session);
		for (Agent a: agents.getAgents()){
			System.out.println(a.getUsername());
		}
		
		
		Calendar cal3 = Calendar.getInstance();
		cal3.set(2014, 6, 16);
		Transfers transfers = TransferDAO.getTransfersByDate(cal3.getTime(), session);
		for (Transfer t: transfers.getTransfers()){
			System.out.println(t);
		}


	}

}
