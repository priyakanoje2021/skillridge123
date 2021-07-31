package com.cs.hibernate.hibernateEX1;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CourseTest {
	
	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		Course c1=new Course();
		c1.setCourseId(112);
		c1.setName("Java");
		c1.setFee(9898.89);
		
		Course c2=new Course();
		c2.setCourseId(113);
		c2.setName("Java");
		c2.setFee(9898.89);
		session.save(c1);// insert query
		session.getTransaction().commit();
		
		session.beginTransaction();
		session.save(c2);
		session.getTransaction().commit();
		
		Course c105=session.find(Course.class, 105);
		System.out.println(c105.getName()+ " "+ c105.getCourseId()+  "  "+c105.getFee());
		
		
	/*	session.beginTransaction();
		Course c106=session.find(Course.class, 106);
		
		session.delete(c106); //delete 
		session.getTransaction().commit();
	*/	
		session.beginTransaction();
		Course c1051=session.find(Course.class, 105);
		c1051.setName("JavaFullstack");
		session.saveOrUpdate(c1051); 
		session.getTransaction().commit();
		
		Query q=session.createQuery("from Course c");
		List<Course> clist=q.list();
		for(Course c: clist) {
			System.out.println(c.getCourseId()+  " "+ c.getName() +"  "+c.getFee());
		}
		
		session.close();
		
		
		
		
		
	}

}
