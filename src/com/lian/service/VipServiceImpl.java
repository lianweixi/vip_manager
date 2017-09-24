package com.lian.service;

import java.util.List;

import com.lian.dao.CommodityDao;
import com.lian.dao.ConsumeDao;
import com.lian.dao.VipDao;
import com.lian.entity.Commodity;
import com.lian.entity.Consume;
import com.lian.entity.Vip;

public class VipServiceImpl implements VipService {
	
	private VipDao vipDao;
	private CommodityDao commodityDao;
	private ConsumeDao consumeDao;

	public VipDao getVipDao() {
		return vipDao;
	}

	public void setVipDao(VipDao vipDao) {
		this.vipDao = vipDao;
	}

	public CommodityDao getCommodityDao() {
		return commodityDao;
	}

	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	public ConsumeDao getConsumeDao() {
		return consumeDao;
	}

	public void setConsumeDao(ConsumeDao consumeDao) {
		this.consumeDao = consumeDao;
	}

	@Override
	public Vip findOne(Integer id) {
		// TODO Auto-generated method stub
		return vipDao.findOne(id);
	}

	@Override
	public List<Vip> findAll() {
		// TODO Auto-generated method stub
		return vipDao.findAll();
	}

	@Override
	public void vipConsume(Vip vip, Commodity commodity) {
		// TODO Auto-generated method stub
//		Vip vipFromDb = vipDao.findOne(vip.getVipId());
//		Commodity commodityFromDb = commodityDao.findOne(commodity.getCommodityId());
		Consume consume = new Consume();
		consume.setVip(vip);
		consume.setCommodity(commodity);
		consumeDao.save(consume);
	}

	@Override
	public List<Consume> vipConsumeHistory(Vip vip) {
		// TODO Auto-generated method stub
//		Vip vipFromDb = vipDao.findOne(vip.getVipId());		
		return consumeDao.findByVip(vip);
	}

	@Override
	public void save(Vip vip) {
		// TODO Auto-generated method stub
		vipDao.save(vip);
	}

	@Override
	public void delete(Vip vip) {
		// TODO Auto-generated method stub
		vipDao.delete(vip);
	}

	@Override
	public Vip findByName(String name) {
		
		return vipDao.findByName(name);
	}

}
