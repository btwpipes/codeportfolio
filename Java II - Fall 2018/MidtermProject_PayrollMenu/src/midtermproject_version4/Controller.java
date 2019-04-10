/********************************************************
 * This class controls the logic of the program
 *
 * Author: Andre Paquette
 * Last modified: 10/10/18
 * Title: Controller.java
 * Associated to: MidtermProject_version1.java
 *******************************************************/

package midtermproject_version4;


import java.io.IOException;
import javax.swing.*;
 

public class Controller {

    // Fields
    public static byte selection;
    public static String userInput;
    private static String fname;
    private static String lname;
    private static String name;
        
    
    // Prompt for user to make selection from menu option    
    public static byte mainMenuOption() throws NumberFormatException, NullPointerException
    {
        try
        {
            userInput = JOptionPane.showInputDialog(null, "1. Calculate payroll for all employee\n" +
                                          "2. Calculate payroll for an employee\n" +
                                          "3. Calculate payroll for all managers\n" +
                                          "4. Calculate payroll for all staff\n" +
                                          "5. Quit\n\n" +
                                          "Please enter your selection number:");     
            selection = Byte.parseByte(userInput);
            
            while (selection < 1 || selection > 5)
            {                
                userInput = JOptionPane.showInputDialog(null, 
                            "You must enter a number between 1 and 5.\n\n" +
                            "Please re-enter your selection: ");
                selection = Byte.parseByte(userInput);
            }
            
            // call selectionAction to iterate through selection options
            selectionAction(Employee.getEmployeeArray());
        }
        catch (NumberFormatException e)
        {   
            JOptionPane.showMessageDialog(null, "You did not enter a valid number.\nGoodbye!");
            System.exit(0);
        }
        catch (NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, "Invalid entry. Goodbye!");
            System.exit(0);
        }
     
        return selection;
        
    }  // end of method
    
    
    /* Switch case call display
     * @param emp
     */
    public static void selectionAction(Employee[] employeeArray)
    {
        //Employee emp;
        switch (selection)
        {
            // display all employees
            case 1:
                Display.categoriesTitle();
                // loop through object to find and display manager of alien department
                for (Employee emp : Employee.getEmployeeArray())
                {  
                    if (emp.getDepartment().equalsIgnoreCase("Alien") && emp.getTitle().equalsIgnoreCase("Manager"))
                    {
                        Payroll.setGrossPay(emp);
                        Payroll.setTaxDeduction(emp);
                        Payroll.set401kDeduction(emp);
                        Display.allEmployeesDisplay(emp);
                    }    
                }
                
                // loop through object to find and display all staff of alien department
                for (Employee emp : Employee.getEmployeeArray())
                {  
                    if (emp.getDepartment().equalsIgnoreCase("Alien") && !emp.getTitle().equalsIgnoreCase("Manager"))
                    {
                        Payroll.setGrossPay(emp);
                        Payroll.setTaxDeduction(emp);
                        Payroll.set401kDeduction(emp);
                        Display.allEmployeesDisplay(emp);
                    }    
                }
                
                // add line space between departments  
                System.out.println("");
                
                // loop through object to find manager of human department
                for (Employee emp : Employee.getEmployeeArray())
                {
                    if (emp.getDepartment().equalsIgnoreCase("Human") && emp.getTitle().equalsIgnoreCase("Manager"))
                    {
                        Payroll.setGrossPay(emp);
                        Payroll.setTaxDeduction(emp);
                        Payroll.set401kDeduction(emp);
                        Display.allEmployeesDisplay(emp);
                    }    
                }
                
                // loop through object to find all staff of human department
                for (Employee emp : Employee.getEmployeeArray())
                {  
                    if (emp.getDepartment().equalsIgnoreCase("Human") && !emp.getTitle().equalsIgnoreCase("Manager"))
                    {
                        Payroll.setGrossPay(emp);
                        Payroll.setTaxDeduction(emp);
                        Payroll.set401kDeduction(emp);
                        Display.allEmployeesDisplay(emp);
                    }    
                }
                break;
                
            // display single employee    
            case 2:
                for (Employee emp : Employee.getEmployeeArray())
                { 
                    Display.nameOfAllEmployees(emp);
                }
                System.out.println("--------------------\n");
                promptUserForName();   
                break;
                
            // display managers only    
            case 3:
                Display.categoriesTitle();
                // loop through object
                for (Employee emp : Employee.getEmployeeArray())
                {  
                    Payroll.setGrossPay(emp);
                    Payroll.setTaxDeduction(emp);
                    Payroll.set401kDeduction(emp);
                    Display.allManagersDisplay(emp);
                }
                break;
                
            // display staff only    
            case 4:
                Display.categoriesTitle();
                // loop through object to find and display all alien department staff
                for (Employee emp : Employee.getEmployeeArray())
                {  
                    if (emp.getDepartment().equalsIgnoreCase("Alien"))
                    {
                        Payroll.setGrossPay(emp);
                        Payroll.setTaxDeduction(emp);
                        Payroll.set401kDeduction(emp);
                        Display.allStaffDisplay(emp);
                    }
                }
                
                // add line space between departments  
                System.out.println("");
                
                // loop through object to find and display all human department staff
                for (Employee emp : Employee.getEmployeeArray())
                {  
                    if (emp.getDepartment().equalsIgnoreCase("Human"))
                    {
                        Payroll.setGrossPay(emp);
                        Payroll.setTaxDeduction(emp);
                        Payroll.set401kDeduction(emp);
                        Display.allStaffDisplay(emp);
                    }
                }
                break;
                
            // system exit
            case 5:
                Display.exitSelection();
                break;
                
        }  // end of switch
        
    }  // end of method

    
    /** Method that prompt user for first name and last name
     * 
     */
    public static void promptUserForName()
    {
        String doAgain;
        try
        {
            do 
            {
                // prompt user for person's name
                name = JOptionPane.showInputDialog(null, 
                                    "The console shows all the valid names.\n" + 
                                    "Please enter the person's first and last name\n" +
                                    "of which you would like the payroll details: ");

                // loop through object
                for (Employee emp : Employee.getEmployeeArray())
                {
                    // look for matching name
                    if (name.equalsIgnoreCase(emp.getFullName()))
                    {                
                        Payroll.setGrossPay(emp);
                        Payroll.setTaxDeduction(emp);
                        Payroll.set401kDeduction(emp);
                        Display.singleEmployeeDisplay(emp);
                        System.exit(0);
                    }
                }
                
                // if name entered not found; ask user to do it again
                doAgain = JOptionPane.showInputDialog("Sorry could not find a match for:\n" + 
                                    name + "\n\nDo you want to try again?\n" +
                                    "Enter [Y]es or any key to exit.");
                
            } while (doAgain.equalsIgnoreCase("Y") || doAgain.equalsIgnoreCase("YES"));  // do again if entered Y or y
        }
        catch (NullPointerException e)
        {   
            Display.exitSelection();
        }
        
    } // end of method
    
    
    // *** MAIN method for program ***
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
        
        // call createArray to create file and build array 
        Employee.createArray();
        
        // call mainMenuOption to prompt user for selection
        Controller.mainMenuOption();
        
        // clean up
        System.exit(0);
       
    }  // end of main - terminates program
    
}  // end of class