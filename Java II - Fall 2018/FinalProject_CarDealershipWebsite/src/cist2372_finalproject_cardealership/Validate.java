/***************************************************************************
 * This program simulates a luxury car dealership website. The user 
 * can filter the cars displayed in the the window. Clicking the car tile
 * opens another that display the clicked car specifications. The user has
 * the option to purchase the car. Clicking the purchase button opens a
 * window to hold the user's data.
 *
 * Author: Andre Paquette
 * Last modified: 11/27/18
 * Title: Final Project - Car Dealership
 *************************************************************************/
package cist2372_finalproject_cardealership;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Validate
{
    
    
    public static boolean validateFirstName(String fName)
    {
        // pattern can contain letters, apostrophe, period, and dash only
        String regexp = "[a-zA-z]+['.-]?+[a-zA-Z]+$";
        //Pattern pattern = Pattern.compile(regexp,Pattern.CASE_INSENSITIVE);
        //Matcher matcher = pattern.matcher(name);
        
        if (!fName.matches(regexp))
        {
            JOptionPane.showMessageDialog(null, "'" + fName + "'" + 
                                          " is not a valid first name format.\n" +
                                          "Please re-enter your first name.");
        }
        
        return fName.matches(regexp);
    }

    public static boolean validateLastName(String lName)
    {
        // pattern can contain letters, apostrophe, period, and dash only
        String regexp = "[a-zA-z]+['.-]?+[a-zA-Z]+$";
        
        if (!lName.matches(regexp))
        {
            JOptionPane.showMessageDialog(null, "'" + lName + "'" + 
                                          " is not a valid last name format.\n" +
                                          "Please re-enter your last name.");
        }
        
        return lName.matches(regexp);
    }
    
    
    public static boolean validateCreditCard(String ccNumber)
    {
        // regular expression pattern accept 16 digits without space
        // or a pattern of 4 digits and a space 3 times, and 4 digits pattern (19 characters)
        String regexp = "([0-9]{16})|([1-9]{4}[ ]){3}([0-9]{4})+$";
        
        if (!ccNumber.matches(regexp))
        {
            JOptionPane.showMessageDialog(null, "'" + ccNumber + "'" + 
                                          " is not a valid credit card format.\n" +
                                          "Please re-enter your credit card numbers.");   
        }
        
        return ccNumber.matches(regexp);   
    }
    
    public static boolean validateCVV(String code)
    {
        // validate a value of 3 digits only
        String regexp = "([0-9]{3})+$";
        
        if (!code.matches(regexp))
        {
            JOptionPane.showMessageDialog(null, "'" + code + "'" + 
                                          " is not a valid CVV code format.\n" +
                                          "Please re-enter your 3 CVV numbers.");
        }
        
        return code.matches(regexp);
    }
    
    public static boolean validateExpirationDate(String ccExpDateFormat) throws ParseException
    {
        // initialize credit card as being valid (false = valid and true = expired)
        boolean expired = false;
        
        // try/catch to catch any potentially wrong date format (if changing combo boxes)
        try 
        {
            // create variable to hold cc expiration in valid format
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
            simpleDateFormat.setLenient(false);
            Date expiry = simpleDateFormat.parse(ccExpDateFormat);
            
            // set true or false based on validation before() method
            expired = expiry.before(new Date());
            
            // display message alert if credit card is expired
            if(expired)
            {
                JOptionPane.showMessageDialog(null, "'" + Buyer.getccExpirationMonth() + "/" + 
                                                      Buyer.getccExpirationYear() + "'" + 
                                              " is not a valid expiration date.\n" +
                                              "Please pick another month and/or year."); 
            }
        }
        catch(ParseException e)
        {
            // display to user/tester if date format throws an exception
            JOptionPane.showMessageDialog(null, "Expiration date error caught by the system.\n" +
                                  "Fix validateExpirationDate() method before using program.\n" +
                                  "The program will quit after clicking the \"okay\" button.");
        }
        
        return expired;        
    }
    
    
}  // end of class
