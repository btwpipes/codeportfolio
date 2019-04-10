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


public class Buyer
{
    
    // FIELDS
    private static String firstName,
                          lastName;
            
    private static String creditCardNumber,
                       ccExpirationMonth,
                       ccExpirationYear,
                       cvvCode;                
  
    
    // GETTERS and SETTERS
    /**
     * @return the firstName
     */
    public static String getFirstName() {
        return firstName;
    }

    /**
     * @param fName the firstName to set
     */
    public static void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * @return the lastName
     */
    public static String getLastName() {
        return lastName;
    }

    /**
     * @param lName the lastName to set
     */
    public static void setLastName(String lName) {
        lastName = lName;
    }

    /**
     * @return the creditCardNumber
     */
    public static String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * @param ccNumber the creditCardNumber to set
     */
    public static void setCreditCardNumber(String ccNumber) {
        creditCardNumber = ccNumber;
    }

    /**
     * @return the ccExpirationMonth
     */
    public static String getccExpirationMonth() {
        return ccExpirationMonth;
    }

    /**
     * @param ccMonth the ccExpirationMonth to set
     */
    public static void setccExpirationMonth(String ccMonth) {
        ccExpirationMonth = ccMonth;
    }

    /**
     * @return the ccExpirationYear
     */
    public static String getccExpirationYear() {
        return ccExpirationYear;
    }

    /**
     * @param ccYear the ccExpirationYear to set
     */
    public static void setccExpirationYear(String ccYear) {
        ccExpirationYear = ccYear;
    }

    /**
     * @return the cvvCode
     */
    public static String getcvvCode() {
        return cvvCode;
    }

    /**
     * @param cvv the cvvCode to set
     */
    public static void setcvvCode(String cvv) {
        cvvCode = cvv;
    }    
    
    
}  // end of class
