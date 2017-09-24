package com.lian.service;

import java.util.List;

import com.lian.entity.Commodity;
import com.lian.entity.Consume;
import com.lian.entity.Vip;

public interface VipService {
	public Vip findOne(Integer id);
	public List<Vip> findAll();
	public Vip findByName(String name);
	public void vipConsume(Vip vip, Commodity commodity);
	public List<Consume> vipConsumeHistory(Vip vip);
	public void save(Vip vip);
	public void delete(Vip vip);
}
