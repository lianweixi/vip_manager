package com.lian.dao;

import java.util.List;

import com.lian.entity.User;

public interface UserDao {
	public User findOne(String username);
	public User findByUserNameAndPassword(String username, String password);
	public List<User> findAll();
	public void save(User user);
	public void delete(User user);
	public void update(User user);
}
