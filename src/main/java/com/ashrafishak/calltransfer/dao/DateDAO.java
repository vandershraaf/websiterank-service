package com.ashrafishak.calltransfer.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ashrafishak.calltransfer.entity.Agent;
import com.ashrafishak.calltransfer.util.HibernateUtil;

public class DateDAO {
	
	public static com.ashrafishak.calltransfer.entity.Date getDateByDate(Date date, Session session){
		/*
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String dateStr = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(dateStr);
		*/
		Query query = session.createQuery("from Date where date = :date ");
		query.setDate("date", date);
		List list = query.list();
		if (list != null && list.size() > 0){
			return (com.ashrafishak.calltransfer.entity.Date) list.get(0);
		} else {
			return null;
		}
	}
	
	
	public static Integer putDateByDate(Date date, Session session){
		Transaction tx = null;
		Integer result = 0;
		try {
			com.ashrafishak.calltransfer.entity.Date dateCompare = getDateByDate(date, session);
			if (dateCompare == null){
				tx = session.beginTransaction();
				com.ashrafishak.calltransfer.entity.Date dated = new com.ashrafishak.calltransfer.entity.Date();
				dated.setDate(date);
				result = (Integer)session.save(dated);
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
