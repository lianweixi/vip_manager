package com.lian.entity;

public class Commodity {
	private int commodityId;
	private String commodityName;
	private float price;
	private float agio;
	
	public Commodity() {
		
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getAgio() {
		return agio;
	}

	public void setAgio(float agio) {
		this.agio = agio;
	}
	
}
