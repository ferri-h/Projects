package project2;

/**
 * Stores information of savings account opened by a specific holder
 * @author FERRIS HUSSEIN
 */

public class Savings extends Account {
	private boolean isLoyal;

	/**
	 * This method sets the boolean value of 'isLoyal'
	 * @param l, boolean user input where holder either loyal or not
	 */
	
	public void setLoyal(boolean l) {
		isLoyal = l;
	}

	/**
	 * This method gets the boolean value of 'isLoyal'
	 * @return isLoyal truth value
	 */
	
	public boolean getLoyal() {
		return isLoyal;
	}

	/**
	 * This method calculates the monthly interest based on 'isLoyal' truth value
	 * @return monthly interest for Savings account
	 */
	
	public double monthlyInterest() {
		if (getLoyal() == true) {
			return (getBalance() * 0.0035) / 12;
		} else {
			return (getBalance() * 0.0025) / 12;
		}
	}
	
	/**
	 * This method calculates the monthly fee based on balanxe
	 * @return monthly fee
	 */

	public double monthlyFee() {
		double fee = 0;

		if (getBalance() >= 300) {
			return 0;
		} else {
			fee = 5;
		}
		return fee;
	}
}