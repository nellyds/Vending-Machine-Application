package com.techelevator;

import java.math.BigDecimal;

public class GumItem extends Item {
	@Override
	public void setNoise(String noise) {
		// TODO Auto-generated method stub
		super.setNoise("Chew Chew, Yum!");
	}
	public GumItem(String name, BigDecimal price) {
		this.setName(name);
		this.setPrice(price);
	}

}
