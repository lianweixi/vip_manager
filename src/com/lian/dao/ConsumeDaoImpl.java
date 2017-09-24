package com.lian.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lian.entity.Commodity;
import com.lian.entity.Consume;
import com.lian.entity.Vip;

public class ConsumeDaoImpl implements ConsumeDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Consume findOne(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Consume consumeFromDb = (Consume) session.get(Consume.class, id);
			return consumeFromDb;
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
	public List<Consume> findAll() {
		Session session = null;
		String hql = "from Consume";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			List<Consume> consumes = (List<Consume>) query.list();
			if (consumes != null && consumes.size() != 0) {
				return consumes;
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
	public List<Consume> findByVip(Vip vip) {
		Session session = null;
		String hql = "from Consume c where c.vip.vipId = :vipId";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setInteger("vipId", vip.getVipId());
			List<Consume> consumes = (List<Consume>) query.list();
			if (consumes != null && consumes.size() != 0) {
				return consumes;
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
	public List<Consume> findByCommodity(Commodity commodity) {
		Session session = null;
		String hql = "from Consume c where c.commodity.commodityId = :commodityId";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setInteger("commodityId", commodity.getCommodityId());
			List<Consume> consumes = (List<Consume>) query.list();
			if (consumes != null && consumes.size() != 0) {
				return consumes;
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
	public void save(Consume consume) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Vip vipFromDb = (Vip) session.get(Vip.class, consume.getVip().getVipId());
			Commodity commodityFromDb = (Commodity) session.get(Commodity.class, consume.getCommodity().getCommodityId());
			Consume c = new Consume();
			c.setVip(vipFromDb);
			c.setCommodity(commodityFromDb);
			session.save(c);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void delete(Consume consume) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Consume consumeFromDb = (Consume) session.get(Consume.class, consume.getConsumeId());
			session.delete(consumeFromDb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
