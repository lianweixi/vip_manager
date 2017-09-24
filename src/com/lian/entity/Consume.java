package com.lian.entity;

public class Consume {
	private int consumeId;
	private Vip vip;
	private Commodity commodity;
	
	public Consume() {
		
	}

	

	public int getConsumeId() {
		return consumeId;
	}



	public void setConsumeId(int consumeId) {
		this.consumeId = consumeId;
	}



	public Vip getVip() {
		return vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	
}
