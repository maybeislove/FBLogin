package com.sky.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sky.entity.User;

import utils.HibernateUtils;

public class HibernateCache {
	/**
	 * 測試hibernate的一級緩存
	 *
	 */
	@Test
	public void testCache() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// 首先，查詢一級緩存，才會去query
		// * return user1物件 (持久態物件)
		// *
		User user = session.get(User.class, 1);
		System.out.println(user);
		// 對相同物件做查訊
		User user2 = session.get(User.class, 1);
		System.out.println(user2);
		// 輸出只有一次sql select

		tx.commit();
		// 再提交之後會去找hibernate 的快照
		// 並查看快照裡面的物件有沒修改
		// 如果有修改過則蓋掉
		session.close();
		sessionFactory.close();

	}
}
