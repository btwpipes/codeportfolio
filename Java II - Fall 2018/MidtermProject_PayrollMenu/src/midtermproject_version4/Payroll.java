/************************************************************************
 * This class contains methods to calculate the employee payroll
 *
 * Author: Andre Paquette
 * Last modified: 10/10/18
 * Title: Payroll.java
 * Associated to: MidtermProject_version1.java
 ************************************************************************/

package midtermproject_version4;


public class Payroll {
    
    // Fields
    private static final double MANAGER_TAX_RATE = 0.25,
                                STAFF_TAX_RATE = 0.21,
                                FOUR01K_RATE = 0.05;
    private static final int WEEKS = 26,
                             HOURS = 80;
    private static double grossPay,
                          taxDeduction,
                          deduction401K;
    
    
    // Getters and Setters
    /** Getter for grossPay
     * @return the grossPay
     */
    public static double getGrossPay() 
    {
        return grossPay;
    }
    
    
    /** Setter for grossPay
     * @param emp
     */
    public static void setGrossPay(Employee emp) 
    {
        if (emp.getTitle().equalsIgnoreCase("Manager")) 
        {
            grossPay = emp.getPayRate() / WEEKS;
        } else {
            grossPay = emp.getPayRate() * HOURS;
        }
    }
    
    
    /** Getter for taxDeduction
     * @return the taxDeduction
     */
    public static double getTaxDeduction() 
    {
        return taxDeduction;
    }
    
    
    /** Setter for taxDeduction
     * @param emp
     */
    public static void setTaxDeduction(Employee emp) 
    {
        if (emp.getTitle().equalsIgnoreCase("Manager")) 
        {
                taxDeduction = grossPay * MANAGER_TAX_RATE;
        } else 
        {
                taxDeduction = grossPay * STAFF_TAX_RATE;
        }
    }
    
    
    /** Getter for 401K Deduction
     * @return the deduction401K
     */
    public static double get401kDeduction()
    {
        return deduction401K;
    }
    
    
    /** Setter for 401K Deduction
     * @param emp
     */
    public static void set401kDeduction(Employee emp) 
    {
        if (emp.getPensionParticipant()) 
        {
            deduction401K = grossPay * FOUR01K_RATE;
        } else
        {
            deduction401K = 0.0;
        }
    }
    
    
    /** Getter for netPay (grossPay - taxDeduction - deduction401K)
     * @return grossPay - taxDeduction - deduction401K
     */
    public static double getNetPay() 
    {
        return grossPay - taxDeduction - deduction401K;   
    }
    
    
}  // end of class
