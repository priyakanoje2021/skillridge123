package com.cs.hibernate.hibernateEX1;

import org.hibernate.HibernateException;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateTest {

	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();
		Employee employee1 = new Employee();
		employee1.setEmployeeId(1);
		employee1.setEmployeeName("Sriram");
		Employee employee2 = new Employee();
		employee2.setEmployeeId(2);
		employee2.setEmployeeName("Ram");
		Employee employee3 = new Employee();
		employee3.setEmployeeId(3);
		employee3.setEmployeeName("Jai Ram");
		
		try{
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.getTransaction().commit();
			System.out.println("Data inserted successfully");
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
		
	}

}

