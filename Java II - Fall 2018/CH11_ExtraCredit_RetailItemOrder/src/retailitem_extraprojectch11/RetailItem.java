/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retailitem_extraprojectch11;


public interface RetailItem {
    
    void setItemUPC(int upc);
    
    void setItemPrice(double price) throws InvalidPrice;
   
    void setItemUnitAmount(int unit) throws InvalidUnit;

    int getItemUPC();
    
    double getItemPrice();
    
    int getItemUnitAmount();
    
}
