package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class VendingMachine {
	
	private Map<String, Stack<Item>> vendingInventory = new HashMap<>();

	public VendingMachine(Map inventory) {
		this.setVendingInventory(inventory);
	}
	
	BigDecimal balance = new BigDecimal("0");

	Map<String, Stack<Item>> inventoryMap = new HashMap<>();

	public BigDecimal getBalance() {
		return balance;
	}

	
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void getUserSelection() {

	}

	public void addToBalance(BigDecimal balanceAdded) {
		balance = (balance.add(balanceAdded)) ;
	}

	public String purchaseThis(String itemSelected) {
		if (inventoryMap.containsKey(itemSelected)) {
			
		}else return "Item Not Found";
		if (inventoryMap.get(itemSelected).size()> 0) {
			if ( this.getBalance().compareTo(
			inventoryMap.get(itemSelected).peek().getPrice())  >0) {
			inventoryMap.get(itemSelected).pop();
			} 
		} else return "Item is sold Out";
		
		return null;
		// return Your item has been added..
		// subtract item from stack
		// display sold out if item sold out
		// subtract money from balance
		// if not enough money to buy item display not enough money
	}

	public Map<String, Stack<Item>> getVendingInventory() {
		return vendingInventory;
	}

	public void setVendingInventory(Map<String, Stack<Item>> vendingInventory) {
		this.vendingInventory = vendingInventory;
	}

}
