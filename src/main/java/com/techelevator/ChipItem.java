package com.techelevator;

import java.math.BigDecimal;

public class ChipItem extends Item {
	@Override
	public void setNoise(String noise) {
		// TODO Auto-generated method stub
		super.setNoise("Crunch Crunch, Yum!");
	}
	public ChipItem(String name, BigDecimal price,String itemLocation) {
		this.setName(name);
		this.setPrice(price);
		this.setItemlocation(itemLocation);
	}
}
