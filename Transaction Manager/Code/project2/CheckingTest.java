/**
 * 
 */
package project2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Checking Test
 * @author FERRIS HUSSEIN, TANKPINOU PADONOU
 */

class CheckingTest {

	/**
	 * Test method for {@link project2.Checking#monthlyInterest()}.
	 */
	@Test
	void testMonthlyInterest() {
		Checking newCheck = new Checking();
		newCheck.setHolder("Ferris", "Tankpinou");
		assertTrue(newCheck.setDate("10/8/2020"));
		newCheck.setBalance(9876);
		
		// Monthly Interest test
		// Given 9876 balance, interest should be 9876*0.05%/12 
		assertEquals((9876*0.0005)/12,newCheck.monthlyInterest());
		
		// Given 123456789 balance, interest should be 123456789*0.05%/12 
		newCheck.setBalance(123456789);
		assertEquals((123456789*0.0005)/12,newCheck.monthlyInterest());
		
		// Given 1 balance, interest should be 1*0.05%/12
		newCheck.setBalance(1);
		assertEquals((1*0.0005)/12,newCheck.monthlyInterest());
	}

	/**
	 * Test method for {@link project2.Checking#monthlyFee()}.
	 */
	@Test
	void testMonthlyFee() {
		Checking newCheck = new Checking();
		newCheck.setHolder("Ferris", "Tankpinou");
		assertTrue(newCheck.setDate("10/8/2020"));
		newCheck.setBalance(1499);
		
		// Monthly Fee Test
		// Given directDeposit is false and 1499 balance, fee should we 25
		newCheck.setDirect(false);
		assertEquals(25, newCheck.monthlyFee());
		
		// Given directDeposit is false and 1500 balance, fee should be 0
		newCheck.setDirect(false);
		newCheck.setBalance(1500);
		assertEquals(0, newCheck.monthlyFee());
		
		// Given directDeposit is true and 10 balance, fee should be 0
		newCheck.setDirect(true);
		newCheck.setBalance(10);
		assertEquals(0, newCheck.monthlyFee());
		
		// Given directDeposit is false and 12321 balance, fee should be 0
		newCheck.setDirect(false);
		newCheck.setBalance(12321);
		assertEquals(0, newCheck.monthlyFee());
		
	}

}
