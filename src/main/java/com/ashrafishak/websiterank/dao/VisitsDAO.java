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
import com.ashrafishak.websiterank.util.SortBy;

/* Preferred solution: http://www.mkyong.com/hibernate/hibernate-many-to-many-example-join-table-extra-column-annotation/ */
public class VisitsDAO {
	
	
	
	public static Visits getVisitsByWebsite(String website, SortBy sortBy){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String strQuery = "SELECT w.name, d.date_visited, v.visit_count FROM visit v, date_visited d, website w " + 
					      "WHERE d.id = v.date_visited_id AND w.id = v.website_id ";
		strQuery += "AND w.name = '" + website + "' ";
		String sortClause = "";
		if (sortBy == SortBy.DATE_ASC){
			sortClause = "ORDER BY d.date_visited";
		} else if (sortBy == SortBy.DATE_DESC){
			sortClause = "ORDER BY d.date_visited DESC";
		} else if (sortBy == SortBy.VISIT_ASC){
			sortClause = "ORDER BY v.visit_count";
		} else if (sortBy == SortBy.VISIT_DESC){
			sortClause = "ORDER BY v.visit_count DESC";
		}
		strQuery += sortClause;
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
	
	
	public static Visits getVisitsByDate(String date, SortBy sortBy){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String strQuery = "SELECT w.name, d.date_visited, v.visit_count FROM visit v, date_visited d, website w " + 
					      "WHERE d.id = v.date_visited_id AND w.id = v.website_id ";
		strQuery += "AND d.date_visited = '" + date + "' ";
		String sortClause = "";
		if (sortBy == SortBy.WEBSITE_ASC){
			sortClause = "ORDER BY w.name";
		} else if (sortBy == SortBy.WEBSITE_DESC){
			sortClause = "ORDER BY w.name DESC";
		} else if (sortBy == SortBy.VISIT_ASC){
			sortClause = "ORDER BY v.visit_count";
		} else if (sortBy == SortBy.VISIT_DESC){
			sortClause = "ORDER BY v.visit_count DESC";
		}
		strQuery += sortClause;
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
	
	
	public static Visits getAllWebsiteVisits(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String strQuery = "SELECT w.name, d.date_visited, v.visit_count FROM visit v, date_visited d, website w " + 
					      "WHERE d.id = v.date_visited_id AND w.id = v.website_id ORDER BY v.visit_count DESC";
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
	
	
	
	
	public static void main (String[] args){
//		for (Website w: getAllWebsite()){
//			System.out.println(w.getName());
//		}
		
		for (Visit v: getVisitsByDate("2013-01-06", SortBy.VISIT_DESC).getVisitList()){
			System.out.println(v);
		}
	}

}
