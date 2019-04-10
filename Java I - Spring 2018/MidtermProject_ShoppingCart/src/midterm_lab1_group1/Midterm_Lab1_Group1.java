/*
 * This program calculates an order total using a switch case
 * created by: A. Paquette, T. Butler, X. Luo, B. Diegel, A. Lawson, M. Dani
 * Midterm Project Lab 1 - Group 1
 * Last modified: 02/25/18
 */
package midterm_lab1_group1;
import java.util.*; //importing java utilities library

public class Midterm_Lab1_Group1 {

    public static void main(String[] args) {
        
        //variables declaration and assignment
        String again = "Y";
        int productNum, quantity;
        double price = 0.0, totalOrder = 0.0;
        
        Scanner keyboard = new Scanner(System.in); //create scanner keyboard for input
        
        System.out.println("Hello, I will calculate the total price of your order.");  //display welcoming message to user
        
        while (again.equals("Y")) {  //sentinel-controlled loop
        
            do { //loop to get product number from user
                System.out.print(" \nPlease enter the product# you would like to order (between 1-5): ");
                    productNum = keyboard.nextInt();
                        if (productNum < 1 || productNum > 5) { // validates user entry (greater than 1)
                            System.out.println("Invalid entry. Please enter a number between 1 and 5."); //prompt user to enter valid entry
                        }                                        
            } while (productNum < 1 || productNum > 5); //iterates as long as user does not enter number between 1-5
            
            //prompt to user to get order values
            do {  //loop to get quantity of product from user
                System.out.print(" \nPlease enter the quantity you would like to order: ");  
                    quantity = keyboard.nextInt();
                        if (quantity < 1) { //validates user entry (greater than 1)
                            System.out.println("Invalid entry. Please enter a quantity of at least 1."); //prompt user to enter valid entry
                        }                                  
            } while (quantity < 1);  //iterates as long as user does not enter a value of 1 or greater
            
            switch(productNum){ //switch case to determine the product's price
                case 1:
                    price = 2.98;
                    break;
                case 2:
                    price = 4.50;
                    break;                    
                case 3:
                    price = 9.98;
                    break;
                case 4:
                    price = 4.49;
                    break;
                case 5:
                    price = 6.87;
                    break;
            } //end of switch
            
            //order total calculation using accumulator
            totalOrder = totalOrder + (price * quantity);
            
            //display cart total and prompt user for entry to continue shopping (sentinel)
            System.out.println("---------------------------------------------------------------------------------");
            System.out.printf("The total amount in your cart is: $%,.2f \n", totalOrder);
            System.out.print("Would you like to continue shopping? Enter Y or y for YES " + 
                    "any other key for NO: ");
                again = keyboard.next().toUpperCase();
 
        } //end of initial while loop
        
        //final displays to the user; order total and thanks
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("You order comes to a total of: $%,.2f \n" + 
                "Thank you for your order! \n", totalOrder);

    } //end of main
    
} //end of class
