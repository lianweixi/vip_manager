package com.lian.dao;

import java.util.List;

import com.lian.entity.User;
import com.lian.entity.Vip;

public interface VipDao {
	public Vip findOne(Integer id);
	public List<Vip> findAll();
	public Vip findByName(String name);
	public void save(Vip vip);
	public void delete(Vip vip);
	public void update(Vip vip);
}
