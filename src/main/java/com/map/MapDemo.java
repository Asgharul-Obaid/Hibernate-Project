package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javassist.expr.NewArray;

public class MapDemo {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	//creating question
	Question q1=new Question();
	q1.setQuestionId(213);
	q1.setQuestion("What is Java ?");
	
	
	//creating answer
	Answer a1=new Answer();
	a1.setAnswerId(1343);
	a1.setAnswer("Java is a programming language");
     a1.setQuestion(q1);
    // q1.setAnswer(a1);
     
     Answer a2=new Answer();
 	a2.setAnswerId(333);
 	a2.setAnswer("with the help of java we create the software");
      a2.setQuestion(q1);
      
      Answer a3=new Answer();
  	a3.setAnswerId(3639);
  	a3.setAnswer("Java has different type of framework");
       a3.setQuestion(q1);
     
       List<Answer> list=new ArrayList<Answer>();
       list.add(a1);
       list.add(a2);
       list.add(a3);
       q1.setAnswers(list);
       
 /*  //creating question
 	Question q2=new Question();
 	q2.setQuestionId(242);
 	q2.setQuestion("What is Collection Framework?");
 	
 	//creating answer
 	Answer a2=new Answer();
 	a2.setAnswerId(344);
 	a2.setAnswer("API to work with objects in java");
 	a2.setQuestion(q2);
      q2.setAnswer(a2);
    */
     //session
     Session s=factory.openSession();
     Transaction tx=s.beginTransaction();
     //save
     s.save(q1);
     s.save(a1);
     s.save(a2);
     s.save(a3);
     
    /* s.save(q1);
     s.save(q2);
     s.save(a1);
     s.save(a2);*/
     Question q=(Question) s.get(Question.class,1212);
     System.out.println(q.getQuestionId());
     System.out.println(q.getQuestion());
     System.out.println(q.getAnswers().size());
     
     
     tx.commit();
    
     //fetching.......
   //  Question newQ=(Question) s.get(Question.class,1212);
    // System.out.println(newQ.getQuestion());
   //  System.out.println(newQ.getAnswer().getAnswer());
    
     s.close();

	factory.close();
	
}
}
