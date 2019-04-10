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


public class Maserati extends Car
{
    
    // CONSTRUCTORS
    public Maserati(String color, String convertible, ImageView picture)
    {
        super.carColor = color;
        super.carConvertible = convertible;
        super.carPicture = picture;
        
        setCarMake();
        setCarPrice();
        setCarCylinder();
        setCarPerformance();
    }
    
    // default constructor
    public Maserati()
    {
        setCarMake();
        setCarPrice();
        setCarCylinder();
        setCarPerformance();    
    }
    
    
    // SETTERS
    /**
     * @override
     * all car make are Maserati
     */
    public final void setCarMake() {
        carMake = "Maserati";
    }
    
    /**
     * @override
     * @param color to set
     */
    public void setCarColor(String color) {
        carColor = color;
    }
    
    /**
     * @override
     * @param convertible the carConvertible to set
     */
    public void setCarConvertible(String convertible) {
        carConvertible = convertible;
    }
    
    /**
     * @override
     * all car performance set to 3.8
     */
    public void setCarPerformance() {
        carPerformance = 3.8;
    }
    
    /**
     * @override
     * all car performance set to 8
     */
    public void setCarCylinder() {
        carCylinder = 8;
    }
    
    /**
     * @override
     * all car performance set to $100,000.00
     */
    public void setCarPrice() {
        carPrice = 100000.00;
    }
   
    /**
     * @override
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
    
    
}  // end of Maserati class