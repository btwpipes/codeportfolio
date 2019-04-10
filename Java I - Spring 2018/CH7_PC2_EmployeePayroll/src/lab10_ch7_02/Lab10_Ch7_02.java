/*
 * This program asks the user for employee's hours, pay rate and calculates the employee's gross pay
 * Created by: Andre Paquette
 * Last modified: 4/06/18
 * lab 10_ch07-02 - Payroll class
 */

package lab10_ch7_02;
import java.util.*;

public class Lab10_Ch7_02 {

    public static void assignEmployeeHoursAndPayrates(PayrollClass payrollObject)
    {
        Scanner keyboard = new Scanner(System.in);
        double employeeHours;
        double employeePayRate;
        
        for (int i = 0; i < payrollObject.getAllEmployeeIds().length; i++)
        {
            System.out.print("Please enter the hours for employee " + payrollObject.getAllEmployeeIds()[i] + ": ");
                employeeHours = keyboard.nextDouble();
                    if (employeeHours < 0)
                    {
                        System.out.println("Invalid entry. The hours value must be greater than 0.");
                        System.out.print("Please re-enter the hours this employee: ");
                            employeeHours = keyboard.nextDouble();
                    }
            payrollObject.setEmployeeHours(employeeHours, i);
            
            System.out.print("Please enter the pay rate for employee " + payrollObject.getAllEmployeeIds()[i] + ": ");
                employeePayRate = keyboard.nextDouble();
                    if (employeePayRate < 6.0)
                    {
                        System.out.println("Invalid entry. The pay rate value must be equal or greater than 6.");
                        System.out.print("Please re-enter the pay rate this employee: ");
                            employeePayRate = keyboard.nextDouble();
                    }
            payrollObject.setEmployeePayRate(employeePayRate, i);
            
            System.out.println("----------------------------------------------------------");
        }
    }
    
    public static void displayEmployeeWages(PayrollClass payrollObject){
        
        for (int i = 0; i < payrollObject.getAllEmployeeIds().length; i++)
        {
            System.out.println("EMPLOYEE ID: " + payrollObject.getAllEmployeeIds()[i] +
                    "\t GROSS PAY: " + String.format("$%,.2f", payrollObject.getAllEmployeeWages()[i]));
            System.out.println("");

        }
    
    }
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        PayrollClass employeeInfo = new PayrollClass();
        
        assignEmployeeHoursAndPayrates(employeeInfo);
        
        employeeInfo.calculateWages();
        
        displayEmployeeWages(employeeInfo);
        
        /*
        final int SIZE = 7;
        double[] userHours;
        double[] userPayrate;
        
        
        //user greeting
        System.out.println("Hello. I will calculate the gross pay for your 7 employees.");
        System.out.println("---------------------------------------------------------------");
        
        Payroll payroll = new Payroll(userHours, userPayrate);

        
        //setting hours and pay rate for each employees
        for (int i = 0; i < SIZE; i++)
        {
            System.out.print("Please enter the hours for employee# " + (i + 1) + ": ");
                userHours = keyboard.nextDouble();
                    
                    if (keyboard.nextDouble() < 0.0)
                    {
                        System.out.println("Invalid entry. The hours entered must be 0 or greater.");
                        System.out.print("Please re-enter the hours for employee# " + (i + 1) + ": ");
                            userHours = keyboard.nextDouble();
                    }
                    
            payroll.setHours(userHours);
                    
            System.out.print("Please enter the pay rate for employee# " + (i + 1) + ": ");
                userPayrate = keyboard.nextDouble();
                
                    if (keyboard.n"Please enter the pay rate for employee# " + (i + 1) + ": "extDouble() < 6.0)
                    {
                        System.out.println("Invalid entry. The pay rate entered must be equal or greater than 6.");
                        System.out.print("Please enter the pay rate for employee# " + (i + 1) + ": ");
                            hours[i] = keyboard.nextDouble();
                    }
                    
            //Payroll.wages[i] = Payroll.hours[i] * Payroll.payRate[i];
        }
        
        
        //Payroll payroll = new Payroll();

        
        System.out.println("---------------------------------------------------------------");
        System.out.println("Here are the gross pay per employees.");
        
        for (int i = 0; i < Payroll.SIZE; i++)
        {
            System.out.println(Payroll.employeeID[i] + ": " + Payroll.wages[i])
        }
        */


    }//end of class
    
}//end of program
