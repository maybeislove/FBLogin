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
		//第一步 加載hibernate核心配置文件
		//到src下面找hibernate.cfg.xml
		Configuration cfg =new Configuration();
		cfg.configure(); 
		//第二步 創建sessionfactory 
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//第三步 創建session物件
		Session session = sessionFactory.openSession(); 
		//第四步 開啟交易 
		Transaction tx =session.beginTransaction();
		//第五步 crud 
		User user =new User(); 
		user.setUsername("ssskkkyy");
		user.setPassword("1234567898798");
		user.setAddress("iii");
		session.save(user);
		//第六步 commit
		tx.commit();
		//第七步 關資源
		session.close();
		sessionFactory.close();
		
	}
}
