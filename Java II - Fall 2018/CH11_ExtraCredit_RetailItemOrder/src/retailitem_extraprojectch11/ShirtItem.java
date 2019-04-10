/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retailitem_extraprojectch11;


public class ShirtItem implements RetailItem {
    
    // Fields
    private int itemUPC;
    private double itemPrice;
    private int itemUnitAmount;
    
    
    // Constructors
    // 3 arguments constructor
    public ShirtItem(int upc, double price, int unit) throws InvalidPrice,
                                                             InvalidUnit,
                                                             InvalidPriceAndUnit
    {
        // throws exceptions based on invalid values
        if (price < 0 && unit < 0) { throw new InvalidPriceAndUnit(price, unit); }
        if (price < 0) { throw new InvalidPrice(price); }
        if (unit < 0) { throw new InvalidUnit(unit);}
        
        // assigns values and create object
        itemUPC = upc;
        itemPrice = price;
        itemUnitAmount = unit;
    }
    
    // no arg constructor
    public ShirtItem()
    {
    }
    
    @Override
    public void setItemUPC(int upc)
    {
        itemUPC = upc;
    }
    
    @Override
    public void setItemPrice(double price) throws InvalidPrice
    {
        if (price < 0)
        {
            throw new InvalidPrice(price);
        } else
        {
            itemPrice = price;
        }
    }
    
    @Override
    public void setItemUnitAmount(int unit) throws InvalidUnit
    {
        if (unit < 0)
        {
            throw new InvalidUnit(unit);
        } else
        {
            itemUnitAmount = unit;
        }
    }
    
    @Override
    public int getItemUPC()
    {
        return itemUPC;
    }
    
    @Override
    public double getItemPrice()
    {
        return itemPrice;
    }
    
    @Override
    public int getItemUnitAmount()
    {
        return itemUnitAmount;
    }
    
} //end of class
