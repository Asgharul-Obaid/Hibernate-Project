package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tute.Certificate;
import com.tute.Student;

public class StateDemo {
	public static void main(String[] args) {
		//practical of Hibernate Object States;
		//Transienr
		//Persistent
		//Detached
		//Removed
		System.out.println("Example:");
		
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Student student=new Student();
		student.setId(101);
		student.setName("Obaid");
		student.setCity("Mumbai");
		student.setCerti(new Certificate("Java hibernate course","2 months"));
		//student.setCerti(new Certificate("Java Hibernate Courese","2 Months"));
		//student transient
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student);
		student.setName("Aamir");

		tx.commit();
		s.close();
		//student : Detached State
		student.setName("ABC");
		System.out.println(student);
		f.close();
	}

}
