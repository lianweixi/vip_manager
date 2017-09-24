package com.lian.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lian.entity.Commodity;
import com.lian.entity.Consume;
import com.lian.entity.User;
import com.lian.entity.Vip;
import com.lian.service.CommodityService;
import com.lian.service.VipService;
import com.lian.util.UserQualify;
import com.opensymphony.xwork2.ActionSupport;

public class VipAction extends ActionSupport {
	
	private VipService vipService;	
	private CommodityService commodityService;
	private HttpServletRequest request;
	private int vipId;
	private Date joinTime;
	private String name;
	private int age;
	private String profession;
	private int commodityId;
	
	public String getAllVip() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value() || userFromSession.getQuanxian() == UserQualify.IN_USE.value()) {
			List<Vip> vips = vipService.findAll();
			request.setAttribute("vips", vips);
			return "success";
		} else {
			return "failure";
		}
	}
	
	public String addVip() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value() || userFromSession.getQuanxian() == UserQualify.IN_USE.value()) {
			Vip vip = new Vip();
//			vip.setVipId(vipId);
			vip.setJoinTime(joinTime);
			vip.setName(name);
			vip.setAge(age);
			vip.setProfession(profession);
			vipService.save(vip);
			List<Vip> vips = vipService.findAll();
			request.setAttribute("vips", vips);
			return "success";
		} else {
			return "failure";
		}
	}
	
	public String deleteVip() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value() || userFromSession.getQuanxian() == UserQualify.IN_USE.value()) {
			Vip vip = new Vip();
			vip.setVipId(vipId);
			vipService.delete(vip);
			List<Vip> vips = vipService.findAll();
			request.setAttribute("vips", vips);
			return "success";
		} else {
			return "failure";
		}
	}
	
//	public String changeVipInfo() throws Exception {
//		request = ServletActionContext.getRequest();
//		User userFromSession = (User) request.getSession().getAttribute("user");
//		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value() || userFromSession.getQuanxian() == UserQualify.IN_USE.value()) {
//			Vip vip = new Vip();
//			vip.setJoinTime(joinTime);
//			List<Vip> vips = vipService.findAll();
//			request.setAttribute("vips", vips);
//			return "success";
//		} else {
//			return "failure";
//		}
//	}
	
	public String getVipConsumeDetail() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value() || userFromSession.getQuanxian() == UserQualify.IN_USE.value()) {
			Vip vipFromDb = vipService.findByName(name);
			List<Consume> consumes = vipService.vipConsumeHistory(vipFromDb);
			request.setAttribute("consumes", consumes);
			return "success";
		} else {
			return "failure";
		}
	}
	
	public String openVipConsume() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value() || userFromSession.getQuanxian() == UserQualify.IN_USE.value()) {
			List<Vip> vips = vipService.findAll();
			List<Commodity> commodities = commodityService.findAllCommodity();
			request.setAttribute("vips", vips);
			request.setAttribute("commodities", commodities);
			return "success";
		} else {
			return "failure";
		}
	}
	
	public String addVipConsume() throws Exception {
		request = ServletActionContext.getRequest();
		User userFromSession = (User) request.getSession().getAttribute("user");
		if (userFromSession.getQuanxian() == UserQualify.ADMIN.value() || userFromSession.getQuanxian() == UserQualify.IN_USE.value()) {
			Vip vip = new Vip();
			vip.setVipId(vipId);
			Commodity commodity = new Commodity();
			commodity.setCommodityId(commodityId);
			vipService.vipConsume(vip, commodity);
			List<Vip> vips = vipService.findAll();
			request.setAttribute("vips", vips);
			List<Commodity> commodities = commodityService.findAllCommodity();
			request.setAttribute("commodities", commodities);
			return "success";
		} else {
			return "failure";
		}
	}

	public VipService getVipService() {
		return vipService;
	}

	public void setVipService(VipService vipService) {
		this.vipService = vipService;
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public int getVipId() {
		return vipId;
	}

	public void setVipId(int vipId) {
		this.vipId = vipId;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	
	
}
