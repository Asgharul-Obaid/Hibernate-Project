package com.tute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Spring MVC");
		certificate1.setDuration("1 Month");
//		s1.setCerti(certificate1);
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("ASP.net");
		certificate2.setDuration("6 Months");
//		s2.setCerti(certificate2);

		Student s1 = new Student();
		s1.setId(2347);
		s1.setName("Abc");
		s1.setCity("Lucknow");
		s1.setCerti(certificate1);
		
		Student s2 = new Student();
		s2.setId(2348);
		s2.setName("Xyz");
		s2.setCity("Lucknow");
		s2.setCerti(certificate2);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		// object save
		s.save(s1);
		s.save(s2);
		System.out.println("saved data !!!");

		tx.commit();
		s.close();
		factory.close();
	}
}
