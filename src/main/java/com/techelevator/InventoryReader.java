package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class InventoryReader {

	Map<String, Stack<Item>> inventoryMap = new HashMap<>();

	public void generateVendingList() throws FileNotFoundException {

		File inputFile = new File("vendingmachine.csv");

		Scanner inputFileReader = new Scanner(inputFile);

		while (inputFileReader.hasNextLine()) {
			String line = inputFileReader.nextLine();
			System.out.println(line);
			String itemArray[] = line.split("\\|");
			Stack<Item> stackOfItems = new Stack<>();

			for (int i = 0; i < 5; i++) {
				
				int counter = 0;
				counter++;

				if (itemArray[0].contains("A")) {
					stackOfItems.push(new ChipItem(itemArray[1], new BigDecimal(itemArray[2])));
				}
				if (itemArray[0].contains("B")) {
					stackOfItems.push(new CandyItem(itemArray[1], new BigDecimal(itemArray[2])));
				}
				if (itemArray[0].contains("C")) {
					stackOfItems.push(new BeverageItem(itemArray[1], new BigDecimal(itemArray[2])));
				}
				if (itemArray[0].contains("D")) {
					stackOfItems.push(new GumItem(itemArray[1], new BigDecimal(itemArray[2])));
				}
			} inventoryMap.put(itemArray[0], stackOfItems);
			
			
				
		}
		inputFileReader.close();
		
	}
	
	public void displayItems() {
		System.out.println(inventoryMap.toString());
		
	}
	

	

}
