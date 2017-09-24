package com.lian.service;

import java.util.List;

import com.lian.dao.CommodityDao;
import com.lian.entity.Commodity;

public class CommodityServiceImpl implements CommodityService {
	
	private CommodityDao commodityDao;
	
	public CommodityDao getCommodityDao() {
		return commodityDao;
	}

	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	@Override
	public List<Commodity> findAllCommodity() {
		// TODO Auto-generated method stub
		return commodityDao.findAll();
	}

	@Override
	public void saveCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityDao.save(commodity);
	}

	@Override
	public void deleteCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityDao.delete(commodity);
	}

	@Override
	public void updateCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityDao.update(commodity);
	}

	@Override
	public Commodity findCommodityByName(String commodityName) {		
		return commodityDao.findByCommodityName(commodityName);
	}

}
