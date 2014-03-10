package com.ashrafishak.websiterank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ashrafishak.websiterank.entity.DateVisited;
import com.ashrafishak.websiterank.util.HibernateUtil;

public class DateVisitedDAO {
	
	public static List<DateVisited> getAllDateVisited(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from DateVisited");
		List list = query.list();
		ArrayList<DateVisited> result = new ArrayList<DateVisited>();
		for (Object o: list){
			result.add((DateVisited) o);
		}
		return result;
	}
	
	public static void main (String[] args){
		for (DateVisited d: getAllDateVisited()){
			System.out.println(d.getDateVisited().toString());
		}
	}

}
