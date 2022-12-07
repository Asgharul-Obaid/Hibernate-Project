package com.tute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started....." );
       // SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //creating student
        Student st=new Student();
        st.setId(105);
        st.setName("Obaid");
        st.setCity("Basti");
        System.out.println(st);
        
        
        //creating object of address class
        Address ad=new Address();
        ad.setStreet("Street 1");
        ad.setCity("Mumbai");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.45); 
        //Reading Image
        FileInputStream fis=new FileInputStream("src/main/java/3obaid1.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
       Session session= factory.openSession();
       
       Transaction tx= session.beginTransaction();
       
       session.save(st);
       session.save(ad);
       tx.commit(); 
       session.close();
       System.out.println("Done...");
        
        
    }
}
