package com.lian.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lian.entity.User;

public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findOne(String username) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			User userFromDb = (User) session.get(User.class, username);
			return userFromDb;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public User findByUserNameAndPassword(String username, String password) {
		Session session = null;
		String hql = "from User u where u.username = :username and u.password = :password";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setString("username", username);
			query.setString("password", password);
			List<User> users = (List<User>) query.list();
			if (users != null && users.size() != 0) {
				return users.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public List<User> findAll() {
		Session session = null;
		String hql = "from User";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			List<User> users = (List<User>) query.list();
			if (users != null && users.size() != 0) {
				return users;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void save(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(user);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void delete(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			User userFromDb = (User) session.get(User.class, user.getUsername());
			session.delete(userFromDb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void update(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			User userFromDb = (User) session.get(User.class, user.getUsername());
			userFromDb.setPassword(user.getPassword());
			userFromDb.setQuanxian(user.getQuanxian());
			session.update(userFromDb);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
