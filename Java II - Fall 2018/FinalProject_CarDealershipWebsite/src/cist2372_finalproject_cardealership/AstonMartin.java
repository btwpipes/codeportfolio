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


import javafx.scene.image.ImageView;


public class AstonMartin extends Car
{
    
    // CONSTRUCTORS
    public AstonMartin(String color, String convertible, ImageView picture)
    {
        super.carColor = color;
        super.carConvertible = convertible;
        super.carPicture = picture;
        
        setCarMake();
        setCarPrice();
        setCarCylinder();
        setCarPerformance();
    }
    
    // no-arg constructor
    public AstonMartin()
    {
        setCarMake();
        setCarPrice();
        setCarCylinder();
        setCarPerformance();
    }
    
    
    // SETTERS
    /**
     * all car make are Aston Martin 
     */
    public final void setCarMake() {
        carMake = "Aston Martin";
    }
    
    /**
     * @param color to set
     */
    public void setCarColor(String color) {
        carColor = color;
    }
    
    /**
     * @param convertible the carConvertible to set
     */
    public void setCarConvertible(String convertible) {
        carConvertible = convertible;
    }
    
    /**
     * all car performance set to 3.6
     */
    public void setCarPerformance() {
        carPerformance = 3.6;
    }
    
    /**
     * all car performance set to 12
     */
    public void setCarCylinder() {
        carCylinder = 12;
    }
    
        /**
     * all car performance set to $120,000.00
     */
    public void setCarPrice() {
        carPrice = 120000.00;
    }
   
    /**
     * @param picture to set 
     */
    public void setCarPicture(ImageView picture) {
        carPicture = picture;
    }

    /**
     * @override
     * @return carCylinder
     * 
     */
    public int getCarCylinder() {
        return carCylinder;
    }
    
    
}  // end of Aston Martin class
