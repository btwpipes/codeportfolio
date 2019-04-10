/***************************************************************************
 * This class contains constructor, getters, setters for Item object
 *
 * Author: Andre Paquette
 * Last modified: 10/28/18
 * Associated to: Lab11_RestaurantMenu.java
 *************************************************************************/
package lab11_restaurantmenu;

import java.io.Serializable;


public class Item implements Serializable
{
    // Fields
    private String type;
    private String description;
    private double price;
    
    
    // Constructor
    public Item(String type, String description, double price)
    {
        this.type = type;
        this.description = description;
        this.price = price;
    }
    
    
    // GETTERS
    /** 
     * get type
     * @return type
    */
    public String getType()
    {
        return this.type;
    }
   
    /** 
     * get description
     * @return description
    */
    public String getDescription()
    {
        return this.description;
    }
    
    /** 
     * get price
     * @return price
    */
    public double getPrice()
    {
        return this.price;
    }
    
    
    // SETTERS
    /** 
     * set type
     * @param type
    */
    public void setType(String type)
    {
        this.type = type;
    }
    
    /** 
     * set description
     * @param description
    */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /** 
     * set name
     * @param price
    */
    public void setPrice(double price)
    {
        this.price = price;
    }
    
}  // end of class