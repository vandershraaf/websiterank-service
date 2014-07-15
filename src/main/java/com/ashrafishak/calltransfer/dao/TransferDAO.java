package com.ashrafishak.calltransfer.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ashrafishak.calltransfer.entity.Account;
import com.ashrafishak.calltransfer.entity.Agent;
import com.ashrafishak.calltransfer.entity.Transfer;
import com.ashrafishak.calltransfer.entity.Transfers;
import com.ashrafishak.calltransfer.entity.User;
import com.ashrafishak.calltransfer.util.HibernateUtil;

public class TransferDAO {
	
	public static Transfers getTransfersByDate(Date date, Session session){
		com.ashrafishak.calltransfer.entity.Date dateObj = DateDAO.getDateByDate(date, session);
		Query query = session.createSQLQuery("SELECT id, account_id, agent_id, date_id, user_id FROM transfer WHERE date_id = :date");
		query.setInteger("date", dateObj.getId());
		List list = query.list();
		Transfers transfers = new Transfers();
		for (Object o: list){
			Object[] arr = (Object[]) o;
			Integer id = (Integer) arr[0];
			
			Integer accountId = (Integer) arr[1];
			query = session.createQuery("FROM Account WHERE id = :id");
			query.setInteger("id", accountId);
			List listacc = query.list();
			Account acc = null;
			if (listacc != null && listacc.size() > 0){
				acc = (Account) listacc.get(0);
			}
			
			Integer agentId = (Integer) arr[2];
			query = session.createQuery("FROM Agent WHERE id = :id");
			query.setInteger("id", agentId);
			List listag = query.list();
			Agent ag = null;
			if (listag != null && listag.size() > 0){
				ag = (Agent) listag.get(0);
			}
			
			Integer userId = (Integer) arr[4];
			query = session.createQuery("FROM User WHERE id = :id");
			query.setInteger("id", userId);
			List listus = query.list();
			User us = null;
			if (listus != null && listus.size() > 0){
				us = (User) listus.get(0);
			}
			
			Transfer trans = new Transfer();
			trans.setAccount(acc);
			trans.setAgent(ag);
			trans.setDate(dateObj);
			trans.setId(id);
			trans.setUser(us);
			transfers.getTransfers().add(trans);
		}
		if (transfers.getTransfers().size() > 0){
			return transfers;
		} else {
			return null;
		}
	}
	
	public static Transfer getSingleTransfer(String acctNum, String agentUsername, java.util.Date date, String username, Session session){
		Account acct = AccountDAO.getAccountByNum(acctNum, session);
		Agent agent = AgentDAO.getAgentByUsername(agentUsername, session);
		com.ashrafishak.calltransfer.entity.Date dateObj = DateDAO.getDateByDate(date, session);
		User user = UserDAO.getUserByUsername(username, session);
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Query query = sess.createSQLQuery("SELECT 1 FROM transfer WHERE account_id = :acctid AND "+
										  "agent_id = :agentid AND date_id = :dateid AND user_id = :userid LIMIT 1");
		query.setInteger("acctid", acct.getId());
		query.setInteger("agentid", agent.getId());
		query.setInteger("dateid", dateObj.getId());
		query.setInteger("userid", user.getId());
		List result = query.list();
		if (result != null && result.size() > 0){
			BigInteger b = (BigInteger)result.get(0);
			BigInteger compare = new BigInteger("1");
			if (b.equals(compare)){
				Transfer transfer = new Transfer();
				transfer.setAccount(acct);
				transfer.setAgent(agent);
				transfer.setDate(dateObj);
				transfer.setUser(user);
				return transfer;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	// NOTE: If params are not in DB, it will be handled on service level
	public static Integer putSingleTransfer(String acctNum, String agentUsername, java.util.Date date, String username, Session session){
		Transaction tx = null;
		Integer result = 0;
		try {
			Transfer transferCheck = getSingleTransfer(acctNum, agentUsername, date, username, session);
			if (transferCheck == null){
				System.out.println("account number = "+acctNum);
				tx = session.beginTransaction();
				Account acct = AccountDAO.getAccountByNum(acctNum, session);
				Agent agent = AgentDAO.getAgentByUsername(agentUsername, session);
				com.ashrafishak.calltransfer.entity.Date dateObj = DateDAO.getDateByDate(date, session);
				User user = UserDAO.getUserByUsername(username, session);
				Query query = session.createSQLQuery("INSERT INTO transfer (account_id, agent_id, date_id, user_id) VALUES (:acc, :agent, :date, :user) ");
				query.setInteger("acc", acct.getId());
				query.setInteger("agent", agent.getId());
				query.setInteger("date", dateObj.getId());
				query.setInteger("user", user.getId());
				result = query.executeUpdate();
				tx.commit();
			}
		} catch (HibernateException e){
			if (tx != null){
				tx.rollback();
			} 
			e.printStackTrace();
		} /*finally {
			session.close();
		}
		*/
		return result;
	}

}
