package project2;

import java.text.DecimalFormat;

/**
 * This class defines specific account by using setter and getter methods
 * @author FERRIS HUSSEIN
 */

public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	/**
	 * Sets first name and last name 'Profile'
	 * @param f, user input of first name
	 * @param l, user input of last name
	 */
	
	public void setHolder(String f, String l) {
		holder = new Profile();
		holder.setFName(f);
		holder.setLName(l);
	}
	
	/**
	 * Helper method to get last name (used to sort by last name in 'AccountDatabase.java')
	 * @return last name of holder
	 */
	
	public String getLastName() {
		return holder.getLName();
	}
	
	/**
	 * Helper method for toString() method 
	 * @return s, string prepresentation of account
	 */
	
	public String getAccount() {
		DecimalFormat d = new DecimalFormat("'$'###,###,##0.00");
		String s = "";
		s = s.concat(holder.getFName()).concat(" ").concat(holder.getLName().concat("* ").concat(d.format(balance)).concat("*").concat(dateOpen.toString()));
		//s = s.concat(holder.getFName()).concat(" ").concat(holder.getLName().concat(" ").concat(Double.toString(balance)));
		return s;
	}
	
	/**
	 * Sets balance of account holder
	 * @param b, double balance value entered by user
	 */
	
	public void setBalance(double b) {
		balance = b;	
	}

	/**
	 * Gets balance of account holder
	 * @return balance, double representation of account balance
	 */
	
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Set date given string representation by user
	 * @param date, string presentation of date
	 * @return truth value by invoking isValid() method to check if date is valid
	 */
	
	public boolean setDate(String date) {
		dateOpen = new Date();
		dateOpen.setDate(date);
		boolean check = dateOpen.isValid();
		if (check == false) 
			return false;
		else 		
			return true;
	}
	
	/**
	 * Gets date opened of specific account
	 * @return dateOpen
	 */
	
	public Date getDate() {
		return dateOpen;
	}
	
	/**
	 * Withdraw specified amount from account balance
	 * @param amount, amount to be withdrawn
	 */

	public void debit(double amount) {
		if (balance - amount > 0) { // checks if account holder has sufficient funds after withdrawal
			balance -= amount;
		} else {
			System.out.println("Insufficient funds.");
			return;
		}
		
	} 
	
	/**
	 * Deposits specified amount to account balance
	 * @param amount, amount to be deposited
	 */

	public void credit(double amount) {
		balance += amount;
	} 

	/**
	 * String representation of account, invokes helper method getAccount()
	 */
	
	public String toString() {
		return getAccount();
	}
	
	/**
	 * Equals method to compare accounts
	 * @return truth value of comparison
	 */
	
	@Override
	public boolean equals(Object obj) { //***********
        if (obj == null)
            return false;
        else if (getClass() != obj.getClass())
            return false;
        else {
            Account objCopy = (Account) obj;
            return (holder.getFName().equals(objCopy.holder.getFName()) && 
            		holder.getLName().equals(objCopy.holder.getLName()) ); 
        }
    }
	
	/**
	 * Abstract statement to incur monthly interest and monthly fee
	 */
	
	public abstract double monthlyInterest();
	public abstract double monthlyFee();
		
}
