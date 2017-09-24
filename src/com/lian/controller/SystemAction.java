package com.lian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lian.entity.User;
import com.lian.service.UserService;
import com.lian.util.UserQualify;
import com.opensymphony.xwork2.ActionSupport;

public class SystemAction extends ActionSupport {

	private UserService userService;
	private HttpServletRequest request;
	private String username;
	private String password;
	private int quanxian;

	public String login() throws Exception {
		request = ServletActionContext.getRequest();
		if (!username.equals("") && !password.equals("")) {
			User userFromDb = userService.findByUserNameAndPassword(username, password);
			if (userFromDb != null) {
				if (userFromDb.getQuanxian() == UserQualify.OUT_USE.value()) {
					return "failure";
				} else {
					request.getSession().setAttribute("user", userFromDb);
					return "success";
				}
			} else {
				return "failure";
			}		
		} else {
			return "failure";
		}		
	}

	public String logout() throws Exception {
		request = ServletActionContext.getRequest();
		request.getSession().invalidate();
		return "success";
	}

	public String getUsers() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value()) {
			List<User> users = userService.findAll();
			request.setAttribute("users", users);
			return "success";
		} else {
			return "failure";
		}
	}
	
	public String addUser() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value()) {
			User addUser = new User();
			addUser.setUsername(username);
			addUser.setPassword(password);
			addUser.setQuanxian(quanxian);
			userService.save(addUser);
			List<User> users = userService.findAll();
			request.setAttribute("users", users);
			return "success";
		} else {
			return "failure";
		}
	}

	public String deleteUser() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value()) {
			User deleteUser = new User();
			deleteUser.setUsername(username);
			userService.delete(deleteUser);
			return "success";
		} else {
			return "failure";
		}
	}

	public String changeQualify() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value()) {
			User changeUser = new User();
			changeUser.setUsername(username);
			changeUser.setQuanxian(quanxian);
			userService.changeUserQualify(changeUser);
			List<User> users = userService.findAll();
			request.setAttribute("users", users);
			return "success";
		} else {
			return "failure";
		}
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(int quanxian) {
		this.quanxian = quanxian;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
