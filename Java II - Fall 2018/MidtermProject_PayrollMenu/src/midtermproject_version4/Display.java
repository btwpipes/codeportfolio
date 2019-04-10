/***************************************************
 * This class contains displays to the user
 *
 * Author: Andre Paquette
 * Last modified: 10/10/18
 * Title: Display.java
 * Associated to: MidtermProject_version1.java
 ***************************************************/

package midtermproject_version4;


import javax.swing.JOptionPane;


public class Display {
    
    
    public static void nameOfAllEmployees(Employee emp)
    {
        System.out.println(emp.getFullName());            
    }
    
    
    /** Method to display categories title 
     * 
     */
    public static void categoriesTitle()
    {
        System.out.println("Department:\t Name:\t\t   Title:\tPay Rate:\t  Gross Pay:\t   " +
                           "Tax Deduction:\t401K Deduction:\t   Net Pay:");
        System.out.println("-------------------------------------------------" +
                           "-------------------------------------------------" +
                           "--------------------------------------");
    }
    
    
    /** Method to display payroll results for all employees 
     * 
     * @param emp
     */    
    public static void allEmployeesDisplay(Employee emp)
    {
        System.out.println(emp.getDepartment()+ "\t\t " + 
                emp.getFullName() + "\t   " +
                emp.getTitle() + " \t" + 
                String.format("$%,.2f", emp.getPayRate()) + "   \t  " +
                String.format("$%,.2f", Payroll.getGrossPay()) + "\t   " +
                String.format("$%,.2f", Payroll.getTaxDeduction()) + "\t\t" +
                String.format("$%,.2f", Payroll.get401kDeduction()) + "\t\t   " + 
                String.format("$%,.2f", Payroll.getNetPay()));
        
    }
    

    /** Method to display payroll results for all managers 
     * 
     * @param emp
     */    
    public static void allManagersDisplay(Employee emp)
    {
        if (emp.getTitle().equalsIgnoreCase("manager"))
            System.out.println(emp.getDepartment() + "\t\t " + 
                    emp.getFullName() + "\t   " + 
                    emp.getTitle() + "\t" + 
                    String.format("$%,.2f", emp.getPayRate()) + "\t  " +
                    String.format("$%,.2f", Payroll.getGrossPay()) + "\t   " +
                    String.format("$%,.2f", Payroll.getTaxDeduction()) + "\t\t" +
                    String.format("$%,.2f", Payroll.get401kDeduction()) + "\t\t   " + 
                    String.format("$%,.2f", Payroll.getNetPay()));
    }
   
    
    /** Method to display payroll results for all staff 
     *
     * @param emp
     */    
    public static void allStaffDisplay(Employee emp)
    {
        if (!emp.getTitle().equalsIgnoreCase("manager"))
        System.out.println(emp.getDepartment() + "\t\t " + 
                emp.getFullName() + "\t   " + 
                emp.getTitle() + " \t" + 
                String.format("$%,.2f", emp.getPayRate()) + "\t\t  " +
                String.format("$%,.2f", Payroll.getGrossPay()) + "\t   " +
                String.format("$%,.2f", Payroll.getTaxDeduction()) + "\t\t" +
                String.format("$%,.2f", Payroll.get401kDeduction()) + "\t\t   " + 
                String.format("$%,.2f", Payroll.getNetPay()));        
        
    }  // end of method    
        
    
    /** Method to display payroll results for a single employee
     *
     * @param emp
     */    
    public static void singleEmployeeDisplay(Employee emp)
    {
            System.out.println(emp.getLastName() + ", " + emp.getFirstName());
            System.out.println("\t\t\tGross Pay:\t\t" + 
                    String.format("$%,.2f", Payroll.getGrossPay()));
            System.out.println("\t\t\tTax Deduction: \t\t" + 
                    String.format("$%,.2f", Payroll.getTaxDeduction()));
            System.out.println("\t\t\t401K Deduction : \t" + 
                    String.format("$%,.2f", Payroll.get401kDeduction()));
            System.out.println("\t\t\tif applicable");
            System.out.println("____________________________________________________________");
            System.out.println("\t\t\tNet Pay: \t\t" + 
                    String.format("$%,.2f", Payroll.getNetPay()));
    
    }  //end of method
    
    
    /** Method to display exit message to the user 
     * 
     */    
    public static void exitSelection()
    {
        JOptionPane.showMessageDialog(null, "Goodbye!");
        System.exit(0);
    }
    
    
}  // end of class
