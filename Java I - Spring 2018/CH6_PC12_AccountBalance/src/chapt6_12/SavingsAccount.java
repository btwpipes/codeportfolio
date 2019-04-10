/*
 * This program asks the user for account starting balance and interest rate, monthly deposits, and withdrawals
 * then calculates total deposits, total withdrawals, total interest earned, and account final balance by creating an object
 * Created by: Andre Paquette
 * Last modified: 3/31/18
 * lab 9_ch06-12 - SavingsAccount Class
 */
package chapt6_12;


public class SavingsAccount {

    //fields setting
    private final double annualInterestRate;
    private double balance;
    private double monthlyInterestEarned;
    private double totalDeposits;
    private double totalWithdrawals;
    private double totalInterestEarned;
    
    
    //CONSTRUCTORS
    
    //contructor with user starting balance and interest rate paramaters
    public SavingsAccount(double startingBalance, double interestRate)
    {
        balance = startingBalance;
        annualInterestRate = interestRate;
    }
    
    
    //SETTERS
    
    //setting and accumulating the monthly deposits
    public void deposit(double monthlyDeposit)
    {
        balance += monthlyDeposit;
        totalDeposits += monthlyDeposit; 
    }
    
    //setting and accumulating the monthly withdrawals
    public void withdrawal(double monthlyWithdrawal)
    {
        balance -= monthlyWithdrawal;
        totalWithdrawals += monthlyWithdrawal;
    }
   
    //setting and accumulating the monthly interest earned
    public void MonthlyInterestEarned()
    {
        monthlyInterestEarned = balance * (annualInterestRate / 12);   
        balance += monthlyInterestEarned;
        totalInterestEarned += monthlyInterestEarned;        
    }
    
    
    //GETTERS
    
    //getter returning ending balance
    public double getBalance()
    {
        return balance;
    }
    
    //getter returning the total of deposits
    public double getTotalDeposits()
    {
        return totalDeposits;
    }
    
    //getter returning the total of withdrawals
    public double getTotalWithdrawals()
    {
        return totalWithdrawals;
    }
    
    //getter returning the total of interest earned
    public double getTotalInterestEarned()
    {
        return totalInterestEarned;
    }
     
}//end of class