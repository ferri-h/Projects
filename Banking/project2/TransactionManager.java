package project2;

import java.util.Scanner;

/**
 * This class handles all user inputs as well as error checking and data type mismatches
 * @author FERRIS HUSSEIN
 */

public class TransactionManager {

	public void run() {
		System.out.println("Transaction processing starts.....");
		AccountDatabase myAccounts = new AccountDatabase();
		Scanner s = new Scanner(System.in);
		boolean done = false;
		String line = "";
		String command = "";
		String fname = "";
		String lname = "";
		double balance = 0;
		
		/**
		 * To check input command validity, check all exceptions Anything coming out of
		 * this loop is a valid command
		 */
		
		do {
			do {
				line = s.nextLine();

				String[] lineProcessor = line.split(" "); // Splits input line by spaces

				command = lineProcessor[0];
				if (command.equals("Q")) { // Quit command
					System.out.println("Transaction processing completed.");
					System.exit(1);
				}

				String date = "";
				Boolean b = false;

				try {
					
					// These if/else statements handles specific number of arguments required
					if (lineProcessor.length == 3) {
						fname = lineProcessor[1];
						lname = lineProcessor[2];
					} else if (lineProcessor.length == 4) {
						fname = lineProcessor[1];
						lname = lineProcessor[2];
						balance = Double.parseDouble(lineProcessor[3]);
					} else if (lineProcessor.length > 4 && !(command.equals("OM"))) {
						fname = lineProcessor[1];
						lname = lineProcessor[2];
						balance = Double.parseDouble(lineProcessor[3]);
						date = lineProcessor[4];
						if (lineProcessor[5].equalsIgnoreCase("false") || lineProcessor[5].equalsIgnoreCase("true")) {
							b = Boolean.parseBoolean(lineProcessor[5]);
						} else {
							System.out.println("Input data type mismatch.");
							break;
						}
					} else if ((lineProcessor.length > 4 && command.equals("OM"))) {
						fname = lineProcessor[1];
						lname = lineProcessor[2];
						balance = Double.parseDouble(lineProcessor[3]);
						date = lineProcessor[4];
					}

					
					// These if/else statements handles account commands
					if (command.equals("OC")) { // Open starts here, opens Checking account
						Checking newCheck = new Checking();
						newCheck.setHolder(fname, lname);
						newCheck.setBalance(balance);
						boolean checkDate = newCheck.setDate(date);
						if (checkDate == true) {
							newCheck.setDirect(b);
							boolean check = myAccounts.add(newCheck);
							if (check == true) {
								System.out.println("Account opened and added to the database.");
							}
						} else {
							System.out.println(newCheck.getDate().toString() + " is not a valid date!");
						}
					} else if (command.equals("OS")) { // opens Savings account
						Savings newSave = new Savings();
						newSave.setHolder(fname, lname);
						newSave.setBalance(balance);

						boolean checkDate = newSave.setDate(date);
						if (checkDate == true) {
							newSave.setLoyal(b);
							boolean check = myAccounts.add(newSave);
							if (check == true) {
								System.out.println("Account opened and added to the database.");
							}
						} else {
							System.out.println(newSave.getDate().toString() + " is not a valid date!");
						}
					} else if (command.equals("OM")) { // opens MoneyMarket account
						MoneyMarket newMM = new MoneyMarket();
						newMM.setHolder(fname, lname);
						newMM.setBalance(balance);
						boolean checkDate = newMM.setDate(date);
						if (checkDate == true) {
							boolean check = myAccounts.add(newMM);
							if (check == true) {
								System.out.println("Account opened and added to the database.");
							}
						} else {
							System.out.println(newMM.getDate().toString() + " is not a valid date!");
						}
					} else if (command.equals("CC")) { // Remove starts here, remove user specified Checking account
						Checking remCheck = new Checking();
						remCheck.setHolder(fname, lname);
						boolean check = myAccounts.remove(remCheck);
						if (check == true) {
							System.out.println("Account closed and removed from the database.");
						} else {
							System.out.println("Account does not exist.");
						}
					} else if (command.equals("CS")) { // remove user specified Savings account
						Savings remSave = new Savings();
						remSave.setHolder(fname, lname);
						boolean check = myAccounts.remove(remSave);
						if (check == true) {
							System.out.println("Account closed and removed from the database.");
						} else {
							System.out.println("Account does not exist.");
						}

					} else if (command.equals("CM")) { // remove user specified MoneyMarkey account
						MoneyMarket remMM = new MoneyMarket();
						remMM.setHolder(fname, lname);
						boolean check = myAccounts.remove(remMM);
						if (check == true) {
							System.out.println("Account closed and removed from the database.");
						} else {
							System.out.println("Account does not exist.");
						}
					} else if (command.equals("DC")) { // Deposit starts here, deposit to user specified Checking account
						Checking depChecking = new Checking();
						depChecking.setHolder(fname, lname);
						boolean check = myAccounts.deposit(depChecking, balance);
						if (check == true) {
							System.out.println(balance + " deposited to account");
						} else {
							System.out.println("Account does not exist.");
						}
					} else if (command.equals("DS")) { // deposit to user specified Savings account
						Savings depSavings = new Savings();
						depSavings.setHolder(fname, lname);
						boolean check = myAccounts.deposit(depSavings, balance);
						if (check == true) {
							System.out.println(balance + " deposited to account");
						} else {
							System.out.println("Account does not exist.");
						}
					} else if (command.equals("DM")) { // deposit to user specified MoneyMarket account
						MoneyMarket depMM = new MoneyMarket();
						depMM.setHolder(fname, lname);
						boolean check = myAccounts.deposit(depMM, balance);
						if (check == true) {
							System.out.println(balance + " deposited to account");
						} else {
							System.out.println("Account does not exist.");
						}
					} else if (command.equals("WC")) { // Withdraw starts here, withdraw from user specified Checking account
						Checking withCheck = new Checking();
						withCheck.setHolder(fname, lname);
						boolean check = myAccounts.debitHelp(withCheck, balance);
						if (check == false) {
							System.out.println("Account does not exist.");
						} 
					} else if (command.equals("WS")) { // withdraw from user specified Savings account
						Savings withSavings = new Savings();
						withSavings.setHolder(fname, lname);
						boolean check = myAccounts.debitHelp(withSavings, balance);
						if (check == false) {
							System.out.println("Account does not exist.");
						} 
					} else if (command.equals("WM")) { // withdraw from user specified MoneyMarkey account
						MoneyMarket withMM = new MoneyMarket();
						withMM.setHolder(fname, lname);
						int check = myAccounts.withdrawal(withMM, balance);

						if (check == 0) {
							System.out.println(balance + " withdrawn from account.");
						} else if (check == 1) {
							System.out.println("Insufficient Funds.");
						} else {
							System.out.println("Account does not exist.");
						}
					} else if (command.equals("PA")) { // print all accounts
						myAccounts.printAccounts();
					} else if (command.equals("PD")) { // print by date
						myAccounts.printByDateOpen();
					} else if (command.equals("PN")) { // print by last name
						myAccounts.printByLastName();
					} else {
						System.out.println("Command '" + command + "' not supported!");
					}

				}
				catch (Exception e) { // catch data type mismatch
					System.out.println("Input data type mismatch.");
				}
			} while (!done);
		} while (!done);
	}
}
