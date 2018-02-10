package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		String  fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
		fileName += "  Log File";
		  File logFile = new File (fileName);
		PrintWriter logWriter = new PrintWriter(logFile);


		
		 
		
		
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
					
					BigDecimal previousBalance = VM5000.balance;
					VM5000.addToBalance(menu.getAmountFromUserInput());
					System.out.println("Machine Balance " + VM5000.getBalance());
					String feedWrite = ( timestamp.toGMTString() + " FEED MONEY:  " +"$"+previousBalance.toString() + "    " +"$"+ VM5000.getBalance().toString());
					logWriter.append(feedWrite);
					logWriter.append("\n");


					
				}

				if (choice.equals(PURCHASE_DISPLAY_SELECT)) {
					System.out.println("Please enter the location of the item you would like to purchase ");
					
					
					//printWrtierClass.appendthisitem(purchased Item String);
					String beforeAfterBalance = ("    $"+VM5000.getBalance().toString());

					System.out.println(VM5000.purchaseThis(menu.getProductSelected()));
					beforeAfterBalance += ("     $"+VM5000.getBalance().toString());
					logWriter.append(VM5000.poppedItemGlobal);
					logWriter.append(beforeAfterBalance);

					logWriter.append("\n");
					
				}
				if (choice.equals(PURCHASE_DISPLAY_FINAL)) {
					String logChange = ( timestamp.toGMTString() + " GIVE CHANGE:  " +"$"+ VM5000.getBalance().toString());
					System.out.println(VM5000.makeChange());
					logChange += ("    " +"$"+ VM5000.getBalance().toString());
					logWriter.append(logChange);
					logWriter.close();

					for (String sound : VM5000.soundList) {
						System.out.println(sound);

					}
					

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
