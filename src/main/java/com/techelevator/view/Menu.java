package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}
	
	public String getProductSelected() {
		for(;;){
			out.println();
			out.print("Please enter item location >>>");
			out.flush();

			String productSelected = in.nextLine();
			try {
				return productSelected;
			} catch(NumberFormatException ex) {
				out.println("Please enter a valid number.");
				out.println();
				out.flush();
			}
		}
	}

	public BigDecimal getAmountFromUserInput() {
		for(;;){
			out.println();
			out.print("Please enter an amount >>>");
			out.flush();

			String userInput = in.nextLine();
			try {
			if (userInput.contains("1") || userInput.contains("5") || userInput.contains("10") || userInput.contains("20")) {
			     return new BigDecimal(userInput).setScale(2);
				} 
			}
		catch(IllegalArgumentException ex) {
			   out.println("Please enter a valid cash amount.");
			   out.println();
			   out.flush();
		}				
		}
}
	

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	
	
	
	
	
}
