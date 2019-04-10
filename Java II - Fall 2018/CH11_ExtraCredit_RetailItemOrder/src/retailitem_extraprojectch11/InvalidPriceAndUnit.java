/*******************************************************************************
 * This class throws exceptions if no value are passed to the constructor or
 * if the retail price and the unit number are negative.
 *
 * Author: Andre Paquette
 * Last modified: 09/24/18
 * Title: Lab6 - Chapter 11 Exercise 3 - Retail Item Exceptions
 * Associated to: Lab6_ch11_ex3_RetailItemExceptions.java 
 *******************************************************************************/
package retailitem_extraprojectch11;


public class InvalidPriceAndUnit extends Exception {
   
    // Exception if price and unit are invalid
    public InvalidPriceAndUnit(double price, int unit)
    {
        super("ERROR. You entered a negative price and a negative number of units.\n" +
              "The price entered: " + price + "   The unit entered: " + unit);
    }
            
    
}
