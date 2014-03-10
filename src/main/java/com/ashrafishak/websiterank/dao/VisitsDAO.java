package com.ashrafishak.websiterank.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ashrafishak.websiterank.entity.DateVisited;
import com.ashrafishak.websiterank.entity.Visit;
import com.ashrafishak.websiterank.entity.Visits;
import com.ashrafishak.websiterank.entity.Website;
import com.ashrafishak.websiterank.util.HibernateUtil;

/* Preferred solution: http://www.mkyong.com/hibernate/hibernate-many-to-many-example-join-table-extra-column-annotation/ */
public class VisitsDAO {
	
	
	public static Visits getWebsiteVisits(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String strQuery = "SELECT w.name, d.date_visited, v.visit_count FROM visit v, date_visited d, website w " + 
					      "WHERE d.id = v.date_visited_id AND w.id = v.website_id";
		Query query = session.createSQLQuery(strQuery);
		Visits visits = new Visits();
		List<Object[]> queryResult = (List<Object[]>) query.list();
		for (Object[] arr: queryResult){
			Website w = new Website();
			w.setName((String)arr[0]);
			DateVisited dv = new DateVisited();
			dv.setDateVisited((Date) arr[1]);
			int visitCount = (Integer) arr[2];
			Visit visit = new Visit();
			visit.setDate(dv);
			visit.setWebsite(w);
			visit.setVisitCount(visitCount);
			visits.addVisit(visit);
		}
		return visits;
	}
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
	
	public static void main (String[] args){
//		for (Website w: getAllWebsite()){
//			System.out.println(w.getName());
//		}
		
		for (Visit v: getWebsiteVisits().getVisitList()){
			System.out.println(v);
		}
	}

}
