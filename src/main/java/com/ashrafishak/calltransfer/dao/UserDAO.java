package com.ashrafishak.calltransfer.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ashrafishak.calltransfer.entity.Agent;
import com.ashrafishak.calltransfer.entity.User;
import com.ashrafishak.calltransfer.util.HibernateUtil;

public class UserDAO {
	
	public static boolean validateUser(String username, String apiToken, Session session){
		User user = getUserByUsername(username, session);
		if (user != null){
			if (user.getApiToken().equals(apiToken)){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	public static User getUserByUsername(String username, Session session){
		Query query = session.createQuery("from User where username = :user ");
		query.setString("user", username);
		List list = query.list();
		if (list != null && list.size() > 0){
			return (User) list.get(0);
		} else {
			return null;
		}
	}
	
	public static Integer putUserByUsername(String username, String apiToken, Session session){
		Transaction tx = null;
		Integer result = 0;
		try {
			User userCheck = getUserByUsername(username, session);
			if (userCheck == null){
				tx = session.beginTransaction();
				User user = new User();
				user.setUsername(username);
				user.setApiToken(apiToken);
				result = (Integer)session.save(user);
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
