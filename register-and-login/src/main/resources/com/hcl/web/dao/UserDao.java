package com.hcl.web.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hcl.hibernate.util.HibernateUtil;
import com.hcl.web.model.User;

public class UserDao {
	public void saveUser(User user) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.save(user);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public boolean validate(String username, String password) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			user = (User) session.createQuery("FROM User U WHERE U.username = :username")
					.setParameter("username", username).uniqueResult();

			if (user != null && user.getPassword().equals(password)) {
				return true;
			}

			// transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}

		return false;
	}
}
