package com.techelevator;

import java.math.BigDecimal;

public class VendingMachine {
	BigDecimal balance = new BigDecimal("0");

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void getUserSelection() {

	}

	public void addToBalance(BigDecimal balance) {
		balance.add(balance) ;
	}

	public String purchaseThis(String itemSelected) {

		return null;
		// return Your item has been added..
		// subtract item from stack
		// display sold out if item sold out
		// subtract money from balance
		// if not enough money to buy item display not enough money
	}

}
