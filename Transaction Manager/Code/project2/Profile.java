package project2;

/**
 * Stores information of account holder
 * @author FERRIS HUSSEIN
 */

public class Profile {
	private String fname;
	private String lname;
	
	/**
	 * This method takes the first name input by the user and stores it in the private variable 'fname'
	 * @param f, first name input by user
	 */
	
	public void setFName(String f) {
		fname = f;	
	}
	
	/**
	 * This method takes the last name input by the user and stores it in the private variable 'lname'
	 * @param l, last name input by user
	 */
	
	public void setLName(String l) {
		lname = l;
	}
	
	/**
	 * This method gets the first name of the account holder
	 * @return fname, first name of account holder
	 */
	
	public String getFName() {
		return fname;	
	}
	
	/**
	 * This method gets the last name of the account holder
	 * @return lname, last name of account holder
	 */
	
	public String getLName() {
		return lname;
	}
}