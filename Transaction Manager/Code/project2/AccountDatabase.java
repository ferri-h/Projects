package project2;

import java.text.DecimalFormat;

/**
 * Stores account types in database, searches for account in database, add account to database, removes account from database, print by last name and by date
 * @author FERRIS HUSSEIN, TANKPINOU PADONOU
 */

public class AccountDatabase {
	private Account[] accounts;
	private int size;
	
	/**
	 * This method initiates the account database as an array of size 5
	 */

	public AccountDatabase() {
		accounts = new Account[5];
		size = 0;
	}
	
	/**
	 * This method searches the account database array for a specified account and returns the index if the account is found, -1 otherwise
	 * @param account, account to find in database
	 * @return index of account location in database, -1 otherwise
	 */
	
	private int find(Account account) {
		for (int i = 0; i < size; i++) {
			if (accounts[i].equals(account)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * This method is a helper account to 'debit' specified value from balance
	 * Primarily used for Checking and Savings account
	 * @param account, account that withdrawal will occur
	 * @param val, value to be withdrawn
	 * @return truth value of whether withdrawal was successful or not
	 */
	
	public boolean debitHelp(Account account, Double val) {
		for (int i = 0; i < size; i++) {
			if (accounts[i].equals(account)) {
				if (accounts[i].getBalance()- val >0) {
					accounts[i].debit(val);	
					System.out.println(val+ " withdrawn from account.");
					return true;
				} 	
			} 
		}
		return false;
	}
	
	/**
	 * If database array is full, extend array size by 5
	 */

	private void grow() {
		
        Account[] extendedAccount = new Account[size + 5];

        for (int i = 0; i < size; i++)
            extendedAccount[i] = accounts[i];

        accounts = extendedAccount;

	}

	/**
	 * Add account to account database array
	 * @param account, account to be added
	 * @return truth value if account was successfully added
	 */
	
	public boolean add(Account account) {
		if (size % 5 == 0)	// checks if bag array is full
            grow();

		int i = find(account); // invokes find method to see if account exists
		
		if (i == -1) {
			accounts[size] = account;
	        size += 1;
	        return true;
		} else {
			System.out.println("Account is already in the database.");
			return false;
		}	
	} 

	/**
	 * Remove account to account database array
	 * @param account, account to be removed
	 * @return truth value if account was successfully removed
	 */
	
	public boolean remove(Account account) {
		boolean isRemoved = false;
        int index = find(account); // invokes find method to see if account exists
        if (index >= 0) {	
            accounts[index] = accounts[size - 1];
            accounts[size - 1] = null;
            isRemoved = true;
            size -= 1;
        }
        return isRemoved;
	} 
	
	/**
	 * Deposit money to specified account
	 * @param account, account where money will be deposited
	 * @param amount, value to be deposited
	 * @return truth value if deposit was successful or not
	 */

	public boolean deposit(Account account, double amount) {
		int i = find(account); // invokes find method to see if account exists
		
		if (i != -1) 
		{
			accounts[i].credit(amount);
			return true;
		}
		return false;
	}

	/**
	 * Withdraw money of specified account, use primarily for money market accounts
	 * @param account, account where money will be withdrawn
	 * @param amount, value to be withdrawn
	 * @return return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist
	 */

	public int withdrawal(Account account, double amount) { 
		int i = find(account); // invokes find method to see if account exists
		
		if (i == -1) {return -1;}
		
		if ( (accounts[i].getBalance() - amount > 0) ){
			accounts[i].debit(amount);
			((MoneyMarket) accounts[i]).setWith();
			return 0; // successful
		} else { 
			return 1; // insufficient
		}
	}

	/**
	 * Sorts account database by date in ascending order
	 */
	
	private void sortByDateOpen() {
		for (int i = 0; i < accounts.length-1 && accounts[i] != null; i++) {
			for (int j = i+1; j < accounts.length && accounts[j] != null; j++) {
				if (accounts[i].getDate().compareTo(accounts[j].getDate()) > 0) {
					Account tmp = accounts[i];
					accounts[i] = accounts[j];
					accounts[j] = tmp;
				}
			}
		}
	} 

	/**
	 * Sorts account database by last name
	 */
	
	private void sortByLastName() {	
		// sorts by last name
		for (int i = 0; i < accounts.length-1 && accounts[i] != null; i++) {
			for (int j = i+1; j < accounts.length && accounts[j] != null; j++) {
				if (accounts[i].getLastName().compareTo(accounts[j].getLastName()) > 0) {
					Account tmp = accounts[i];
					accounts[i] = accounts[j];
					accounts[j] = tmp;
				}
			}
		}
	} 

	/**
	 * Print database by date open in ascending order
	 */

	public void printByDateOpen() {
		if (accounts[0] == null) { // Check if database is empty
			System.out.println("Database is empty.");
			return;
		}
		
		sortByDateOpen();
		DecimalFormat d = new DecimalFormat("'$'###,###,##0.00"); // format dollar amount
		
		System.out.println("\n--Printing statements by date opened--");
		for (int i = 0; i < accounts.length && accounts[i] != null; i++) {
			System.out.println();
			
			if (accounts[i].getClass() == Checking.class) {System.out.print("*Checking*"); }
			if (accounts[i].getClass() == Savings.class) {System.out.print("*Savings*");}
			if (accounts[i].getClass() == MoneyMarket.class) {System.out.print("*MoneyMarket*");}
			System.out.print(accounts[i].toString());
			if ( accounts[i] instanceof Checking &&((Checking) accounts[i]).getDirect() == true) { // check if direct is true
				System.out.print("*direct deposit account*");
			}
			if ( accounts[i] instanceof Savings && ((Savings) accounts[i]).getLoyal() == true) { // check if direct is true
				System.out.print("*special Savings account*");
			}
			if ( accounts[i] instanceof MoneyMarket && ((MoneyMarket) accounts[i]).getWith() >= 0) { // check if direct is true
				if (((MoneyMarket) accounts[i]).getWith() == 1) {
					System.out.print("*"+((MoneyMarket) accounts[i]).getWith()+" withdrawal*"); // one withdrawal print statement
				} else {
					System.out.print("*"+((MoneyMarket) accounts[i]).getWith()+" withdrawals*"); // multiple withdrawal print statement
				}		
			}
			System.out.println();
			
			System.out.println("-interest: " + d.format(accounts[i].monthlyInterest()));
			System.out.println("-fee: " + d.format(accounts[i].monthlyFee()));
			accounts[i].setBalance(accounts[i].getBalance() - accounts[i].monthlyFee() + accounts[i].monthlyInterest());
			System.out.println("-new balance: " + d.format(accounts[i].getBalance()));
			
			
		}
		System.out.println("--end of printing--");
	}

	/*
	 * Print account database by last name
	 */
	
	public void printByLastName() {
		
		if (accounts[0] == null) { // Check if database is empty
			System.out.println("Database is empty.");
			return;
		}
		
		sortByLastName();
		DecimalFormat d = new DecimalFormat("'$' ###,###,##0.00"); // format dollar amount

		System.out.println("\n--Printing statements by last name--");
		for (int i = 0; i < accounts.length && accounts[i] != null; i++) {
			System.out.println();
			
			if (accounts[i].getClass() == Checking.class) {System.out.print("*Checking*"); }
			if (accounts[i].getClass() == Savings.class) {System.out.print("*Savings*");}
			if (accounts[i].getClass() == MoneyMarket.class) {System.out.print("*MoneyMarket*");}
			System.out.print(accounts[i].toString());
			if ( accounts[i] instanceof Checking &&((Checking) accounts[i]).getDirect() == true) { // check if direct is true
				System.out.print("*direct deposit account*");
			}
			if ( accounts[i] instanceof Savings && ((Savings) accounts[i]).getLoyal() == true) { // check if direct is true
				System.out.print("*special Savings account*");
			}
			if ( accounts[i] instanceof MoneyMarket && ((MoneyMarket) accounts[i]).getWith() >= 0) { // check if direct is true
				if (((MoneyMarket) accounts[i]).getWith() == 1) {
					System.out.print("*"+((MoneyMarket) accounts[i]).getWith()+" withdrawal*"); // one withdrawal print statement
				} else {
					System.out.print("*"+((MoneyMarket) accounts[i]).getWith()+" withdrawals*"); // multiple withdrawal print statement
				}	
			}
			System.out.println();
	
			System.out.println("-interest: " + d.format(accounts[i].monthlyInterest()));
			System.out.println("-fee: " + d.format(accounts[i].monthlyFee()));
			accounts[i].setBalance(accounts[i].getBalance() - accounts[i].monthlyFee() + accounts[i].monthlyInterest());
			System.out.println("-new balance: " + d.format(accounts[i].getBalance()));
			
		}
		System.out.println("--end of printing--");
		
	}
	
	/*
	 * Print all accounts in database
	 */

	public void printAccounts() { 
		if (accounts[0] == null) { // Check if database is empty
			System.out.println("Database is empty.");
			return;
		}
		
		System.out.println("--Listing accounts in the database--");
		for (int i = 0; i < accounts.length && accounts[i] != null; i++) {
			if (accounts[i].getClass() == Checking.class) {System.out.print("*Checking*"); }
			if (accounts[i].getClass() == Savings.class) {System.out.print("*Savings*");}
			if (accounts[i].getClass() == MoneyMarket.class) {System.out.print("*MoneyMarket*");}
			
			System.out.print(accounts[i].toString());
			if ( accounts[i] instanceof Checking &&((Checking) accounts[i]).getDirect() == true) { // check if direct is true
				System.out.print("*direct deposit account*");
			}
			if ( accounts[i] instanceof Savings && ((Savings) accounts[i]).getLoyal() == true) { // check if isloyal is true
				System.out.print("*special Savings account*");
			}
			if ( accounts[i] instanceof MoneyMarket && ((MoneyMarket) accounts[i]).getWith() >= 0) { 
				if (((MoneyMarket) accounts[i]).getWith() == 1) {
					System.out.print("*"+((MoneyMarket) accounts[i]).getWith()+" withdrawal*"); // one withdrawal print statement
				} else {
					System.out.print("*"+((MoneyMarket) accounts[i]).getWith()+" withdrawals*"); // multiple withdrawal print statement
				}	
			}
			System.out.println();
		}
		System.out.println("--end of listing--");
	}
}