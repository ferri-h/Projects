package project2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Date Test
 * @author FERRIS HUSSEIN
 */

class DateTest {

	/**
	 * Test method for {@link project2.Date#isValid()}.
	 */
	@Test
	void testIsValid() {
		Date d = new Date();
		// no 32nd day in December, should be false
		d.setDate("12/32/2020");
		assertFalse(d.isValid());
		// 2020 is a leap year, should be true
		d.setDate("2/29/2020");
		assertTrue(d.isValid());
		// 2019 is NOT a leap year, should be false
		d.setDate("2/29/2019");
		assertFalse(d.isValid());
		// 0 cannot be a day, should return false
		d.setDate("1/0/2020");
		assertFalse(d.isValid());
		// 0 cannot be month, should return false
		d.setDate("0/12/1979");
		assertFalse(d.isValid());
		// 0 cannot be year, should return false
		d.setDate("1/1/0");
		assertFalse(d.isValid());
		// There is no 31 in September, should return false
		d.setDate("9/31/1998");
		assertFalse(d.isValid());
		// month can't be negative, should return false
		d.setDate("-1/1/2020");
		assertFalse(d.isValid());
		// day can't be negative, should return false
		d.setDate("1/-1/2020");
		assertFalse(d.isValid());
		// year can't be negative, should return false
		d.setDate("1/1/-1");
		assertFalse(d.isValid());
		
		
	}

}
