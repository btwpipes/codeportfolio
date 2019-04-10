/********************************************************************
 * This class throws an exception if the retail price is negative
 *
 * Author: Andre Paquette
 * Last modified: 09/24/18
 * Title: Lab6 - Chapter 11 Exercise 3 - Retail Item Exceptions
 * Associated to: Lab6_ch11_ex3_RetailItemExceptions.java 
 *******************************************************************/
package retailitem_extraprojectch11;


public class InvalidPrice extends Exception {
    
    
    // Exception message if price is invalid
    public InvalidPrice(double price)
    {
        super("ERROR. You entered a negative price. You entered: " + price);
    }
    
}
