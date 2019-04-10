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


import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class SpecsWindow
{
    // FIELDS
    // labels for car specs fields
    Label specs, make, color, cylinder, performance, convertible, price;
    
    // labels for car specs values
    Label makeValue, colorValue, cylinderValue, performanceValue, 
          convertibleValue, priceValue;
    
    // button for user purchase option and holding car image 
    Button purchaseButton, carPict;
    
    // image for car pic
    ImageView image;
    
    // boxes holding widgets
    VBox specsBorder;
    HBox carPane, purchaseBtnBox;
    
    // main frame pane
    BorderPane mainFrame;
    
    // string holding the cars' URL or location
    String[] carPictureURL = new String[]
    {
        "cars/BlkMaserati.jpg", "cars/BluMaserati.jpg", "cars/RedMaserati.jpg", 
        "cars/WhiteMaserConvertible.jpg", "cars/BlkAstonConvertible.jpg", "cars/BluAston.jpg", 
        "cars/GreenAston.jpg", "cars/RedAstonConvertible2.jpg", "cars/BlkFerrariConvertible.jpg", 
        "cars/BluFerrariConvertible.jpg", "cars/RedFerrari.jpg", "cars/WhiteFerrari.jpg", 
        "cars/WhiteFerrConvertible.jpg", "cars/YellowFerrari.jpg", "cars/BlkMcLaren.jpg", 
        "cars/BluMcLaren.jpg", "cars/GreenMcLaren.jpg", "cars/OranMcLarConvertible.jpg", 
        "cars/RedMcLaren.jpg", "cars/YellowMcLaren.jpg", "cars/BlkLambo.jpg", 
        "cars/BlkLamboConvertible.jpg", "cars/BluLamboConvertible.jpg", "cars/GreenLambo.jpg", 
        "cars/WhiteLambo.jpg", "cars/YellowLambo.jpg"
    };    
    
    
    public void createSpecsWindow(int index, ArrayList<Car> cars)
    {           
        // create inset (used as spacing between car specs)
        Insets spacing = new Insets(0, 0, 10, 0);
        
        // create specification label, set text, and set font and style
        specs = new Label("Specifications\n");
        specs.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        specs.setTextFill(Color.web("#66849d"));
        specs.setPadding(spacing);
        specs.setUnderline(true);
        
        // Labels for car specifications
        // create car make labels, set text, and set font
        make = new Label("Make: ");
        make.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        makeValue = new Label(cars.get(index).carMake);
        makeValue.setPadding(spacing);
        
        // create car color labels, set text, and set font
        color = new Label("Color: ");
        color.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        colorValue = new Label(cars.get(index).carColor);
        colorValue.setPadding(spacing);
        
        // create car cylinder amount labels, set text, and set font
        cylinder = new Label("Cylinders: ");
        cylinder.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        cylinderValue = new Label(String.format("%d cylinders", cars.get(index).getCarCylinder()));
        cylinderValue.setPadding(spacing);
        
        // create car performance 0-60, set text, and set font
        performance = new Label("0-60mph: ");
        performance.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        performanceValue = new Label(String.format("%.1f seconds", cars.get(index).getCarPerformance()));
        performanceValue.setPadding(spacing);
        
        // create car convertible option, set text, and set font
        convertible = new Label("Convertible: ");
        convertible.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        convertibleValue = new Label(cars.get(index).getCarConvertible());
        convertibleValue.setPadding(spacing);
        
        // create car price labels, set text, and set font
        price = new Label("Price: ");
        price.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        priceValue = new Label(String.format("$%,.2f", cars.get(index).getCarPrice()));
        priceValue.setPadding(spacing);
        
        // create a purchase button, set text
        purchaseButton = new Button();
        purchaseButton.setText("Purchase vehicle");
        
        // create VBox for car specs, add components, set alignment,
        // set padding, and set spacing, set background color
        specsBorder = new VBox();
        specsBorder.getChildren().addAll(specs, make, makeValue, color, colorValue, cylinder, cylinderValue,
                                         performance, performanceValue, convertible, convertibleValue,
                                         price, priceValue);
        specsBorder.setAlignment(Pos.CENTER_LEFT);
        specsBorder.setPadding(new Insets(10, 50, 10, 13));
        specsBorder.setSpacing(10);
        specsBorder.setStyle("-fx-color-background: #C0C0C0");
        
        // create tile pane to hold specific car image, add components,
        // set gaps, set size, set rows/columns, set alignment, set style and effect
        image = new ImageView(carPictureURL[index]);
        image.setScaleX(2.5);
        image.setScaleY(2.5);
        image.setStyle("-fx-border-color: black");
        carPict = new Button();
        carPict.setGraphic(image);
        carPict.setStyle("-fx-border-color: black");
        carPict.setEffect(StyleEffect.createDropShadow1());
        
        // create carPane box to hold car picture, add component
        // set backgroud color, set alignment, set drop shadow effect
        carPane = new HBox();
        carPane.getChildren().add(carPict);
        carPane.setStyle("-fx-background-color: #66849d");
        carPane.setAlignment(Pos.CENTER);  
        carPane.setEffect(StyleEffect.createDropShadow2());
        
        // create HBox to hold purchase button, add component
        // set padding, and set alignment
        purchaseBtnBox = new HBox();
        purchaseBtnBox.getChildren().addAll(purchaseButton);
        purchaseBtnBox.setPadding(new Insets(25, 0, 30, 0));
        purchaseBtnBox.setAlignment(Pos.CENTER);
        purchaseBtnBox.setStyle("-fx-background-color: black");
                
        // create border pane for window, and add components to regions
        mainFrame = new BorderPane();
        mainFrame.setTop(ComponentReuse.createHeader());
        mainFrame.setLeft(specsBorder);
        mainFrame.setCenter(carPane);
        mainFrame.setBottom(purchaseBtnBox);
                
        // create new scene
        Scene scene = new Scene(mainFrame, 1070, 750);
        
        // create new stage
        Stage stage = new Stage();
        
        // set modality, set stage title, scene, position and visibility
        stage.setTitle("Car Specifications");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
  
        // LAMBDA event handling
        purchaseButton.setOnAction((ActionEvent event) -> {
            // create Purchase object
            Purchase carPurchase = new Purchase(cars.get(index).getCarPrice());
            
            // create buyer info object and create stage
            BuyerInfoWindow buyerInfo = new BuyerInfoWindow();
            buyerInfo.createBuyerInfoWindow();
            
            // close specs window
            stage.close();
        });  // end of event handler
        
    } // end of createSpecsWindow()
    
    
}  // end of class