/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author rburley
 */
public class Bank 
{
    //static fields
    private static int nextAccountNumber = 1001;
    private static Account[] accounts = new Account[10];
    
    public static int createAccount(AccountType type, String fName, String lName)
    {
        Account newAccount = new Account(type, fName, lName, nextAccountNumber++);
        
        for(int i=0; i < accounts.length; i++)
        {
            if(accounts[i] == null)
            {
                accounts[i] = newAccount;
                break;
            }
        }
        
        return newAccount.getAccountNumber();
    }
    
    private static Account getAccount(int acctNum)
    {
        Account acct = null;
        
        for(int i=0; i < accounts.length; i++)
        {
            if(accounts[i].getAccountNumber() == acctNum)
            {
                acct = accounts[i];
                break;
            }
        }
        
        return acct;
    }
    
    private static String getAccountInfo(Account acct)
    {
        String info = acct.getName() 
         + "\nAccount Number: " + acct.getAccountNumber()
         + "\nAccount Type: " + acct.getAccountType() 
         + "\n\nCurrent Balance: " + acct.getBalance();
        
        return info;
    }
    
    public static double getBalance(int acctNum)
    {
        return getAccount(acctNum).getBalance();
    }
    
    public static void withdrawFunds(int acctNum, double amt)
    {
        if(getAccount(acctNum).getBalance() < amt) return;
        
        double newBal = getAccount(acctNum).getBalance() - amt;
        getAccount(acctNum).setBalance(newBal);
        
        System.out.println(getAccountInfo(getAccount(acctNum)) );
    }
    
    public static void depositFunds(int acctNum, double amt)
    {
        double newBal = getAccount(acctNum).getBalance() + amt;
        getAccount(acctNum).setBalance(newBal);
        
        System.out.println(getAccountInfo(getAccount(acctNum)) );
    }
    
}
