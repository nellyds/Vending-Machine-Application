package com.techelevator;

import java.math.BigDecimal;

public class GumItem extends Item {

	public String getNoise () {
		return "Chew Chew, Yum!";
	}
	public GumItem(String name, BigDecimal price,String itemLocation) {
		this.setName(name);
		this.setPrice(price);
		this.setItemlocation(itemLocation);
	}

}
