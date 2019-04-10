/***************************************************************************
 * This program simulates a luxury car dealership website. The user 
 * can filter the cars displayed in the the window. Clicking the car tile
 * opens another that display the clicked car specifications. The user has
 * the option to purchase the car. Clicking the purchase button opens a
 * window to hold the user's data.
 *
 * Author: Andre Paquette
 * Last modified: 11/27/18
 * Title: Final Project - Car Dealership
 *************************************************************************/
package cist2372_finalproject_cardealership;


public class Purchase
{
    
    // FIELDS
    private static double purchasePrice;
    
    final static private double DESTINATION_FEES = 0.01,  // Destination fee = 1% of purchase price 
                                SALES_TAX = .12;          // sales tax = 12% of purchase price
   

    // CONSTRUCTORS
    // single parameter constructor
    public Purchase(double price)
    {
        purchasePrice = price;
    }
    
    // no-arg constructor
    public Purchase(){}

    // GETTERS and SETTERS
    /**
     * @return the purchasePrice
     */
    public static double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * @param price the purchasePrice to set
     */
    public static void setPurchasePrice(double price) {
        purchasePrice = price;
    }

    /**
     * @return the purchaseTotal
     */
    public static double getPurchaseTotal() {
        return purchasePrice + (purchasePrice * SALES_TAX) + (purchasePrice * DESTINATION_FEES);
    }

    /**
     * @return the DESTINATION_FEES
     */
    public static double getDestinationFees() {
        return purchasePrice * DESTINATION_FEES;
    }

    /**
     * @return the SALES_TAX
     */
    public static double getSalesTax() {
        return purchasePrice * SALES_TAX;
    }
    
    
}  // end of class
