package com.sky.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.sky.entity.User;

public class HibernateDemo3 {
	@Test
	public void updateByCache() {
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
		
		
		
		User user  = session.get(User.class, 1);
		user.setUsername("�A�L���a�̺ئ��");
		
		//�Ĥ��B commit
		tx.commit();
		//�ĤC�B ���귽
		session.close();
		sessionFactory.close();
		
	}
}
