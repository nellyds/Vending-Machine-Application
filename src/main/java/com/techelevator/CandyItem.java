package com.techelevator;

import java.math.BigDecimal;

public class CandyItem extends Item {

	@Override
	public void setNoise(String noise) {
		// TODO Auto-generated method stub
		super.setNoise("Munch Munch, Yum!");
	}
	public CandyItem(String name, BigDecimal price,String itemLocation) {
		this.setName(name);
		this.setPrice(price);
		this.setItemlocation(itemLocation);
	}
}
