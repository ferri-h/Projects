package project2;

/**
 * Stores information of checking account opened by a specific holder
 * @author FERRIS HUSSEIN
 */

public class Checking extends Account {
	private boolean directDeposit;

	/**
	 * This method sets the boolean value of 'directDeposit'
	 * @param b, boolean user input where holder either is enrolled with direct deposit or is not
	 */
	
	public void setDirect(boolean b) {
		directDeposit = b;
	}
	
	/**
	 * This method gets the boolean value of 'setDirect'
	 * @return directDeposit truth value
	 */

	public boolean getDirect() {
		return directDeposit;
	}
	
	/**
	 * This method calculates the monthly interest
	 * @return monthly interest for Checking account
	 */

	public double monthlyInterest() {
		return (getBalance() * 0.0005) / 12;
	}

	/**
	 * This method calculates the monthly fee based on balance and/or directDeposit boolean value
	 * @return monthly fee
	 */
	
	public double monthlyFee() {

		double fee = 0;

		if (directDeposit == true) {
			return 0;
		} else if (getBalance() >= 1500) {
			return 0;
		} else {
			fee = 25;
		}
		return fee;
	}
}