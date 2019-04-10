/*
 * This program asks the user for employee's hours, pay rate and calculates the employee's gross pay
 * Created by: Andre Paquette
 * Last modified: 4/06/18
 * lab 10_ch07-02 - Payroll class
 */

package lab10_ch7_02;


public class PayrollClass {
    
    //fields
    private int[] employeeId = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
    private final int NUMBER_OF_EMPLOYEES = employeeId.length;
    private double[] hours;
    private double[] payRate;
    private double[] wages;

    
    //constructor
    public PayrollClass ()
    {
        hours = new double[NUMBER_OF_EMPLOYEES];
        payRate = new double[NUMBER_OF_EMPLOYEES];
        wages = new double[NUMBER_OF_EMPLOYEES];
    }
            
    
    //SETTERS
    
    //setting employees hours from user value
    public void setEmployeeHours(double employeeHoursGiven, int employeeIndexGiven)
    {
        hours[employeeIndexGiven] = employeeHoursGiven;
    }
    //setting employees pay rate from user value
    public void setEmployeePayRate(double employeePayRateGiven, int employeeIndexGiven)
    {
        payRate[employeeIndexGiven] = employeePayRateGiven;
    }
    
    
    //GETTERS
    
    //getting employee Ids
    public int[] getAllEmployeeIds()
    {
        return employeeId;
    }
    
    //getting employees hours
    public double[] getAllEmployeeHours()
    {
        return hours;
    }
    
    //getting employees pay rates
    public double[] getAllEmployeePayRates()
    {
        return payRate;
    }
    
    //getting employees wages
    public double[] getAllEmployeeWages()
    {
        return wages;
    }
    
    
    //INSTANCE METHODS
    
    //method that calculates each employees' gross pay and stores the value in array
    public void calculateWages()
    {
        for (int i = 0; i < NUMBER_OF_EMPLOYEES; i++)
        {
            wages[i] = hours[i] * payRate[i]; 
        }
    }
    
    //method returning employee's wage if employeeId provided matches employeeId in array
    public double getWagesByID(int employeeIdGiven)
    {
        for (int i = 0; i < NUMBER_OF_EMPLOYEES; i++)
            if (employeeId[i] == employeeIdGiven)
            {
                return wages[i];
            }
        
        return -1;
    }
    
}//end of class
