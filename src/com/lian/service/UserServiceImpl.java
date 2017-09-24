package com.lian.service;

import java.util.List;

import com.lian.dao.UserDao;
import com.lian.entity.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		return userDao.findOne(username);
	}

	@Override
	public User findByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.findByUserNameAndPassword(username, password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	@Override
	public void changeUserQualify(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

}
