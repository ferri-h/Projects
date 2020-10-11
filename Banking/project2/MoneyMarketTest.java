/**
 * 
 */
package project2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * MoneyMarket Test
 * @author FERRIS HUSSEIN
 */

class MoneyMarketTest {

	/**
	 * Test method for {@link project2.MoneyMarket#monthlyInterest()}.
	 */
	@Test
	void testMonthlyInterest() {
		MoneyMarket newMM = new MoneyMarket();
		newMM.setHolder("Ferris", "Tankpinou");
		assertTrue(newMM.setDate("10/8/2020"));
		newMM.setBalance(100000);
		
		// Monthly Interest test
		// Given 1000000 balance, interest should be 100000*0.65%/12 
		assertEquals((100000*0.0065)/12,newMM.monthlyInterest());
		
		// Given 123456 balance, interest should be 123456*0.65%/12 
		newMM.setBalance(123456);
		assertEquals((123456*0.0065)/12,newMM.monthlyInterest());
		
		// Given 5 balance, interest should be 5*0.65%/12
		newMM.setBalance(5);
		assertEquals((5*0.0065)/12,newMM.monthlyInterest());
	}

	/**
	 * Test method for {@link project2.MoneyMarket#monthlyFee()}.
	 */
	@Test
	void testMonthlyFee() {
		MoneyMarket newMM = new MoneyMarket();
		newMM.setHolder("Tankpinou", "Ferris");
		assertTrue(newMM.setDate("10/8/2020"));
		newMM.setBalance(2500);
		
		// Monthly Fee Test
		// Given 2500 balance, fee should be 0
		assertEquals(0,newMM.monthlyFee());
		
		// Given 2499 balance, fee should be 12
		newMM.setBalance(2499);
		assertEquals(12,newMM.monthlyFee());
		
		// Given 100000 balance, fee should be 0
		newMM.setBalance(100000);
		assertEquals(0,newMM.monthlyFee());
		
		// Given 6 withdrawals and 2500 balance, fee should be 0
		newMM.setBalance(2500);
		for (int i = 0; i < 6; i++) { newMM.setWith();} // this loop increments withdrawals 6 times
		assertEquals(0,newMM.monthlyFee());
		
		// Given 7 withdrawals and 5000 balance, fee cannot be waived so fee should be 12
		newMM.setBalance(5000);
		newMM.setWith();
		assertEquals(12,newMM.monthlyFee());
		
		// Given 7 withdrawals and 20 balance, fee cannot be waived so fee should be 12
		newMM.setBalance(20);
		assertEquals(12,newMM.monthlyFee());
		
	}

}
