package com.sky.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sky.entity.User;

import utils.HibernateUtils;

public class HibernateCache {
	/**
	 * ����hibernate���@�Žw�s
	 *
	 */
	@Test
	public void testCache() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// �����A�d�ߤ@�Žw�s�A�~�|�hquery
		// * return user1���� (���[�A����)
		// *
		User user = session.get(User.class, 1);
		System.out.println(user);
		// ��ۦP���󰵬d�T
		User user2 = session.get(User.class, 1);
		System.out.println(user2);
		// ��X�u���@��sql select

		tx.commit();
		// �A���椧��|�h��hibernate ���ַ�
		// �ìd�ݧַӸ̭������󦳨S�ק�
		// �p�G���ק�L�h�\��
		session.close();
		sessionFactory.close();

	}
}
