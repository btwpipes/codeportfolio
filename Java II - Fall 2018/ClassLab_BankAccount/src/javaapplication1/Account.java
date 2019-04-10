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

public class Account {
    //fields
    private String firstName;
    private String lastName;
    
    private int number;
    private double balance;
    
    AccountType type;
    
    //construction
    public Account(AccountType _type, String first, String last, int num)
    {
        type = _type;
        firstName = first;
        lastName = last;
        number = num;
        balance = 0;
    }
    
    //getters/setters
    public String getName()
    {
        return firstName + " " + lastName;
    }
    
    public int getAccountNumber()
    {
        return number;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public AccountType getAccountType()
    {
        return type;
    }
    
    public void setName(String first, String last)
    {
        firstName = first;
        lastName = last;
    }
    
    public void setBalance(double bal)
    {
        balance = bal;
    }
}
