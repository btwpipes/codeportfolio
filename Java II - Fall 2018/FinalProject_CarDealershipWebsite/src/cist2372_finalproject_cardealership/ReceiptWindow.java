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


import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ReceiptWindow
{
    // Fields
    // grid pane for layout
    GridPane grid;
    
    // labels for field names
    Label carPrice, carSalesTax, carDestinationFees, carTotalPrice, 
          name, creditCardNumber, expirationDate;
    
    // labels for user entered values
    Label price, salesTax, destinationFees, totalPrice,
          nameValue, creditCard, expiration;
            
    // button Print Receipt
    Button printButton;
    
    // HBox to hold button and entire grid components
    HBox printBtnBox, gridBox;
   
    
    public void createReceiptWindow()
    {
        // create grid pane layout, set alignment, set hor. and ver. gap
        // set padding, set background color, set drop shadow
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(50, 75, 35, 75));
        grid.setStyle("-fx-background-color: #CEE3F6");
        grid.setEffect(StyleEffect.createDropShadow3());
        
        // create car price label, set font, add label to grid layout
        carPrice = new Label("Car Price:");
        carPrice.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(carPrice, 0, 0);
        
        // create price label to hold car price value returned
        // from Purchase class, add label to grid layout
        price = new Label(String.format("$%,.2f", Purchase.getPurchasePrice()));
        grid.add(price, 1, 0);
 
        // create car sales tax label, set font, add label to grid
        carSalesTax = new Label("Sales Tax:");
        carSalesTax.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(carSalesTax, 0, 1);
        
        // create sales tax label to hold sales tax value returned
        // from Purchase class, add label to grid layout
        salesTax = new Label(String.format("$%,.2f", Purchase.getSalesTax()));
        grid.add(salesTax, 1, 1);
        
        // create car destination fees label, set font, add label to grid
        carDestinationFees = new Label("Destination Fees:");
        carDestinationFees.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(carDestinationFees, 0, 2);
        
        // create destination fees label to hold destination fees value
        // returned from Purchase class, add label to grid layout
        destinationFees = new Label(String.format("$%,.2f", Purchase.getDestinationFees()));
        grid.add(destinationFees, 1, 2);
        
        // create car total price label, set font, add label to grid
        carTotalPrice = new Label("Total Price:");
        carTotalPrice.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(carTotalPrice, 0, 3);
               
        // create total price label to hold final price value
        // returned from Purchase class, add label to grid layout
        totalPrice = new Label(String.format("$%,.2f", Purchase.getPurchaseTotal()));
        grid.add(totalPrice, 1, 3);

        // create name label, set font, add label to grid
        name = new Label("Name:");
        name.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(name, 0, 4);
        
        // create name value label to hold buyer first and last name
        // returned from Buyer class, add label to grid layout
        nameValue = new Label(Buyer.getFirstName() + " " + Buyer.getLastName());
        grid.add(nameValue, 1, 4);

        // create credit card number label, set font, add label to grid        
        creditCardNumber = new Label("Credit Card #:");
        creditCardNumber.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(creditCardNumber, 0, 5);
        
        // create credit card label to hold buyer credit card number
        // returned from Buyer class, add label to grid layout
        creditCard = new Label(Buyer.getCreditCardNumber());
        grid.add(creditCard, 1, 5);
  
        // create expiration date label, set font, add label to grid        
        expirationDate = new Label("Expiration Date:");
        expirationDate.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(expirationDate, 0, 6);
        
        // create expiration label to hold buyer credit card expiration date
        // returned from Buyer class, add label to grid layout
        expiration = new Label(Buyer.getccExpirationMonth() + "/" + Buyer.getccExpirationYear());
        grid.add(expiration, 1, 6);
        
        // create button to simulate the user printing the receipt
        // set alignment, add component to HBox and add to grid
        printButton = new Button("Print Receipt");
        printBtnBox = new HBox(10);
        printBtnBox.setAlignment(Pos.BOTTOM_LEFT);
        printBtnBox.getChildren().add(printButton);
        grid.add(printBtnBox, 1, 8);
        
        // create HBox, set alignment, set padding, 
        // add components, set background color 
        gridBox = new HBox();
        gridBox.setAlignment(Pos.CENTER);
        gridBox.setPadding(new Insets(55, 55, 55, 55));
        gridBox.getChildren().add(grid);
        gridBox.setStyle("-fx-background-color: #66849d");
        
        // create new scene
        Scene scene = new Scene(gridBox, 600, 500);
        
        // create new stage
        Stage stage = new Stage();
        
        // set stage title, scene, position, and visibility
        stage.setTitle("Purchase Receipt");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
        // LAMBDA event handling
        printButton.setOnAction((ActionEvent event) -> {
            // close stage when user press button
            stage.close();
        });  // end of event handler
        
    }  // end of createReceiptWindow()
    
    
}  // end of class
