package com.techelevator;

import java.math.BigDecimal;

public class BeverageItem extends Item {
	
	@Override
	public void setNoise(String noise) {
		// TODO Auto-generated method stub
		super.setNoise("Glug Glug, Yum!");
	}
	public BeverageItem(String name, BigDecimal price, String itemLocation) {
		this.setName(name);
		this.setPrice(price);
		this.setItemlocation(itemLocation);
	}

}
