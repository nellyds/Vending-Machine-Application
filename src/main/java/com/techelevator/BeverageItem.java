package com.techelevator;

import java.math.BigDecimal;

public class BeverageItem extends Item {
	
	public String getNoise () {
		return "Glug Glug, Yum!";
	}
	
	public BeverageItem(String name, BigDecimal price, String itemLocation) {
		this.setName(name);
		this.setPrice(price);
		this.setItemlocation(itemLocation);
	}

}
