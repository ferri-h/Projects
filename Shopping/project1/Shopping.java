package project1;

import java.util.*;
import java.text.DecimalFormat;

/**
 * User interface class that reads input commands from the user and outputs data
 * that is dependent on the input
 * @author FERRIS HUSSEIN
 */

public class Shopping {

	/**
	 * This method runs a loop to receive inputs from the user and outputs the 
	 * result of the corresponding input and also handle illegal inputs
	 */
    public void run() {

            Scanner s = new Scanner(System.in);

            System.out.println("Let's start shopping!");

            ShoppingBag Mybag = new ShoppingBag();

            boolean done = false;
            String line, action, nameentered = "";
            double priceEntered = 0;
            boolean taxableValue = true;



            do {

                /**
                 * To check input command validity, check all exceptions
                 * Anything coming out of this loop is a valid command
                 * */
                 
                do {

                    line = s.nextLine();	// reads user input line by line
                    action = line.substring(0, 1);	
                    if (line.indexOf(" ") != 1 && !(action.equals("P") || action.equals("Q") || action.equals("C"))) {
                        System.out.println("Invalid command!");

                    } else if (action.equals("P") || action.equals("Q") || action.equals("C") ) {	// if action is 'P', 'Q', or 'C', this do-while loop ends
                        done = true;
                    } else {

                        String[] lineProcessor = line.split(" ");
                        if (lineProcessor.length < 4) {		// if there are less than four arguments, print "Invalid command"
                            System.out.println("Invalid command!");
                        } else {

                            try {
                                nameentered = lineProcessor[1];		// four arguments found so try to store them in their respective variables
                                priceEntered = Double.parseDouble(lineProcessor[2]);
                                taxableValue = Boolean.parseBoolean(lineProcessor[3]);
                                done = true;

                            } catch (Exception e) {		// Print "Invalid command" otherwise
                                System.out.println("Invalid command!");
                            }
                        }
                    }
                } while (!done);



                if (action.equals("A")) {	// if action equals 'A', add item to shopping bag using add() method

                    Mybag.add(new GroceryItem(nameentered, priceEntered, taxableValue));
                    System.out.println(nameentered + " added to the bag.");

                } else if (action.equals("R")) {	// if action equal 'R', remove item from shopping bag using remove() method

                    if (Mybag.remove(new GroceryItem(nameentered, priceEntered, taxableValue))) {
                        System.out.println(nameentered + " " + priceEntered + " removed.");
                    } else {
                        System.out.println("Unable to remove, this item is not in the bag.");	// item doesn't exit
                    }
                } else if (action.equals("P")) {	// if action equals 'P', print all contents off shopping bag using print() method
                    Mybag.print();
                } else if (action.equals("C")) {	// if action equals 'C', checkout all items in shopping bag using CheckOut() method
                    Mybag.CheckOut();
                } else if (action.equals("Q")) {	// if action equals 'Q', print goodbye message and exit program
                    System.out.println("Thanks for shopping with us!");
                    System.exit(0);
                } else {	// Any other command at this point prints "Invalid Command"
                    System.out.println("Invalid command!");
                }
                done = false;
            } while (!action.equals("Q")); 

    }
}