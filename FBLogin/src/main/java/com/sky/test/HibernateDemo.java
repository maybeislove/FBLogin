package com.sky.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.sky.entity.User;

public class HibernateDemo {
	@Test
	public void add() {
		//�Ĥ@�B �[��hibernate�֤߰t�m���
		//��src�U����hibernate.cfg.xml
		Configuration cfg =new Configuration();
		cfg.configure(); 
		//�ĤG�B �Ы�sessionfactory 
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//�ĤT�B �Ы�session����
		Session session = sessionFactory.openSession(); 
		//�ĥ|�B �}�ҥ�� 
		Transaction tx =session.beginTransaction();
		//�Ĥ��B crud 
		User user =new User(); 
		user.setUsername("ssskkkyy");
		user.setPassword("1234567898798");
		user.setAddress("iii");
		session.save(user);
		//�Ĥ��B commit
		tx.commit();
		//�ĤC�B ���귽
		session.close();
		sessionFactory.close();
		
	}
}
