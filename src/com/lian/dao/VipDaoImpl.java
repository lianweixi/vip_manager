package com.lian.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lian.entity.User;
import com.lian.entity.Vip;

public class VipDaoImpl implements VipDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Vip findOne(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Vip vipFromDb = (Vip) session.get(Vip.class, id);
			return vipFromDb;
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
	public List<Vip> findAll() {
		Session session = null;
		String hql = "from Vip";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			List<Vip> vips = (List<Vip>) query.list();
			if (vips != null && vips.size() != 0) {
				return vips;
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
	public void save(Vip vip) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(vip);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void delete(Vip vip) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Vip vipFromDb = (Vip) session.get(Vip.class, vip.getVipId());
			session.delete(vipFromDb);
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
	public void update(Vip vip) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Vip vipFromDb = (Vip) session.get(Vip.class, vip.getVipId());
			vipFromDb.setName(vip.getName());
			vipFromDb.setAge(vip.getAge());
			vipFromDb.setJoinTime(vip.getJoinTime());
			vipFromDb.setProfession(vip.getProfession());
			session.update(vipFromDb);
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
	public Vip findByName(String name) {
		Session session = null;
		String hql = "from Vip v where v.name = :name";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setString("name", name);
			List<Vip> vips = (List<Vip>) query.list();
			if (vips != null && vips.size() != 0) {
				return vips.get(0);
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

}
