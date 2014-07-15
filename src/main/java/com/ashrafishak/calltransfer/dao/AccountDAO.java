package com.ashrafishak.calltransfer.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ashrafishak.calltransfer.entity.Account;
import com.ashrafishak.calltransfer.util.HibernateUtil;

public class AccountDAO {
	
	public static Account getAccountByNum(String acctNum, Session session){
		System.out.println("in DAO = "+acctNum);
		Query query = session.createQuery("from Account where acctNum = :acct ");
		query.setString("acct", acctNum);
		List list = query.list();
		if (list != null && list.size() > 0){
			return (Account) list.get(0);
		} else {
			return null;
		}
	}
	
	public static Integer putAccountByNum(String acctNum, Session session){
		Transaction tx = null;
		Integer result = 0;
		try {
			Account acctCheck = getAccountByNum(acctNum, session);
			if (acctCheck == null){
				tx = session.beginTransaction();
				Account acct = new Account();
				acct.setAcctNum(acctNum);
				result = (Integer)session.save(acct);
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
