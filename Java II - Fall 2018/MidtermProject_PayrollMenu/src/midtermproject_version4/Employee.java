/*******************************************************
 * This is an abstract class that contains only 
 * information relevant to all employees
 *
 * Author: Andre Paquette
 * Last modified: 10/10/18
 * Title: Employee.java
 * Parent of: Manager.java, Staff.java
 * Associated to: MidtermProject_version1.java
 *******************************************************/

package midtermproject_version4;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;


public abstract class Employee implements Serializable {
    
    // Fields
    private String firstName,
                   lastName;
    final static int SIZE = 5;
    private static Employee[] employeeArray = new Employee[SIZE];     
    
    
    // Constructor
    public Employee (String fName, String lName)
    {
        firstName = fName;
        lastName = lName;

    }
    
    
    /** initial method to create file 
     *  and fill employeeArray
     */
    public static void createArray() 
    {
        try
        {
        // Data used to create file
        FileOutputStream stream = new FileOutputStream("employeeInformation.dat");
        ObjectOutputStream objectStream = new ObjectOutputStream(stream);
           
        objectStream.writeObject(new Manager("Bruce", "Wayne", "Manager", 193900, false, "Human"));
        objectStream.writeObject(new Staff("Peter", "Parker", "Spiderman", 19.62, true, "Human"));
        objectStream.writeObject(new Staff("Clark", "Kent", "Superman", 19.38, false, "Alien"));
        objectStream.writeObject(new Manager("Steve", "Rogers", "Manager", 196300, true, "Alien"));
        objectStream.writeObject(new Staff("Tony", "Stark", "Ironman", 19.41, true, "Human"));
           
        //read in data from file and store in an array
        FileInputStream fs = new FileInputStream("employeeInformation.dat");
        ObjectInputStream os = new ObjectInputStream(fs);

        for(int i=0; i < employeeArray.length; i++)
        {
            employeeArray[i] = (Employee) os.readObject();
        }
        
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "File not found.");
            System.exit(0);
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Class not found.");
            System.exit(0);
        }
        
    }  // end of method
    
    
    /** Getter for EmployeeArray
     * @return the EmployeeArray
     */
    public static Employee[] getEmployeeArray() 
    {
        return employeeArray;
    }
    
    
    // Getters and Setters
    /** Getter for firstName
     * @return the firstName
     */
    public String getFirstName() 
    {
        return firstName;
    }

    
    /** Unused setter for firstName
     * @param fName the firstName to set
     */
    private void setFirstName(String fName) 
    {
        firstName = fName;
    }

    
    /** Getter for lastName
     * @return the lastName
     */
    public String getLastName() 
    {
        return lastName;
    }

    
    /** Unused setter for lastName
     * @param lName the lastName to set
     */
    private void setLastName(String lName) 
    {
        lastName = lName;
    }
    
    
    /** Getter for FullName (firstName + lastName)
     * @return the firstName + " " + lastName
     */
    public String getFullName() 
    {
        return firstName + " " + lastName;
    }    
    
    
    // abstract methods to be overriden in Manager and Staff classes
    public abstract double getPayRate();
    public abstract String getTitle();
    public abstract String getDepartment();
    public abstract boolean getPensionParticipant();
    
    
}  //end of class
