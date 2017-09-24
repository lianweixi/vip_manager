package com.lian.dao;

import java.util.List;

import com.lian.entity.Commodity;
import com.lian.entity.User;

public interface CommodityDao {
	public Commodity findOne(Integer id);
	public Commodity findByCommodityName(String commodityName);
	public List<Commodity> findAll();
	public void save(Commodity commodity);
	public void delete(Commodity commodity);
	public void update(Commodity commodity);
}
