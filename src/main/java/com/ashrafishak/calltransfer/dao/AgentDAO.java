package com.ashrafishak.calltransfer.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ashrafishak.calltransfer.entity.Account;
import com.ashrafishak.calltransfer.entity.Agent;
import com.ashrafishak.calltransfer.entity.Agents;
import com.ashrafishak.calltransfer.util.HibernateUtil;

public class AgentDAO {
	
	public static Agents getAgentsByChar(String ch, Session session){
		Query query = session.createQuery("from Agent where username LIKE :user ");
		query.setString("user", ch+"%");
		List list = query.list();
		if (list != null && list.size() > 0){
			Agents agents = new Agents();
			for (Object o: list){
				agents.getAgents().add((Agent) o);
			}
			return agents;
		} else {
			return null;
		}
	}
	
	public static Agent getAgentByUsername(String username, Session session){
		Query query = session.createQuery("from Agent where username = :user ");
		query.setString("user", username);
		List list = query.list();
		if (list != null && list.size() > 0){
			return (Agent) list.get(0);
		} else {
			return null;
		}
	}
	
	public static Integer putAgentByUsername(String username, Session session){
		Transaction tx = null;
		Integer result = 0;
		try {
			Agent agentCheck = getAgentByUsername(username, session);
			if (agentCheck == null){
				tx = session.beginTransaction();
				Agent agent = new Agent();
				agent.setUsername(username);
				result = (Integer)session.save(agent);
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
