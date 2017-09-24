package com.lian.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lian.entity.Commodity;
import com.lian.entity.Vip;

public class CommodityDaoImpl implements CommodityDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Commodity findOne(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Commodity commodityFromDb = (Commodity) session.get(Commodity.class, id);
			return commodityFromDb;
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
	public List<Commodity> findAll() {
		Session session = null;
		String hql = "from Commodity";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			List<Commodity> commodities = (List<Commodity>) query.list();
			if (commodities != null && commodities.size() != 0) {
				return commodities;
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
	public void save(Commodity commodity) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(commodity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void delete(Commodity commodity) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Commodity commodityFromDb = (Commodity) session.get(Commodity.class, commodity.getCommodityId());
			session.delete(commodityFromDb);
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
	public void update(Commodity commodity) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Commodity commodityFromDb = (Commodity) session.get(Commodity.class, commodity.getCommodityId());
			commodityFromDb.setCommodityName(commodity.getCommodityName());
			commodityFromDb.setPrice(commodity.getPrice());
			commodityFromDb.setAgio(commodity.getAgio());
			session.update(commodityFromDb);
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
	public Commodity findByCommodityName(String commodityName) {
		Session session = null;
		String hql = "from Commodity c where c.commodityName = :commodityName";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setString("commodityName", commodityName);
			List<Commodity> commodities = (List<Commodity>) query.list();
			if (commodities != null && commodities.size() != 0) {
				return commodities.get(0);
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
