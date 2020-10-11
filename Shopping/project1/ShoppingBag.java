package project1;

import java.text.DecimalFormat;

/**
 * Container class that performs shopping bag operations on an object array that holds
 * grocery items
 * @author FERRIS HUSSEIN
 */

public class ShoppingBag {

    private GroceryItem[] bag;
    private int size;

    /**
     * This method creates a new bag with a limit of 5 items
     */
    public ShoppingBag() {

        bag = new GroceryItem[5];
        size = 0;

    }

    /**
     * This method returns the index of the specified grocery item in the 'bag' array
     * and returns -1 if not found
     * @param Item, grocery item that we are searching for in bag array
     * @return i, index of 'Item' in bag array
     * @return -1, if item not found in bag array
     */
    private int find(GroceryItem Item) {

        for (int i = 0; i < size; i++) {
            if (bag[i].equals(Item))
                return i;
        }
        return -1;
    }

    /**
     * This method is invoked when the bag array is full. The bag's capacity is extended to hold 5 more items.
     */
    private void grow() {

        GroceryItem[] extendedbag = new GroceryItem[size + 5];

        for (int i = 0; i < size; i++)
            extendedbag[i] = bag[i];

        bag = extendedbag;

    }

    /**
     * This method first checks if the bag is full, if so, we invoke the grow() method to extend the
     * bag to hold 5 more items. Then, we add the item to the bag array and increment the size by 1.
     * @param item, the grocery item that will be added to the bag
     */
    public void add(GroceryItem item) {

        if (size % 5 == 0)	// checks if bag array is full
            grow();

        bag[size] = item;
        size += 1;
    }

    /**
     * This methods invokes the find() method to locate the index of the grocery item to be removes 
     * and removes the item from the bag array and decreases the bag size by 1. 
     * @param item, grocery item to be removed from bag array
     * @return isRemoved, true if item is successfully removed, false otherwise
     */
    public boolean remove(GroceryItem item) {

        boolean isRemoved = false;
        int index = find(item);
        if (index >= 0) {	// if the find method returns and index that is greater than or equal to 1, removes item
            bag[index] = bag[size - 1];
            bag[size - 1] = null;
            isRemoved = true;
            size -= 1;
        }
        return isRemoved;

    }

    /**
     * This method calculates and returns the total price of all the items in the bag array
     * @return total, double value of total price of items in bag array
     */
    public double salesPrice() {

        double total = 0;
        for (int i = 0; i < size; i++) {
            total += bag[i].getPrice();
        }
        return total;

    }

    /**
     * This method calculates and returns the total price of taxable items in the bag array and invokes 
     * 6.625% tax on each taxable item
     * @return total, double value of total price of taxable items in bag array with 6.625% tax applied
     */
    public double salesTax() {

        double total = 0;
        for (int i = 0; i < size; i++) {
            if (bag[i].getTaxable())
                total += (bag[i].getPrice() * 0.06625);
        }
        return total;
    }
    
    /**
     * This method prints all the grocery items in the bag array 
     */
    public void print() {
        if (size == 0)	// if the bag is empty, print "The bag is empty!"
            System.out.println("The bag is empty!");

        else {
            System.out.println("**You have " + size + " items in the bag.");

            for (int i = 0; i < size; i++)
                System.out.println(bag[i].toString());

            System.out.println("**End of the List");
        }

    }
    
    /**
     * Helper method, to return the number of items in shopping bag
     * @return size, number of items in bag array
     */
    public int getCapacity() {
        return size;
    }

    DecimalFormat df = new DecimalFormat("0.00");

    /**
     * This method check out all the items in the bag array including sales total, sales tax and 
     * the total amount paid
     */
    public void CheckOut() {
        if (size == 0)	// if bag is empty, print the "The bag is empty!"
            System.out.println("The bag is empty!");	
        else {

            if ( size == 1) {	// if bag has 1 grocery item
                System.out.println("Checking out 1 item.");
            }
            else {	// if bag has more than one grocery item
                System.out.println("Checking out " + size + " items.");
            }
            for (int i = 0; i< getCapacity();i++) {	// invokes toString in GroceryItem.java to print data fie
                System.out.println(bag[i].toString());
            }
            System.out.println("*Sales total: $" + df.format(salesPrice()));
            System.out.println("*Sales tax: $" + df.format(salesTax()));
            System.out.println("*Total amount paid: $" + df.format(salesPrice() + salesTax()));
            bag = new GroceryItem[5];
            size=0;
        }

    }
    /**
     * testbed main
     * Implements test cases specified in test document on each method
     * @param args, arguments
     */
	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("0.00");

		ShoppingBag myBag = new ShoppingBag();

		// Testing add() method on Fruit bag
		myBag.add(new GroceryItem("Mango", 1.5, false));// test cases for the parameterized Constructor
		myBag.add(new GroceryItem("Apple", 2.5, false));
		myBag.add(new GroceryItem("Orange", 3.5, true));

		if ((myBag.getCapacity() == 3))

		{
			System.out.println("Expected output: Mango and Apple and Orange added to myBag."); // test case for the
																								// add() method: true
																								// condition
		}

		else {
			System.out.println("Something wrong: Incorrect size of bag"); // test cases for the add() method: false
																			// condition
		}

		myBag.print(); // test case for the print() method
		System.out.println();

		if (myBag.find(new GroceryItem("Mango", 1.5, false)) >= 0)

		{
			System.out.println("Expected output: Item found!"); // test cases for find() method: true condition
		}

		else {
			System.out.println("Something wrong. Item not found!"); // test cases for find() method: false condition
		}

		myBag.remove(new GroceryItem("Mango", 1.5, false));

		if (myBag.getCapacity() == 2) {
			System.out.println("Excpected output: Item removed"); // test cases for remove() method : true condition
		} else {
			System.out.println("Something wrong. Item could not be removed."); // test cases for remove() method : False
																				// condition
		}
		myBag.print();
		System.out.println();

		Double saletotal = myBag.salesPrice();

		if (saletotal == 6.0) {

			System.out.println("Excpected output: Total is $" + saletotal);// test case for saleTotal ; true condition
		} else {
			System.out.println("Something Wrong. Wrong sale total value!"); // test case for saleTotal ; false condition
		}

		double d = myBag.salesTax();

		if (d != 0) {
			System.out.println("Expected output: Sales total is $" + df.format(d)); // test case for sale total : true
																						// condition
		} else {
			System.out.println("Something wrong: wrong sales Tax total!"); // test case for sale total : false condition
		}

		// test case for grow() method

		int a = myBag.bag.length;
		myBag.grow();
		if (a != myBag.bag.length) {
			System.out.println("Expected output: Grown bag."); // true condition
		} else {
			System.out.println("Something wrong: Same bag!"); // false condition
		}

		myBag.CheckOut();
		if (myBag.size == 0) {
			System.out.println("Expected output: bag checked out!");
		} else {
			System.out.println("Something went wrong with checkout!");
		}

    }

}