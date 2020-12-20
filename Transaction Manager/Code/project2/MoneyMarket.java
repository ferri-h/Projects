package project2;

/**
 * Stores information of money market account opened by a specific holder
 * @author FERRIS HUSSEIN, TANKPINOU PADONOU
 */

public class MoneyMarket extends Account {
	private int withdrawals;

	/**
	 * This method initiates the withdrawals value to 0 when a money market
	 * account is created
	 */
	
	public MoneyMarket() {
		withdrawals = 0;
	}

	/**
	 * This method increments the number of withdrawals from specified money
	 * market account holder
	 */
	
	public void setWith() {
		withdrawals++;
	}

	/**
	 * This method gets the number of withdrawals from specified money market 
	 * account holder
	 * @return withdrawals, number of withdrawals
	 */
	
	public int getWith() {
		return withdrawals;
	}

	/**
	 * This method calculates the monthly interest
	 * @return monthly interest for money market account
	 */
	
	public double monthlyInterest() {
		return (getBalance() * 0.0065) / 12;
	}

	/**
	 * This method calculates the monthly fee based on the number of withdrawals 
	 * and/or balance
	 * @return monthly fee
	 */
	
	public double monthlyFee() {
		double fee = 0;

		if (withdrawals > 6) {
			return 12;
		}

		else if (getBalance() >= 2500) {
			return 0;
		} else {
			fee = 12;
		}

		return fee;
	}
}