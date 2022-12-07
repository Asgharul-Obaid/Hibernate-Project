package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.tute.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session s=factory.openSession();
		//HQL
		//Syntax:
		String query="from Student as s where s.city=:x and s.name=:n";
		Query q=s.createQuery(query);
		q.setParameter("x","Lucknow");
		q.setParameter("n","Sanaya" );
		
		//single (Unique)
		//multiple (List
		List<Student>list=q.list();
		for(Student student : list) {
			System.out.println(student.getName()+" : "+student.getCerti().getCourse());
		}	
		System.out.println(".......................................................");
		//deleted query
		Transaction tx=s.beginTransaction();
//		 Query q2=s.createQuery("delete from Student s where s.city=:c");
//		 q2.setParameter("c", "Tunga Village");
//		 int r= q2.executeUpdate();
//		 System.out.println("deleted");
//		 System.out.println(r);
		
		//update query
		   Query q2=s.createQuery("update Student set city=:c where name=:n");
		   q2.setParameter("c", "Mumbai");
		   q2.setParameter("n", "Sanaya");
		   int r=q2.executeUpdate();
		   System.out.println(r + "objects update");
			tx.commit();
			
			//how to execute join query
			Query q3=s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answer as a");
			List<Object[]>list3=q3.getResultList();
			
			for(Object[] arr:list3) {
			System.out.println(Arrays.toString(arr));
			}
		s.close();
		factory.close();
	}

}
