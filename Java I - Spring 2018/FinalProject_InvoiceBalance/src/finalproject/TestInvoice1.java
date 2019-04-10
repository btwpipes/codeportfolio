/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import java.util.*;

public class TestInvoice1 {


    public static void main(String[] args) {
        
        //variables
        int invoiceNumber;
        int balanceDueMonth;
        int balanceDueDate;
        int balanceDueYear;
        double balanceDueAmount;
        
        //creating scanner object to capture user entry
        Scanner keyboard = new Scanner(System.in);
        
        
        //prompt user to enter invoice number
        System.out.print("Please type your invoice number (greater than 1000): ");
            invoiceNumber = keyboard.nextInt();
        
        //prompt user to enter balance due month
        System.out.print("Please enter the balance due's month(between 1-12): ");
            balanceDueMonth = keyboard.nextInt();
            
        //prompt user to enter balance due date   
        System.out.print("Please enter the balance due's date (between 1-31): ");
            balanceDueDate = keyboard.nextInt();
            
        //prompt user to enter balance due year    
        System.out.print("Please enter the balance due's year (between 2013-2019): ");
            balanceDueYear = keyboard.nextInt();
            
        //prompt user to enter balance due year    
        System.out.print("What is the balance due? ");
            balanceDueAmount = keyboard.nextDouble();

        if((invoiceNumber >= 1000) && (balanceDueMonth <= 12 && balanceDueDate <= 31 && balanceDueYear >= 2013) && balanceDueYear <= 2019)
        {
            System.out.print("Invoice number: " + invoiceNumber + " has a balance of: " + balanceDueAmount +
                    "and is due on: " +balanceDueMonth + "/" + balanceDueDate + "/" + balanceDueYear);
        } else if(invoiceNumber <= 1000)
        {
                System.out.println("Invalid invoice number. Must be greater or equal to 1000.");
        } else if (balanceDueMonth < 1 || balanceDueMonth > 12)
        {
            System.out.println("Invalid month. Month must be between 1 and 12.");
        } else if (balanceDueDate < 1 || balanceDueDate > 31)
        {
            System.out.println("Invalid date. Date must be between 1 and 31");
        } else if (balanceDueYear < 2013 || balanceDueYear > 2019)
        {
            System.out.println("Invalid year. Year must be between 2013 and 2019.");
        } else
        {
            System.out.println("Error!");
        }
                    
        
        //creating invoice object
        Invoice invoice01 = new Invoice (invoiceNumber, balanceDueAmount, balanceDueMonth, balanceDueDate, balanceDueYear);
        
  
                    
    } //end of class
    
} //end of program
