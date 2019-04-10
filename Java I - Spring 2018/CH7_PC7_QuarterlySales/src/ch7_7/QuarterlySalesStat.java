/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch7_7;
import java.util.*;

public class QuarterlySalesStat {

    
    public static void main(String[] args) {
        
        //variables
        double amount;
        double[] divisionSales = new double[6];
        double[] quarterlyTotal = new double[4];
        
        
        //creating object scanner to get user data
        Scanner keyboard = new Scanner(System.in);
        
        //creating object sales
        Sales divisions = new Sales();
        
        //Greeting message and program explanation to user
        System.out.println("Hello! After you enter the sales values from each quarters " + 
                "for the\ncompany's divisions; I will execute calculations and display the results.");
        System.out.println("----------------------------------------------------------------------------");
        
                
        //nested for loop to get sales from user and fill array
        System.out.println("Please enter the requested sales values.");
        for (int div = 0; div < divisions.rowSize(); div++)
        {
            for (int qtr = 0; qtr < divisions.columnSize(); qtr++)
            {
                System.out.printf("Division %d, Quarter %d: $", (div+1), (qtr+1));
                amount = keyboard.nextDouble();
                   if (amount < 0)
                   {
                       amount = 0;
                   }
                divisions.setSales(div, qtr, amount);
            }
        }
        
        
        //display division sales per quarters
        System.out.println("--------------------------------------------------------------------------------------");
        for (int div = 0; div < divisions.rowSize(); div++)
        {
            System.out.print("Divsion " + (div + 1));
            for (int qtr = 0; qtr < divisions.columnSize(); qtr++)
            {
                System.out.print("  Quarter " + (qtr + 1) + ": $" + String.format("%,.2f", divisions.getSales(div, qtr)));
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------");
        

        //yearly sales per division
        System.out.println("Here are the yearly sales per divisions.");
        for (int div = 0; div < divisions.rowSize(); div++) {
            double divisionTotal = 0;
            for (int qtr = 0; qtr < divisions.columnSize(); qtr++) {
                divisionTotal += divisions.getSales(div, qtr);
            }
            System.out.println("Division " + (div + 1) + String.format(": $%,.2f", divisionTotal));
        }
        System.out.println("-------------------------------------------------------------");
        

        //division quarters increase or decrease
        System.out.println("Here are the divisions' quarters differences.");
        double quarterlyDifference;
        for (int qtr = 1; qtr < divisions.columnSize(); qtr++) {
            for (int div = 0; div < divisions.rowSize(); div++) {
                quarterlyDifference = divisions.getQuarterlyIncrease(div, qtr) - divisions.getQuarterlyIncrease(div, qtr-1);
                System.out.println("Division " + (div + 1) + ": Quarter " + (qtr + 1) + " - Quarter " + (qtr) + String.format(": $%,.2f", quarterlyDifference));
            }
            System.out.println("-------------------------------------------------------------");
        }
        
        /*
        //company total quarterly sales 
        System.out.println("Here are the company's quarterly sales.");
        for (int quarter = 0; quarter < divisions.columnSize(); quarter++) {
            divisions.totalQuarterSales(quarter);
            System.out.println("Quarter " + (quarter + 1) + String.format(": $%,.2f", quarterlyTotal[quarter]));
        }
        System.out.println("-------------------------------------------------------------");
        */
         
        //company total quarterly sales 
        System.out.println("Here are the company's quarterly sales.");
        for (int qtr = 0; qtr < divisions.columnSize(); qtr++) {
            for (int div = 0; div < divisions.rowSize(); div++) {
                quarterlyTotal[qtr] += divisions.getSales(div, qtr);
            }
            System.out.println("Quarter " + (qtr + 1) + String.format(": $%,.2f", quarterlyTotal[qtr]));
        }
        System.out.println("-------------------------------------------------------------");
        
        //company quarters increase or decrease
        System.out.println("Here are the company's quarters differences.");
        double companyQtrDifference = 0;
        for (int qtr = 1; qtr < divisions.columnSize(); qtr++)
        {
            for (int div = 0; div < divisions.rowSize(); div++)
            {
                companyQtrDifference = quarterlyTotal[qtr] - quarterlyTotal[qtr - 1];
            }
            System.out.println("Quarter " + (qtr + 1) + " - Quarter " + (qtr) + String.format(": $%,.2f", companyQtrDifference));
        }
        System.out.println("-------------------------------------------------------------");
        
        //company quarter sales average
        System.out.println("Here are the company's quarters average.");
        double companyQtrAverage = 0;
        for (int qtr = 0; qtr < divisions.columnSize(); qtr++)
        {
            for (int div = 0; div < divisions.rowSize(); div++)
            {
                companyQtrAverage = quarterlyTotal[qtr] / 6;
            }
            System.out.println("Average for quarter " + (qtr) + String.format(": $%,.2f", companyQtrAverage));
        }
        System.out.println("-------------------------------------------------------------");
        
        
        //Finding highest sales
        double highestSale = 0;
        int division = 0;
        int quarter = 0;
        for (int div = 0; div < divisions.rowSize(); div++)
        {
            for (int qtr = 0; qtr < divisions.columnSize(); qtr++)
            {
                if (divisions.divisionSales[div][qtr] > highestSale)
                {
                    highestSale = divisions.divisionSales[div][qtr];
                    division = div + 1;
                    quarter = qtr + 1;
                }

            }
        }
        System.out.println("Division " + division + " has the highest sale of" + String.format(": $%,.2f", highestSale) + " in quarter " + quarter + ".");
 
        
    }//end of class
        
}//end of program
