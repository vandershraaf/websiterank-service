package com.ashrafishak.websiterank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ashrafishak.websiterank.entity.Website;
import com.ashrafishak.websiterank.util.HibernateUtil;

public class WebsiteDAO {
	
	public static List<Website> getAllWebsite(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Website");
		List list = query.list();
		ArrayList<Website> result = new ArrayList<Website>();
		for (Object o: list){
			result.add((Website) o);
		}
		return result;
	}

}
