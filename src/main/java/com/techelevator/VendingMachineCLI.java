package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_DISPLAY_FEED = "Feed Money";
	private static final String PURCHASE_DISPLAY_SELECT = "Select Product";
	private static final String PURCHASE_DISPLAY_FINAL = "Finish Transaction";

	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_DISPLAY_FEED, PURCHASE_DISPLAY_SELECT,
			PURCHASE_DISPLAY_FINAL };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {

		InventoryReader ir = new InventoryReader();
		ir.generateVendingList();
		VendingMachine VM5000 = new VendingMachine(ir.inventoryMap);

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				for (String key : VM5000.getVendingInventory().keySet()) {
					String soldoutItem = "";
					soldoutItem.equals(key);

					if (VM5000.getVendingInventory().get(key).size() > 0) {
						System.out.println(VM5000.getVendingInventory().get(key).peek().getItemlocation() + "  "
								+ VM5000.getVendingInventory().get(key).peek().getName() + " "
								+ VM5000.getVendingInventory().get(key).peek().getPrice() + "  --Quantity remaining -- "
								+ VM5000.getVendingInventory().get(key).size());
					} else
						System.out.println(soldoutItem + "Sold Out");

				}

			}
			if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (choice.equals(PURCHASE_DISPLAY_FEED)) {

					System.out.println("\nPlease deposit money");
				VM5000.addToBalance(menu.getAmountFromUserInput());
				System.out.println("Machine Balance " + VM5000.getBalance());
				}
				/* choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); */

				if (choice.equals(PURCHASE_DISPLAY_SELECT)) {
					System.out.println("Please enter the location of the item you would like to purchase ");
					System.out.println("sdfsdf");

					//VM5000.purchaseThis(menu.getProductSelected());
					System.out.println(menu.getProductSelected());
					System.out.println(VM5000.inventoryMap.get(menu.getProductSelected()).pop());

					/* choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS); */
				}
				if (choice.equals(PURCHASE_DISPLAY_FINAL)) {
					System.out.println("sdfsdf");
					System.out.println(menu);
					System.out.println("sdfsdf");

				}
			}

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
