package com.techelevator;

import java.io.FileNotFoundException;
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
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				InventoryReader ir = new InventoryReader();
				ir.displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (choice.equals(PURCHASE_DISPLAY_FEED))
					;
				System.out.println("Please deposit money");
				/*enter method from vending machine add*/menu.getAmountFromUserInput();
			}
			if (choice.equals(PURCHASE_DISPLAY_SELECT)) {
				System.out.println("Please enter the location of the item you would like to purchase ");
				Scanner inputItemSelection = new Scanner(System.in);
				String itemChosen = inputItemSelection.nextLine();
				
				
				inputItemSelection.close();


			}
			if (choice.equals(PURCHASE_DISPLAY_FINAL)) {
				System.out.println(menu);
			}

			// if(choice.equals(PURCHASE_DISPLAY_FEED))
			// if(menu.getAmountFromUserInput();

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
