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


public abstract class Car
{
    
    // FIELDS
    protected String carMake,
                     carColor,
                     carConvertible;
    protected double carPerformance,
                     carPrice;
    protected int carCylinder;
    protected ImageView carPicture;
    
    
    // methods to override in class
    public abstract void setCarMake();
    public abstract void setCarPrice();
    public abstract void setCarCylinder();
    public abstract void setCarPerformance();
    public abstract void setCarColor(String color);
    public abstract void setCarPicture(ImageView picture);
    public abstract void setCarConvertible(String convertible);
    
    
    // GETTERS
    /**
     * @return the carMake
     */
    public String getCarMake() {
        return carMake;
    }

    /**
     * @return the carColor
     */
    public String getCarColor() {
        return carColor;
    }

    /**
     * @return the carConvertible
     */
    public String getCarConvertible() {
        return carConvertible;
    }

    /**
     * @return the carPerformance
     */
    public double getCarPerformance() {
        return carPerformance;
    }

    /**
     * @return the carPrice
     */
    public double getCarPrice() {
        return carPrice;
    }

    /**
     * @return the carCylinder
     */
    public int getCarCylinder() {
        return carCylinder;
    }

    /**
     * @return the carPicture
     */
    public ImageView getCarPicture() {
        return carPicture;
    }
    

}  // end of abstract class


