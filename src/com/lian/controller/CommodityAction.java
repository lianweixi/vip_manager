package com.lian.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lian.entity.Commodity;
import com.lian.service.CommodityService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommodityAction extends ActionSupport implements ModelDriven<Commodity> {
	
	private CommodityService commodityService;
	private HttpServletRequest request;
	private Commodity commodity = new Commodity();
	@Override
	public Commodity getModel() {
		return commodity;
	}
		
	public String addCommodity() throws Exception {
		request = ServletActionContext.getRequest();
		if (commodity != null) {
			commodityService.saveCommodity(commodity);
			List<Commodity> commodities = commodityService.findAllCommodity();
			request.setAttribute("commodities", commodities);
			return "success";
		} else {
			return "failure";
		}
	}
	
	public String deleteCommodity() throws Exception {
		request = ServletActionContext.getRequest();
		if (commodity != null) {
			commodityService.deleteCommodity(commodity);
			List<Commodity> commodities = commodityService.findAllCommodity();
			request.setAttribute("commodities", commodities);
			return "success";
		} else {
			return "failure";
		}
	}
	
	public String changeCommodity() throws Exception {
		request = ServletActionContext.getRequest();
		if (commodity != null) {
			commodityService.updateCommodity(commodity);
			List<Commodity> commodities = commodityService.findAllCommodity();
			request.setAttribute("commodities", commodities);
			return "success";
		} else {
			return "failure";
		}
	}
	
	public String getAllCommodities() throws Exception {
		request = ServletActionContext.getRequest();
		List<Commodity> commodities = commodityService.findAllCommodity();
		request.setAttribute("commodities", commodities);
		return "success";
	}
	
	public String getCommodityByName() throws Exception {
		request = ServletActionContext.getRequest();
		Commodity commodityFromDb = commodityService.findCommodityByName(commodity.getCommodityName());
		List<Commodity> commodities = new ArrayList<>();
		commodities.add(commodityFromDb);
		request.setAttribute("commodities", commodities);
		return "success";
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
	
	

}
