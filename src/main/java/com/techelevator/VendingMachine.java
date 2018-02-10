package com.techelevator;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.time.Instant;

public class VendingMachine {

	private Map<String, Stack<Item>> vendingInventory = new HashMap<>();

	public VendingMachine(Map inventory) {
		this.setVendingInventory(inventory);
	}

	BigDecimal balance = new BigDecimal("0");
	String poppedItemGlobal = "";

	// Map<String, Stack<Item>> inventoryMap = new HashMap<>();

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void getUserSelection() {

	}

	public void addToBalance(BigDecimal balanceAdded) {
		
		balance = (balance.add(balanceAdded));
		
	}

	List<String> soundList = new ArrayList<>();

	public String makeChange() {
		int quarterCount = 0;
		int dimeCount = 0;
		int nickelCount = 0;

		while (this.getBalance().compareTo(new BigDecimal(".25")) >= 0) {
			balance = this.getBalance().subtract(new BigDecimal(".25"));
			quarterCount++;
		}
		while (this.getBalance().compareTo(new BigDecimal(".10")) >= 0) {
			balance = this.getBalance().subtract(new BigDecimal(".10"));
			dimeCount++;
		}
		while (this.getBalance().compareTo(new BigDecimal(".05")) >= 0) {
			balance = this.getBalance().subtract(new BigDecimal(".05"));
			nickelCount++;
		}

		return ("Your change is " + quarterCount + " quarters, " + dimeCount + " dimes, and " + nickelCount
				+ " nickels");

	}

	public String purchaseThis(String itemSelected) {

		if (vendingInventory.containsKey(itemSelected)) {
			if (vendingInventory.get(itemSelected).size() > 0) {
				if (this.getBalance().compareTo(vendingInventory.get(itemSelected).peek().getPrice()) > 0) {
					this.setBalance(balance.subtract(vendingInventory.get(itemSelected).peek().getPrice()));
					soundList.add(vendingInventory.get(itemSelected).peek().getNoise());
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());

					String poppedItemInMethod = 	( timestamp.toGMTString() + "  " +vendingInventory.get(itemSelected).peek().getName() + "  " + vendingInventory.get(itemSelected).peek().getItemlocation() );
					poppedItemGlobal = poppedItemInMethod;

					// pop should be last thing
					vendingInventory.get(itemSelected).pop();
					return ("Your item has been purchased " );

				}
				return "Sorry, feed me more money";
			} else
				return "Item is sold Out";

		} else
			return "Item Not Found";

	}

	public Map<String, Stack<Item>> getVendingInventory() {
		return vendingInventory;
	}

	public void setVendingInventory(Map<String, Stack<Item>> vendingInventory) {
		this.vendingInventory = vendingInventory;
	}

}
