package project2;

/**
 * Stores date of which the specified account was opened
 * @author FERRIS HUSSEIN
 */

public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;

	/**
	 * This method takes the string representation of the date opened provided by user and parses the the string 
	 * to set the private variables 'year', 'month', and 'day'
	 * @param d, string representation of date opened provided by user
	 */
	
	public void setDate(String d) {
		String[] lineProcessor = d.split("/");
		month = Integer.valueOf(lineProcessor[0]);
		day = Integer.valueOf(lineProcessor[1]);
		year = Integer.valueOf(lineProcessor[2]);
	}
	
	/**
	 * This method invokes a comparison amongst the dates provided by the user
	 * @param date, date to be compared
	 */
	
	@Override
	public int compareTo(Date date) { 
		if (this.year < date.year)  
			return -1;
        if (this.year > date.year)  
        	return 1;
        if (this.month < date.month) 
        	return -1;
        if (this.month > date.month) 
        	return 1;
        if (this.day < date.day)   
        	return -1;
        if (this.day > date.day)   
        	return 1;
        return 0;
	} // return 0, 1, or -1
	
	/**
	 * String representation of respective date
	 */

	public String toString() {
		return month + "/" + day + "/" + year;
	} // in the format mm/dd/yyyy

	/**
	 * This method checks if the provided date input by the user is a valid date
	 * @return false, if invalid and true otherwise
	 */
	
	public boolean isValid() { // checks if date is valid
		if (month < 1 || month > 12) // Check if month is between 1 and 12
			return false;
		if (day < 1 || day > 31) // Check if day is between 1 and 31
			return false;
		if (year < 1 || year > 9999) // Check if year is between 1 and 9999
			return false;
		
		if (month == 1 || month == 3 || month  == 5 || month == 7 || month == 8 || month == 10 || month == 12 ) { // check for months with maximum 31 days
			if (day > 31)
				return false;
		} else if (month == 2 ) { // Special condition for February
			if (day > 28 && year %4 != 0) // Checks if year is a leap year
				return false;
		} else {
			if (day > 30) // check for months with maximum 30 days
				return false;
		}
		
		return true;
	}
}