/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retailitem_extraprojectch11;

import java.util.*;


public class RetailItem_ExtraProjectCh11 {


    public static void main(String[] args) {
        
        // Fields
        int upc = 0,
            unit;
        double price;
        
        // create Scanner object to capture userInput
        Scanner userInput = new Scanner(System.in);

        
        // create shirt1 object without any values
        RetailItem shirt1 = new ShirtItem();
        
        // try/catch block for user input
        try {        
            // Prompt user to input values
            // capture upc entered
            System.out.println("Please enter a UPC number for the item: ");
            upc = userInput.nextInt();
            shirt1.setItemUPC(upc);
        
            // capture item price
            System.out.println("Please enter the item price: ");
            price = userInput.nextDouble();
            shirt1.setItemPrice(price);
        
            // capture unit amount
            System.out.println("Please enter the number of units: ");
            unit = userInput.nextInt();
            shirt1.setItemUnitAmount(unit);
        }
        // Exception that catches invalid price
        catch(InvalidPrice error1)
        {
            System.out.println(error1.getMessage());
        }
        // Exception that catches invalid unit
        catch(InvalidUnit error2)
        {
            System.out.println(error2.getMessage());
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid entry. The values entered must be numbers.");
        }
        
        
        // line separator
        System.out.println("----------------------------------------------");
        
        // display shirt1 values to the user
        System.out.println("UPC code: " + shirt1.getItemUPC());
        System.out.println("Price: " + String.format("$%.2f", shirt1.getItemPrice()));
        System.out.println("Number of Units: " + shirt1.getItemUnitAmount());
        
        // line separator
        System.out.println("---------------------------------------------");
        

        // ShirtItem object created inside try/catch blocks
        try
        {
            // Create ShirtItem object. Must have valid price and unit (greater than 0)
            // Argument(s) determine if exception gets thrown
            RetailItem shirt2 = new ShirtItem(10009, 97.65, 45);
            
            // display shirt2 values
            System.out.println("UPC code: " + shirt2.getItemUPC());
            System.out.println("Price: " + String.format("$%.2f", shirt2.getItemPrice()));
            System.out.println("Number of Units: " + shirt2.getItemUnitAmount());
        }
        // Exception that catches invalid price
        catch(InvalidPrice error1)
        {
            System.out.println(error1.getMessage());
        }
        // Exception that catches invalid unit
        catch(InvalidUnit error2)
        {
            System.out.println(error2.getMessage());
        }
        // Exception that catches invalid price & unit
        catch(InvalidPriceAndUnit error3)
        {
            System.out.println(error3.getMessage());
        }
        
        
    }  //end of main
    
}  // end of program
