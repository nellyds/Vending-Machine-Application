package com.techelevator;

import java.math.BigDecimal;

public class CandyItem extends Item {


	
	public String getNoise () {
		return "Munch Munch, Yum!";
	}
	public CandyItem(String name, BigDecimal price,String itemLocation) {
		this.setName(name);
		this.setPrice(price);
		this.setItemlocation(itemLocation);
	}
}
