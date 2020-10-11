package project1;

import java.text.DecimalFormat;

/**
 * Stores information of a grocery item in their respective data fields and also
 * contains a toString() method for printing and equals() method for object comparison
 * @author FERRIS HUSSEIN
 */

public class GroceryItem {

    private String name;
    private double price;
    private boolean taxable;

    /**
     * This method retrieves the GroceryItem parameters and send them to their
     * respective setter methods in order to fill the data fields
     * 
     * @param aName is invoked in setName method
     * @param aPrice is invoked in setPrice method
     * @param isTaxable is invoked in setTaxable method
     */
    
    public GroceryItem(String aName, double aPrice, boolean isTaxable) {
        setName(aName);
        setPrice(aPrice);
        setTaxable(isTaxable);

    }

    /**
     * This method sets the private variable 'name' to 'theName'
     * @param theName is the name of the grocery item
     */
    public void setName(String theName) {
        name = theName;
    }

    /**
     * This method sets the private variable 'price' to 'thePrice'
     * @param thePrice is the price of the grocery item
     */
    public void setPrice(double thePrice) {
        price = thePrice;
    }

    /**
     * This method sets the private variable 'taxable' to 'isTaxable'
     * @param isTaxable is the boolean value that determines whether the grocery item is taxable
     */
    public void setTaxable(boolean isTaxable) {
        taxable = isTaxable;
    }

    /**
     * This method gets the grocery item name
     * @return name which is the name of the grocery item
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets the grocery item price
     * @return price which is the decimal price of the grocery item
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method gets the grocery item taxable value
     * @return taxable which is the truth value of whether the grocery item is taxable
     * 
     * returns false if not taxable, true otherwise
     */
    public boolean getTaxable() {
        return taxable;
    }

    /**
     * This method compares the values of two GroceryItem objects and their respective data fields
     * @return false if object is null or objects are not equal
     * @return true if objects are equal
     */
    public boolean equals(Object obj) {

        if (obj == null)
            return false;
        else if (getClass() != obj.getClass())
            return false;
        else {
            GroceryItem objCopy = (GroceryItem) obj;
            return (name.equals(objCopy.name) && price == objCopy.price && taxable == objCopy.taxable);
        }

    }
    
    /**
     * This method return a String representation of the data fields in the object which depends
     * on whether an item is taxable or not
     */
    public String toString() {

        DecimalFormat df = new DecimalFormat("0.00");
        if (getTaxable() == false) {
            return (name + " : $" + df.format(price) + " : tax free");

        } else
            return (name + " : $" + df.format(price) + " : is taxable");

    }
}
