package com.lian.service;

import java.util.List;

import com.lian.entity.Commodity;

public interface CommodityService {
	public List<Commodity> findAllCommodity();
	public Commodity findCommodityByName(String commodityName);
	public void saveCommodity(Commodity commodity);
	public void deleteCommodity(Commodity commodity);
	public void updateCommodity(Commodity commodity);
}
