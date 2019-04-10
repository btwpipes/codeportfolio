/********************************************************************
 * This class contains fields and methods related to managers only
 *
 * Author: Andre Paquette
 * Last modified: 10/10/18
 * Title: Manager.java
 * Child of: Employee.java
 * Associated to: MidtermProject_version1.java
 *******************************************************************/

package midtermproject_version4;


public class Manager extends Employee {
    
    // Fields
    private String title;
    private double payRate;
    private boolean pensionParticipant;
    private String department;
    
    
    // Constructor
    public Manager(String firstName, String lastName, String empTitle,
                   double rate, boolean pension, String dept)
    {
        super(firstName, lastName);
        title = empTitle;
        payRate = rate;
        pensionParticipant = pension;
        department = dept;
    }
    
    
    /** Getter for title
     * @Override
     * @return the title
     */
    public String getTitle() 
    {
        return title;
    }
    
    
    /** Unused setter for title
     * 
     * @param empTitle
     */
    private void setTitle(String empTitle) 
    {
        title = empTitle;
    }
    
    
    /** Getter for payRate
     * @Override
     * @return the payRate
     */
    public double getPayRate() 
    {
        return payRate;
    }

    
    /** Unused setter for payRate
     * 
     * @param rate
     */
    public void setPayRate(double rate) 
    {
        payRate = rate;
    }
    
    
    /** Getter for department
     * @Override
     * @return the department
     */
    public String getDepartment()
    {
        return department;
    }

    
    /** Unused setter for department
     * 
     * @param dept
     */
    private void setDepartment(String dept)
    {
        department = dept;
    }
    
    
    /** Getter for pensionParticipant
     * @Override
     * @return the pensionParticipant
     */
    public boolean getPensionParticipant() 
    {
        return pensionParticipant;
    }
    
    
}  // end of class