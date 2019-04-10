/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;


public class Invoice {
    
    
    private int invoiceNumber;
    private double balanceDue;
    private int month;
    private int date;
    private int year;
    
    //constructor
    public Invoice(int invoiceNumber, double balanceDueAmount, int balanceDueMonth, int balanceDueDate, int balanceDueYear) {
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }
    
    public void setInvoiceNumber(int invoiceNumber) {
        if(invoiceNumber < 1000)
            this.invoiceNumber = 0;
        else
            this.invoiceNumber = invoiceNumber;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public void setBaancelDue(double balanceDueAmount) {
        this.balanceDue = balanceDueAmount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int balanceDueMonth) {
        if(balanceDueMonth < 1 || balanceDueMonth > 12)
            this.month = 0;
        else
            this.month = balanceDueMonth;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int balanceDueDate) {
        if(balanceDueDate < 1 || balanceDueDate > 31)
            this.date = 0;
        else
            this.date = balanceDueDate;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int balanceDueYear) {
        if(balanceDueYear < 2011 || balanceDueYear > 2017)
            this.month = 0;
        else
            this.year =balanceDueYear;
    }
    
}//end of class
