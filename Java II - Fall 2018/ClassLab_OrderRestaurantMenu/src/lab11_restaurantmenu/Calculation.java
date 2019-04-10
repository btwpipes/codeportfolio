/***************************************************************************
 * This class calculates the subtotal, sales tax, gratuity and total
 *
 * Author: Andre Paquette
 * Last modified: 10/28/18
 * Associated to: Lab11_RestaurantMenu.java
 *************************************************************************/
package lab11_restaurantmenu;

import javafx.scene.control.TextField;


public class Calculation {
    
    // Fields
    static double subtotal;
    
    /**
     * calculate subtotal
     *
     *@param f1
     *@param f2
     *@param f3
     *@param f4
    */
    public static void subTotal(TextField f1, TextField f2, TextField f3, TextField f4)
    {
        subtotal = Double.parseDouble(f1.getText()) + Double.parseDouble(f2.getText()) +
                   Double.parseDouble(f3.getText()) + Double.parseDouble(f4.getText());        
    }
    
    /**
     * calculate the sales tax on subtotal
     *
     *@return subtotal * 6%
    */
    public static double salesTax()
    {
        return subtotal * .06;
    }
    
    /**
     * calculate the gratuity on subtotal
     *
     *@return subtotal * 3%
    */
    public static double gratuity()
    {
        return subtotal * .03;
    }
    
    /**
     * calculate grand total
     *
     *@return subtotal + salesTax() + gratuity()
    */
    public static double total()
    {
        return subtotal + salesTax() + gratuity();
    }

}  // end of Calculation class
