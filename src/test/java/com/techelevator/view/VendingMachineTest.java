package com.techelevator.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.CandyItem;
import com.techelevator.ChipItem;
import com.techelevator.Item;
import com.techelevator.VendingMachine;

public class VendingMachineTest {

	
		private VendingMachine testMachine;
		private Map<String, Stack<Item>> vendingInventory = new HashMap<>();
		String line = "A4|Dog Food|2.40";
		String itemArray[] = line.split("\\|");
		Stack<Item> stackOfItems = new Stack<>();
		String lineCandy = "C2|Dog Candy|2.15";
		String candyArray[] = lineCandy.split("\\|");
		
		
		@Before
		
		public void setup() throws Exception {
			testMachine = new VendingMachine(vendingInventory);
			stackOfItems.push(new ChipItem(itemArray[1], new BigDecimal(itemArray[2]),itemArray[0]));
		}
		
		@Test
		public void testConstructor() {
			assertNotNull(testMachine);						
		
		}
		
		@Test
		public void initialBalance() {
			assertEquals(testMachine.getBalance(),new BigDecimal ("0"));					//asserts that fruit tree has been created
		
		}
		
		@Test
		public void testItem() {
			stackOfItems.push(new ChipItem(itemArray[1], new BigDecimal(itemArray[2]),itemArray[0]));
			vendingInventory.put("location", stackOfItems);
		
			assertEquals(vendingInventory.get("location").peek().getItemlocation(), "A4");	
					
			assertEquals(vendingInventory.get("location").peek().getName(), "Dog Food");
			assertEquals(vendingInventory.get("location").peek().getPrice(), new BigDecimal ("2.40"));
		
		}
		
		@Test
		public void addToBalance() {
			testMachine.addToBalance(new BigDecimal ("5.00"));

			testMachine.addToBalance(new BigDecimal ("5.00"));
			assertEquals(testMachine.getBalance(), new BigDecimal ("10.00"));
		}
		
		@Test
		public void buyItem() {
			stackOfItems.push(new ChipItem(itemArray[1], new BigDecimal(itemArray[2]),itemArray[0]));
			vendingInventory.put("location", stackOfItems);
			
			testMachine.addToBalance(new BigDecimal ("5.00"));
			testMachine.purchaseThis("location");
			assertEquals(testMachine.getBalance(), new BigDecimal ("2.60"));
			
		}
		
		@Test
		public void getChange() {
			stackOfItems.push(new ChipItem(itemArray[1], new BigDecimal(itemArray[2]),itemArray[0]));
			stackOfItems.push(new ChipItem(itemArray[1], new BigDecimal(itemArray[2]),itemArray[0]));
			stackOfItems.push(new CandyItem(candyArray[1], new BigDecimal(candyArray[2]), candyArray[0]));
			vendingInventory.put("location", stackOfItems);
			vendingInventory.put("location", stackOfItems);
			vendingInventory.put("secondLocation", stackOfItems);
			testMachine.addToBalance(new BigDecimal ("5.00"));
			testMachine.purchaseThis("location");
			assertEquals(testMachine.makeChange(), "Your change is 11 quarters, 1 dimes, and 0 nickels");
			testMachine.addToBalance(new BigDecimal ("5.00"));
			testMachine.purchaseThis("location");
			testMachine.purchaseThis("secondLocation");
			assertEquals(testMachine.makeChange(), "Your change is 0 quarters, 2 dimes, and 0 nickels");
			
		}
		
}
