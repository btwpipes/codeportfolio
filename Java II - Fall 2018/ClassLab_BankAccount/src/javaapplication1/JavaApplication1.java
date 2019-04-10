package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author burley
 */
public class JavaApplication1 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        //get user input
        System.out.print("Enter your first name > ");
        String fname = input.next();

        System.out.print("Enter your last name > ");
        String lname = input.next();
        
        System.out.print("Enter 1 for checking or 2 for savings > ");
        int selection = input.nextInt();
        
        AccountType type;
        
        if(selection == 1)
            type = AccountType.Checking;
        else
            type = AccountType.Savings;
        
        //create account
        int myAcctNumber = Bank.createAccount(type, fname, lname);
        
        //do account stuff
        System.out.println("How much to you want to withdraw? ");
        double userInput = input.nextDouble();
        
        Bank.depositFunds(myAcctNumber, 1000.00);
        Bank.withdrawFunds(myAcctNumber, userInput);
    }
    
}
