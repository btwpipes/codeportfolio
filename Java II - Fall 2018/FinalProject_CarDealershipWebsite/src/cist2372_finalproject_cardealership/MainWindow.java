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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class MainWindow extends Application
{
    // FIELDS
    Maserati car1, car2, car3, car4;
    AstonMartin car5, car6, car7, car8;
    Ferrari car9, car10, car11, car12, car13, car14;
    McLaren car15, car16, car17, car18, car19, car20;
    Lamborghini car21, car22, car23, car24, car25, car26;
    
    // array list to hold all cars
    ArrayList<Car> cars;
    
    // car button array
    final int SIZE = 26;
    final Button [] carButton = new Button[SIZE];
    
    // create labels for left pane (filters)
    Label filters, carMake, carColor, convertible, carPrice;
    
    // car make combo box
    ComboBox carOptions = new ComboBox();
    
    // car color radio buttons
    ComboBox colorOptions = new ComboBox();

    // convertible radio buttons
    CheckBox convertibleYes, convertibleNo;

    // car price radio buttons
    RadioButton anyPrice, lessThan100K, lessThan200K, lessThan300K, lessThan400K;
    
    // toggle group to hold price radio buttons
    ToggleGroup priceOptions;
    
    // button Apply Filter
    Button filter;
    
    // VBox and Hbox holding combo boxes, radio buttons and button for left pane
    VBox filtersBox, makeFilter, colorFilter, convertibleFilter, priceFilter, filterBorder;
    HBox filterButton;
    
    // Various panes to hold VBox and HBox that hold widgets
    TilePane carPane;
    ScrollPane scrollPane;
    BorderPane mainFrame;    
    
    @Override
    public void start(Stage primaryStage) {
        
        // call to method to create all the cars
        createCars();
        
        // create car make label, set text, set alignment, and set font
        filters = new Label();
        filters.setText("Filters");
        filters.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        filters.setTextFill(Color.web("#66849d"));
        filters.setUnderline(true);
        
        // create car make label, set text, set alignment, and set font
        carMake = new Label();
        carMake.setText("MAKE:");
        carMake.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        
        // create car color label, set text, set alignment, and set font
        carColor = new Label();
        carColor.setText("COLOR:");
        carColor.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        
        // create convertible label, set text, set alignment, and set font
        convertible = new Label();
        convertible.setText("CONVERTIBLE:");
        convertible.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        
        // create car price label, set text, set alignment, and set font
        carPrice = new Label();
        carPrice.setText("PRICE:");
        carPrice.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        
        // create car make options combo box
        carOptions.getItems().addAll("- All Makes -", "Aston Martin", "Ferrari",
                                     "Lamborghini", "Maserati", "McLaren");
        carOptions.getSelectionModel().selectFirst();
        
        // create car color options combo box
        colorOptions.getItems().addAll("- Any Color -", "Black", "Blue", "Green", 
                                       "Orange", "Red", "White", "Yellow");
        colorOptions.getSelectionModel().selectFirst();
        
        // create convertible radio buttons
        convertibleYes = new CheckBox("Yes");
        convertibleNo = new CheckBox("No");
        
        // create car price radio buttons
        lessThan100K = new RadioButton("$100,000 or less");
        lessThan200K = new RadioButton("$200,000 or less");
        lessThan300K = new RadioButton("$300,000 or less");
        lessThan400K = new RadioButton("$400,000 or less");
        anyPrice = new RadioButton("Any Price Range");
        anyPrice.setSelected(true);
        
        // create group to hold priceOptions radio buttons so user can only select one
        priceOptions = new ToggleGroup();
        lessThan100K.setToggleGroup(priceOptions);
        lessThan200K.setToggleGroup(priceOptions);
        lessThan300K.setToggleGroup(priceOptions);
        lessThan400K.setToggleGroup(priceOptions);
        anyPrice.setToggleGroup(priceOptions);
        
        // create button and set name
        filter = new Button();
        filter.setText("Apply Filter");
        
        // LAMBDA event handler for all car picture buttons
        filter.setOnAction((ActionEvent event) -> {
            carFiltering();
        });
        
        
        // use for each and for loop to itirate through all cars 
        // and set all button with car picture
        for (Car r : cars)
        {
            for (int i = 0; i < SIZE; i++)
            {
                // create buttons and set car picture
                carButton[i] = new Button();
                carButton[i].setId(String.format("%d", i));
                carButton[i].setGraphic(cars.get(i).getCarPicture());

                // LAMBDA event handler for all car picture buttons as inner class
                carButton[i].setOnAction((ActionEvent event) -> {
                    // getId using event getSource
                    int index = Integer.parseInt(((Control)event.getSource()).getId());
                    
                    // event create new SpecsWindow
                    SpecsWindow specs = new SpecsWindow();
                    specs.createSpecsWindow(index, cars);
                });
            }
            
        } // end of for loop
        
        // create VBox to hold car make options components, 
        // add components, set alignment, and set padding        
        filtersBox = new VBox(10);
        filtersBox.getChildren().add(filters);
        filtersBox.setAlignment(Pos.CENTER);
        filtersBox.setPadding(new Insets(15, 0, 20, 10));
        
        // create VBox to hold car make options components, 
        // add components, set alignment, and set padding        
        makeFilter = new VBox(10);
        makeFilter.getChildren().addAll(carMake, carOptions);
        makeFilter.setAlignment(Pos.TOP_LEFT);
        makeFilter.setPadding(new Insets(0, 0, 30, 0));
        
        // create VBox to hold color options components, 
        // add components, set alignment, and set padding
        colorFilter = new VBox(10);
        colorFilter.getChildren().addAll(carColor, colorOptions);
        colorFilter.setAlignment(Pos.TOP_LEFT);
        colorFilter.setPadding(new Insets(0, 0, 30, 0));
        
        // create VBox to hold convertible options components, 
        // add components, set alignment, and set padding
        convertibleFilter = new VBox(10);
        convertibleFilter.getChildren().addAll(convertible, convertibleYes, convertibleNo);
        convertibleFilter.setAlignment(Pos.TOP_LEFT);
        convertibleFilter.setPadding(new Insets(0, 0, 30, 0));
        
        // create VBox to hold car price options components,
        // add components, set alignment, and set padding
        priceFilter = new VBox(10);
        priceFilter.getChildren().addAll(carPrice, lessThan100K, lessThan200K, 
                                         lessThan300K, lessThan400K, anyPrice);
        priceFilter.setAlignment(Pos.TOP_LEFT);
        priceFilter.setPadding(new Insets(0, 0, 30, 0));
        
        // create HBox to hold component and set alignment
        filterButton = new HBox();
        filterButton.getChildren().add(filter);
        filterButton.setAlignment(Pos.CENTER);
        
        // create VBox to hold VBoxes and HBox of all the available filters
        // add all components, set alignment, set padding, and set border
        filterBorder = new VBox();
        filterBorder.getChildren().addAll(filtersBox, makeFilter, colorFilter, 
                                          convertibleFilter, priceFilter, filterButton);
        filterBorder.setAlignment(Pos.TOP_LEFT);
        filterBorder.setPadding(new Insets(10, 50, 10, 13));
        filterBorder.setStyle("-fx-color-background: #C0C0C0");
        
        // create tile pane to hold cars
        carPane = new TilePane();
        // loop to add car button as tile to the carPane set as TilePane
        for(Button tile : carButton)
        {
            carPane.getChildren().add(tile);
            carPane.setHgap(25);
            carPane.setVgap(25);
            carPane.setAlignment(Pos.CENTER);
        }
        
        // set carPane region properties
        carPane.setPrefTileHeight(190);
        carPane.setPrefTileWidth(280);
        carPane.setPrefColumns(3);
        carPane.setPrefRows(9);
        carPane.setAlignment(Pos.CENTER);
        carPane.setPadding(new Insets(25, 25, 25, 25));
        carPane.setStyle("-fx-background-color: #66849d");
        
        // set scroll pane to add scroll bar to carPane section 
        // Thank you Mr. Burley for your help figuring out this issue
        scrollPane = new ScrollPane();
        scrollPane.setContent(carPane);
        scrollPane.setEffect(StyleEffect.createDropShadow2());
                
        // set border pane for main window
        // add region to border pane mainFrame
        mainFrame = new BorderPane();
        mainFrame.setTop(ComponentReuse.createHeader());
        mainFrame.setLeft(filterBorder);
        mainFrame.setCenter(scrollPane);
        mainFrame.setBottom(ComponentReuse.createFooter());
        
        // create new scene, add mainFrame, and set window size
        Scene scene = new Scene(mainFrame, 1132, 950);

        // set primaryStage title, add scene and make visible
        primaryStage.setTitle("ExoticMoves.com");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }  // end of start() 
   
    
    public void carFiltering()
    {  
        for (int i = 0; i < SIZE; i++)
        {           
            // set all car buttons to visible; act as a reset button
            carButton[i].setVisible(true);
            
            // check for selection and cars values meet criteria
            if (carOptions.getValue() == "Aston Martin" && !cars.get(i).getCarMake().equalsIgnoreCase("Aston Martin"))
            {
                carButton[i].setVisible(false);  
            }
            else if (carOptions.getValue() == "Ferrari" && !cars.get(i).getCarMake().equalsIgnoreCase("Ferrari"))
            {
                // cars that are not Ferrari are not displayed
                carButton[i].setVisible(false);
            }
            else if (carOptions.getValue() == "Lamborghini" && !cars.get(i).getCarMake().equalsIgnoreCase("Lamborghini"))
            {
                // cars that are not Lamborghini are not displayed
                carButton[i].setVisible(false);
            }
            else if (carOptions.getValue() == "Maserati" && !cars.get(i).getCarMake().equalsIgnoreCase("Maserati"))
            {
                // cars that are not Maserati are not displayed
                carButton[i].setVisible(false);
            }
            else if (carOptions.getValue() == "McLaren" && !cars.get(i).getCarMake().equalsIgnoreCase("McLaren"))
            {
                // cars that are not McLaren are not displayed
                carButton[i].setVisible(false);
            }    
            
            // check for selectionand cars values meet criteria
            if (colorOptions.getValue() == "Black" && !cars.get(i).getCarColor().equalsIgnoreCase("Black"))
            {
                carButton[i].setVisible(false);
            }
            if (colorOptions.getValue() == "Blue" && !cars.get(i).getCarColor().equalsIgnoreCase("Blue"))
            {
                carButton[i].setVisible(false);
            }
            if (colorOptions.getValue() == "Green" && !cars.get(i).getCarColor().equalsIgnoreCase("Green"))
            {
                carButton[i].setVisible(false);
            }
            if (colorOptions.getValue() == "Orange" && !cars.get(i).getCarColor().equalsIgnoreCase("Orange"))
            {
                carButton[i].setVisible(false);
            }
            if (colorOptions.getValue() == "Red" && !cars.get(i).getCarColor().equalsIgnoreCase("Red"))
            {
                carButton[i].setVisible(false);
            }
            if (colorOptions.getValue() == "White" && !cars.get(i).getCarColor().equalsIgnoreCase("White"))
            {
                carButton[i].setVisible(false);
            }
            if (colorOptions.getValue() == "Yellow" && !cars.get(i).getCarColor().equalsIgnoreCase("Yellow"))
            {
                carButton[i].setVisible(false);
            }
            
            // check for selection and cars values meet criteria
            if (lessThan400K.isSelected() && cars.get(i).getCarPrice() > 400000)
            {
                // cars over $400K not displayed 
                carButton[i].setVisible(false);
            }
            else if (lessThan300K.isSelected() && cars.get(i).getCarPrice() > 300000)
            {
                // cars over $300K not displayed 
                carButton[i].setVisible(false);
            } 
            else if (lessThan200K.isSelected() && cars.get(i).getCarPrice() > 200000)
            {
                // cars over $200K not displayed 
                carButton[i].setVisible(false); 
            }
            else if (lessThan100K.isSelected() && cars.get(i).getCarPrice() > 100000)
            {
                // cars over $100K not displayed 
                carButton[i].setVisible(false);
            } 
            //else if (anyPrice.isSelected())
            
            // check convertible is selected and if car is convertible 
            if (convertibleYes.isSelected() && cars.get(i).getCarConvertible().equalsIgnoreCase("No")
                    && !convertibleNo.isSelected())
            {
                // not convertible cars are not displayed 
                carButton[i].setVisible(false); 
            }
            else if (convertibleNo.isSelected() && cars.get(i).getCarConvertible().equalsIgnoreCase("Yes")
                    && !convertibleYes.isSelected())
            {
                // convertible cars are not displayed 
                carButton[i].setVisible(false); 
            }
        
        }  // end of for loop
        
    }  // end of method
    
    
    // create all cars
    public void createCars()
    {   
        // initialize array list
        cars = new ArrayList();
        
        // create car in try/catch block to catch exception if picture is not available
        try
        {        
        // create Maserati cars
        cars.add(car1 = new Maserati("Black", "No", new ImageView("cars/BlkMaserati.jpg")));
        cars.add(car2 = new Maserati("Blue", "No", new ImageView("cars/BluMaserati.jpg")));
        cars.add(car3 = new Maserati("Red", "No", new ImageView("cars/RedMaserati.jpg")));
        cars.add(car4 = new Maserati("White", "Yes", new ImageView("cars/WhiteMaserConvertible.jpg")));
        
        // create Aston Martin
        cars.add(car5 = new AstonMartin("Black", "Yes", new ImageView("cars/BlkAstonConvertible.jpg")));
        cars.add(car6 = new AstonMartin("Blue", "No", new ImageView("cars/BluAston.jpg")));
        cars.add(car7 = new AstonMartin("Green", "No", new ImageView("cars/GreenAston.jpg")));
        cars.add(car8 = new AstonMartin("Red", "Yes", new ImageView("cars/RedAstonConvertible2.jpg")));
        
        // create Ferrari cars
        cars.add(car9 = new Ferrari("Black", "Yes", new ImageView("cars/BlkFerrariConvertible.jpg")));
        cars.add(car10 = new Ferrari("Blue", "Yes", new ImageView("cars/BluFerrariConvertible.jpg")));
        cars.add(car11 = new Ferrari("Red", "No", new ImageView("cars/RedFerrari.jpg")));
        cars.add(car12 = new Ferrari("White", "No", new ImageView("cars/WhiteFerrari.jpg")));
        cars.add(car13 = new Ferrari("White", "Yes", new ImageView("cars/WhiteFerrConvertible.jpg")));
        cars.add(car14 = new Ferrari("Yellow", "No", new ImageView("cars/YellowFerrari.jpg")));
        
        // create McLaren cars
        cars.add(car15 = new McLaren("Black", "No", new ImageView("cars/BlkMcLaren.jpg")));
        cars.add(car16 = new McLaren("Blue", "No", new ImageView("cars/BluMcLaren.jpg")));
        cars.add(car17 = new McLaren("Green", "No", new ImageView("cars/GreenMcLaren.jpg")));
        cars.add(car18 = new McLaren("Orange", "Yes", new ImageView("cars/OranMcLarConvertible.jpg")));
        cars.add(car19 = new McLaren("Red", "No", new ImageView("cars/RedMcLaren.jpg")));
        cars.add(car20 = new McLaren("Yellow", "No", new ImageView("cars/YellowMcLaren.jpg")));      
        
        // create Lamborghini cars
        cars.add(car21 = new Lamborghini("Black", "No", new ImageView("cars/BlkLambo.jpg")));
        cars.add(car22 = new Lamborghini("Black", "Yes", new ImageView("cars/BlkLamboConvertible.jpg")));
        cars.add(car23 = new Lamborghini("Blue", "Yes", new ImageView("cars/BluLamboConvertible.jpg")));
        cars.add(car24 = new Lamborghini("Green", "No", new ImageView("cars/GreenLambo.jpg")));
        cars.add(car25 = new Lamborghini("White", "No", new ImageView("cars/WhiteLambo.jpg")));
        cars.add(car26 = new Lamborghini("Yellow", "No", new ImageView("cars/YellowLambo.jpg")));
        }
        catch(Exception e)
        {
            // if exception caught open window to alert user
            JOptionPane.showMessageDialog(null, "The application is unable to find at least one\n" +
                                          "of the car picture in the designated folder.\n" + 
                                          "Contact the developer to fix this issue.");
            System.exit(0);
        }

    }  // end of createCars()
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }  // end of MAIN

    
}  // end of MainWindow class
