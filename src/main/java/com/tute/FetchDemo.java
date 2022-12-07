package com.tute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		//get, load
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		//get student:102
		Student student =(Student)session.load(Student.class,105);
		Student student1 =(Student)session.load(Student.class,105);
		System.out.println(student.getName());
		
		//Address address=(Address)session.get(Address.class,2);
		//System.out.println(address.getStreet()+" : "+address.getCity());
		
		//Address address1=(Address)session.get(Address.class,2);
		//System.out.println(address1.getStreet()+" : "+address1.getCity());
		
		session.close();
		factory.close();
		
	}

}
