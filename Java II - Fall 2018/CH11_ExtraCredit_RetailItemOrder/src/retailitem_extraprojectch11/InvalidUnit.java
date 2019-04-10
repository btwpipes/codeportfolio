/*******************************************************************
 * This class throws an exception if the unit number is negative
 *
 * Author: Andre Paquette
 * Last modified: 09/24/18
 * Title: Lab6 - Chapter 11 Exercise 3 - Unit Amount Exceptions
 * Associated to: Lab6_ch11_ex3_RetailItemExceptions.java 
 *******************************************************************/
package retailitem_extraprojectch11;


public class InvalidUnit extends Exception{
    
    
    // Exception message if unit is invalid
    public InvalidUnit(int unit)
    {
        super("ERROR. You entered a negative number of units. You entered: " + unit);
    }
    
    
}  // end of class
