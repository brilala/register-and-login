package com.hcl.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hcl.web.model.User;

public class HibernateUtil {
	static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() {

		Configuration conf = new Configuration();
		conf.addAnnotatedClass(User.class);
		conf.configure("hibernate.cfg.xml");
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

		sessionFactory = conf.buildSessionFactory(registry);
		return sessionFactory;
	}

	}
