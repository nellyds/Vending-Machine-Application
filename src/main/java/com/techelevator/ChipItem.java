package com.techelevator;

import java.math.BigDecimal;

public class ChipItem extends Item {

	public String getNoise () {
		return "Crunch Crunch, Yum!";
	}
	
	public ChipItem(String name, BigDecimal price,String itemLocation) {
		this.setName(name);
		this.setPrice(price);
		this.setItemlocation(itemLocation);
	}
}
