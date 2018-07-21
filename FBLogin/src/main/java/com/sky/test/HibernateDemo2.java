package com.sky.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sky.entity.User;

import utils.HibernateUtils;

public class HibernateDemo2 {
	@Test 
	public void update () {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1) ;
		user.setPassword("gggg");
		session.update(user); 
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
	@Test
	public void get () {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1) ;
		System.out.println(user);
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	@Test 
	public void delete () {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1) ;
		session.delete(user); 
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
}
