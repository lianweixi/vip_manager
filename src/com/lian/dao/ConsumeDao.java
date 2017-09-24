package com.lian.dao;

import java.util.List;

import com.lian.entity.Commodity;
import com.lian.entity.Consume;
import com.lian.entity.User;
import com.lian.entity.Vip;

public interface ConsumeDao {
	public Consume findOne(Integer id);
	public List<Consume> findAll();
	public List<Consume> findByVip(Vip vip);
	public List<Consume> findByCommodity(Commodity commodity);
	public void save(Consume consume);
	public void delete(Consume consume);
}
