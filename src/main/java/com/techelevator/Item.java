package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {
String name;
BigDecimal price;
abstract String getNoise();
String itemlocation;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice( BigDecimal price) {
	this.price=price;
}



public String getItemlocation() {
	return itemlocation;
}
public void setItemlocation(String itemlocation) {
	this.itemlocation = itemlocation;
}


}
