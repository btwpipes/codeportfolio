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

import javafx.scene.effect.DropShadow;


public class StyleEffect {
        
    public static DropShadow createDropShadow1()
    {
        // create drop shadow object
        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setOffsetX(4.0);
        dropShadow1.setOffsetY(4.0);
        
        return dropShadow1;
    }
    
    public static DropShadow createDropShadow2()
    {
        // create drop shadow object
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setOffsetX(-1.0);
        dropShadow2.setOffsetY(0.0);
    
        return dropShadow2;
    }
    
    public static DropShadow createDropShadow3()
    {
        // create drop shadow object
        DropShadow dropShadow3 = new DropShadow();
        dropShadow3.setOffsetX(2.0);
        dropShadow3.setOffsetY(2.0);
        
        return dropShadow3;
    }
    
}
