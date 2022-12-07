package com.sqlquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	Session s=factory.openSession();
	
	//SQL query
	String q="select * from Student";
	NativeQuery nq=s.createSQLQuery(q);
	List<Object[]> list=nq.list();
	
	for(Object[] student : list) {
		System.out.println(student[4]+" : "+student[3]);
	}
}
}
