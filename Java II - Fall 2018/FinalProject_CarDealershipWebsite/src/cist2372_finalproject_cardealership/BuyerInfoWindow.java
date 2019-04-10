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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BuyerInfoWindow
{
    // Fields
    // grid pane to hold labels and text fields
    GridPane grid;
    
    // labels holding car purchase values
    Label carPrice, price, carSalesTax, salesTax, carDestinationFees, 
          destinationFees, carTotalPrice, totalPrice;
    
    // text for direction to user
    Text infoToUser;
    
    // labels for user form
    Label firstName, lastName, creditCardNumber, cvvCode, expirationDate;
    
    // text fields for user input
    TextField firstNameField, lastNameField, creditCardField, cvvCodeField;
    
    // combo boxes for cc expiration date
    ComboBox monthSelection, yearSelection;
    
    // button "Process Purchase"
    Button processButton;
    
    // HBox holding process button and grip pane
    HBox processBtnBox, gridBox;
    
    public void createBuyerInfoWindow()
    {
        // create grid pane, set alignment, set horizontal and vertical gap, and set padding
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background-color: #CEE3F6");
        grid.setEffect(StyleEffect.createDropShadow3());
        
        // create car price label, set text, set font, add to grid
        carPrice = new Label("Car Price:");
        carPrice.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(carPrice, 0, 0);
        
        // create label to hold carPrice value from Purchase, and add to grid
        price = new Label(String.format("$%,.2f", Purchase.getPurchasePrice()));
        grid.add(price, 1, 0);
 
        // create car sales tax label, set text, set font, add to grid
        carSalesTax = new Label("Sales Tax:");
        carSalesTax.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(carSalesTax, 0, 1);
        
        // create label to hold carSalesTax value from Purchase, and add to grid
        salesTax = new Label(String.format("$%,.2f", Purchase.getSalesTax()));
        grid.add(salesTax, 1, 1);
        
        // create car destination fees label, set text, set font, add to grid
        carDestinationFees = new Label("Destination Fees:");
        carDestinationFees.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(carDestinationFees, 0, 2);
        
        // create label to hold carDestinationFees value from Purchase, and add to grid        
        destinationFees = new Label(String.format("$%,.2f", Purchase.getDestinationFees()));
        grid.add(destinationFees, 1, 2);
        
        // create car total price label, set text, set font, add to grid      
        carTotalPrice = new Label("Total Price:");
        carTotalPrice.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(carTotalPrice, 0, 3);
        
        // create label to hold carTotalPrice value from Purchase, and add to grid  
        totalPrice = new Label(String.format("$%,.2f", Purchase.getPurchaseTotal()));
        grid.add(totalPrice, 1, 3);

        // create label to instruct user, set text, set font, add to grid        
        infoToUser = new Text("Please fill all the fields");
        infoToUser.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        grid.add(infoToUser, 0, 5, 2, 1);

        // create first name label, and add to grid        
        firstName = new Label("First Name:");
        grid.add(firstName, 0, 6);
        
        // create text field to hold user entry, set prompt text, and add to grid
        firstNameField = new TextField();
        firstNameField.setPromptText("Must be letters only.");
        grid.add(firstNameField, 1, 6);

        // create first name label, and add to grid 
        lastName = new Label("Last Name:");
        grid.add(lastName, 0, 7);
        
        // create text field to hold user entry, set prompt text, and add to grid
        lastNameField = new TextField();
        lastNameField.setPromptText("Must be letters only.");
        grid.add(lastNameField, 1, 7);
        
        // create first name label, and add to grid 
        creditCardNumber = new Label("Credit Card #:");
        grid.add(creditCardNumber, 0, 8);
        
        // create text field to hold user entry, set prompt text, and add to grid
        creditCardField = new TextField();
        creditCardField.setPromptText("Must be 16 digits.");
        grid.add(creditCardField, 1, 8);

        // create first name label, and add to grid 
        cvvCode = new Label("CVV code(back of card):");
        grid.add(cvvCode, 0, 9);
        
        // create text field to hold user entry, set prompt text, and add to grid
        cvvCodeField = new TextField();
        cvvCodeField.setPromptText("Must be 3 digits.");
        grid.add(cvvCodeField, 1, 9);
        
        // call class method to create required label, add label to grid
        grid.add(ComponentReuse.createRequiredLabel(), 2, 6);
        grid.add(ComponentReuse.createRequiredLabel(), 2, 7);
        grid.add(ComponentReuse.createRequiredLabel(), 2, 8);
        grid.add(ComponentReuse.createRequiredLabel(), 2, 9);
        
        // create expiration date label and add to grid
        expirationDate = new Label("Expiration Date:");
        grid.add(expirationDate, 0, 10);
        
        // create combo box to hold 12 numuber to represent months
        // set all month, set to select first, and add to grid
        monthSelection = new ComboBox();
        monthSelection.getItems().addAll("01","02", "03", "04", "05", "06", 
                                         "07", "08", "09", "10", "11", "12");
        monthSelection.getSelectionModel().selectFirst();
        grid.add(monthSelection, 1, 10);
        
        // create combo box to hold 8 numubers to represent years
        // set all years, set to select first, and add to grid
        yearSelection = new ComboBox();
        yearSelection.getItems().addAll("2018", "2019", "2020", "2021", 
                                        "2022", "2023", "2024", "2025");
        yearSelection.getSelectionModel().selectFirst();
        grid.add(yearSelection, 2, 10);
        
        // create button for user to click after setting all fields
        // add to HBox, set alignment, and add to grid
        processButton = new Button("Process Purchase");
        processBtnBox = new HBox(10);
        processBtnBox.setAlignment(Pos.BOTTOM_LEFT);
        processBtnBox.getChildren().add(processButton);
        grid.add(processBtnBox, 1, 12);
        
        // create HBox, set alignment, set padding, 
        // add components, set background color 
        gridBox = new HBox();
        gridBox.setAlignment(Pos.CENTER);
        gridBox.setPadding(new Insets(45, 45, 45, 45));
        gridBox.getChildren().add(grid);
        gridBox.setStyle("-fx-background-color: #66849d");
        
        // create new scene
        Scene scene = new Scene(gridBox, 600, 550);
        
        // create new stage
        Stage stage = new Stage();
        
        // set stage title, scene, position, and visibility
        stage.setTitle("Buyer Information");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
        // LAMBDA event handler on button click     
        processButton.setOnAction((ActionEvent event) -> {
            
            // set expiration month and year to combo boxes values
            Buyer.setccExpirationMonth(((ComboBox)monthSelection).getValue().toString());
            Buyer.setccExpirationYear(((ComboBox)yearSelection).getValue().toString());
            
            // create boolean to meet condition
            boolean validCC = false;
            
            // all validation method must return valid values to generation receipt window
            if (Validate.validateFirstName(firstNameField.getText()) == true &&
                    Validate.validateLastName(lastNameField.getText()) == true &&
                    Validate.validateCreditCard(creditCardField.getText()) == true &&
                    Validate.validateCVV(cvvCodeField.getText()) == true)
            {
                // in case validateExpirationDate() throws a ParseException
                try
                {
                    // call to method to validate the credit card expiration date
                    if(!Validate.validateExpirationDate(Buyer.getccExpirationMonth() + 
                            "/" + Buyer.getccExpirationYear()))
                    {
                        // if expiration date is valid set validCC to true
                        validCC = true;
                    }
                } catch (ParseException e)
                {
                    Logger.getLogger(BuyerInfoWindow.class.getName()).log(Level.SEVERE, null, e);
                }
                
                // create ReceiptWindow once all validation are true
                if(validCC == true)
                {
                    // set buyer's values
                    Buyer.setFirstName(firstNameField.getText());
                    Buyer.setLastName(lastNameField.getText());
                    Buyer.setCreditCardNumber(creditCardField.getText());
                    Buyer.setcvvCode(cvvCodeField.getText());
                    
                    // create ReceiptWindow to show buyer final purchase info
                    ReceiptWindow receipt = new ReceiptWindow();
                    receipt.createReceiptWindow();
                    
                    // close BuyerInfoWindow
                    stage.close();
                }
            }
        });  // end of event handler
    }
    
    
}  // end of class
