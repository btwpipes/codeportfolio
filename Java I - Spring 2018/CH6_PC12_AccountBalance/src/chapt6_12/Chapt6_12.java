/*
 * This program asks the user for account starting balance and interest rate, monthly deposits, and withdrawals
 * then calculates total deposits, total withdrawals, total interest earned, and account final balance by creating an object
 * Created by: Andre Paquette
 * Last modified: 3/31/18
 * lab 9_ch06-12 - SavingsAccount Class
 */
package chapt6_12;
import java.util.*;  //wildcard importing java utilitites

public class Chapt6_12 {

    
    public static void main(String[] args) {
        
        //creating Scanner object to save user inputs
        Scanner keyboard = new Scanner(System.in);
        
        
        //variables declaration and assignment
        int numberOfMonths;
        double interestRate;
        double startingBalance;
        double monthlyDeposit;
        double monthlyWithdrawal;        


        //greeting message to user
        System.out.println("Welcome! I will calculate your account balance");
        System.out.println("-----------------------------------------------------------------------");
        
        
        //prompting user for account intial values
        System.out.print("Please enter the starting balance of the account: ");
            startingBalance = keyboard.nextDouble();
                //user value validation
                while (startingBalance < 0)
                {
                    System.out.println("Invalid entry. Your starting balance must be equal or greater than 0");
                    System.out.print("Please re-enter the starting balance of the account: ");
                    startingBalance = keyboard.nextDouble();
                }
        
        System.out.print("Please enter the annual interest rate (Example: For 3.5% enter 3.5): ");
            interestRate = keyboard.nextDouble() / 100;  // setting interest rate as decimal percentage
                //user value validation
                while (interestRate < 0 || interestRate > 1)
                {
                    System.out.println("Invalid entry. The interest must be equal or greater than 0 and smaller than 100");
                    System.out.print("Please re-enter the annual interest rate (Example: For 3.5% enter 3.5): ");
                    interestRate = keyboard.nextDouble() / 100;
                }
        
        System.out.print("Please enter the number of months this account has been opened: ");
            numberOfMonths = keyboard.nextInt();
                //user value validation
                while (numberOfMonths < 1)
                {
                    System.out.println("Invalid entry. Your starting balance must be equal or greater than 1");
                    System.out.print("Please re-enter the number of months this account has been opened: ");
                    numberOfMonths = keyboard.nextInt();
                }
        
        System.out.println("-----------------------------------------------------------------------");
        
        
        //creation of object SavingsAccount
        SavingsAccount account1 = new SavingsAccount(startingBalance, interestRate);
        
        
        //loop to ask user for deposit and withdrawal amounts for specific number of month entered by user
        for (int i = 1; i <= numberOfMonths; i++)
        {
            //prompting user for monthly deposit value
            System.out.print("Please enter the deposit amount for month " + i + ": ");
            monthlyDeposit = keyboard.nextDouble();
                //user value validation
                while (monthlyDeposit < 0)
                {
                    System.out.println("Invalid entry. The deposit must be equal or greater than 0");
                    System.out.print("Please re-enter the deposit for month " + i + ": ");
                    monthlyDeposit = keyboard.nextDouble();
                }
            account1.deposit(monthlyDeposit);  //calling class method to calculate balance and total deposits
            
            //prompting user for monthly withdrawal value
            System.out.print("Please enter the withdraw amount for month " + i + ": ");
            monthlyWithdrawal = keyboard.nextDouble();
                //user value validation
                while (monthlyWithdrawal < 0)
                {
                    System.out.println("Invalid entry. The withdrawal amount must be equal or greater than 0");
                    System.out.print("Please re-enter the withdrawal amount for month " + i + ": ");
                    monthlyWithdrawal = keyboard.nextDouble();
                }
            account1.withdrawal(monthlyWithdrawal);  //calling class method to calculate balance and total withdrawals
            
            //conditional interest calculation. if balance is 0 skip interest calculation
            if (account1.getBalance() >= 0)
            {
                //calling class method to acculate monthly and total interest earned
                account1.MonthlyInterestEarned();
            }
        }
        
        
        //display final values to the user
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Here are the amounts at the end of " + numberOfMonths + " month(s):");
        System.out.printf("Total amount of deposits: $%,.2f\n", account1.getTotalDeposits());
        System.out.printf("Total amount of withdrawals: $%,.2f\n", account1.getTotalWithdrawals());
        System.out.printf("Total amount of interest earned: $%,.2f\n", account1.getTotalInterestEarned());
        System.out.printf("Making your final account balance: $%,.2f\n", account1.getBalance());
        
    }//end of class
    
}//end of program
