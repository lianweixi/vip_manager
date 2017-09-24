package com.lian.service;

import java.util.List;

import com.lian.entity.User;
import com.lian.util.UserQualify;

public interface UserService {
	public User findOne(String username);
	public User findByUserNameAndPassword(String username, String password);
	public List<User> findAll();
	public void save(User user);
	public void delete(User user);
	public void changeUserQualify(User user);
}
