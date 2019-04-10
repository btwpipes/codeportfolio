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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ComponentReuse {
    
    
    public static HBox createHeader()
    {
        // create logo box in window, set alignment, add logo image
        VBox logoBox = new VBox();
        logoBox.setAlignment(Pos.CENTER);
        logoBox.getChildren().add(new ImageView("logos/ExoticMoves_Logo.png"));
        
        // create address info label, set text, and set font
        Label streetAddress = new Label();
        streetAddress.setText("1234 Buford Highway");
        streetAddress.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        streetAddress.setTextFill(Color.LIGHTSKYBLUE);
        
        // create city, state, zip label, set text, and set font
        Label cityStateZip = new Label();
        cityStateZip.setText("Dacula, GA  30321");
        cityStateZip.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        cityStateZip.setTextFill(Color.LIGHTSKYBLUE);
        
        // create phone number label, set text, and set font
        Label phoneNumber = new Label();
        phoneNumber.setText("770.879.3129");
        phoneNumber.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        phoneNumber.setTextFill(Color.LIGHTSKYBLUE);
        
        // create website info label, set text, and set font
        Label website = new Label();
        website.setText("www.ExoticMoves.com");
        website.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        website.setTextFill(Color.SILVER);
        
        // create email address label, set text, and set font
        Label email = new Label();
        email.setText("CarSales@ExoticMoves.com");
        email.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        email.setTextFill(Color.SILVER);
        
        // create vertical boxes for dealership info (except logo since already created)
        // create horizontal box to hold vertical boxes, add components, and set alignment 
        VBox locationInfo = new VBox(10);
        locationInfo.getChildren().addAll(streetAddress, cityStateZip, phoneNumber);
        locationInfo.setAlignment(Pos.CENTER);
        VBox websiteInfo = new VBox(10);
        websiteInfo.getChildren().addAll(website, email);
        websiteInfo.setAlignment(Pos.CENTER);
        HBox dealershipInfo = new HBox(80);
        dealershipInfo.setAlignment(Pos.CENTER);
        dealershipInfo.getChildren().addAll(logoBox, locationInfo, websiteInfo);
        dealershipInfo.setStyle("-fx-background-color: black");
        
        return dealershipInfo;
        
    }  // end of createHeader()
    
    public static VBox createFooter()
    {                
        // create Label for copyright info, create VBox to hold label
        // add component, set font, set alignment, and set padding
        Label copyrightInfo = new Label("©2018 Exotic Moves Incorporated. " +
                                        "All Rights Reserved. Webmaster: BtwPipes Inc.");
        copyrightInfo.setFont(Font.font("Times New Roman", 12));
        copyrightInfo.setTextFill(Color.SILVER);
        VBox copyrightBox = new VBox();
        copyrightBox.setAlignment(Pos.BOTTOM_CENTER);
        copyrightBox.setPadding(new Insets(15));
        copyrightBox.getChildren().add(copyrightInfo);
        copyrightBox.setStyle("-fx-background-color: black");  
        
        return copyrightBox;
        
    }  // end of createFooter()
    
    public static Label createRequiredLabel()
    {
        Label required = new Label("Required");
        required.setStyle("-fx-text-fill: red");
        
        return required;
        
    }  // end of createRequiredLabel()
    
    
    
    
    
    
    
    
    
    
}  // end of class
