/***************************************************************************
 * This program display a menu page where a user makes items selection
 * The program display the items selected, after clicking the button the 
 * value display the subtotal, tax, gratuity and grand total.
 *
 * Author: Andre Paquette
 * Last modified: 10/28/18
 * Title: Restaurant Menu Lab
 * Associated class: Item.java, Calculation.java, 
 *                   Component.java, EventHandler.java
 *************************************************************************/

package lab11_restaurantmenu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Lab11_RestaurantMenu extends Application {
    
    // Fields
    ArrayList<Item> items;
    
    
    /**
     * create menu.dat file
     */
    private void initMenuItems()
    {
        try               
        {                        
            FileOutputStream fo = new FileOutputStream("src/menu.dat");                        
            ObjectOutputStream os = new ObjectOutputStream(fo);                                    
            os.writeObject(new Item("Beef", "Filet Mignon", 27.65));                        
            os.writeObject(new Item("Beef", "New York Strip", 22.65));                        
            os.writeObject(new Item("Beef", "Ribeye", 25.65));                        
            os.writeObject(new Item("Beef", "Classic Burger - 100% Agus Beef", 12.65));                                
            os.writeObject(new Item("Chicken", "1/2 Pound Chicken Breast", 17.65));                        
            os.writeObject(new Item("Chicken", "BBQ Chickent Platter", 13.65));                        
            os.writeObject(new Item("Chicken", "Giant Chicken Pot Pie", 12.65));            
            os.writeObject(new Item("Vegetable", "Green beans", 7.15));                        
            os.writeObject(new Item("Vegetable", "Corn", 4.55));                        
            os.writeObject(new Item("Vegetable", "Asparagus", 7.65));                        
            os.writeObject(new Item("Vegetable", "Rice Pilaf", 3.65));            
            os.writeObject(new Item("Beverage", "Iced Tea", 2.35));                        
            os.writeObject(new Item("Beverage", "Fountain Drink", 1.95));                        
            os.writeObject(new Item("Beverage", "Bottled Water", 2.00));               
        }               
        catch(Exception e)               
        {      
            System.out.print(e.getMessage());
        }        
    }
    
    
    /**
     * start method
     * 
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
    
        // call method to loop through menu.dat,
        // and create ArrayList of all items
        createItemArray();
        
        
        // call method to create labels
        Component.createLabel(items);
        
        // call method to create combo boxes
        Component.createComboBox(items);
        
        // call method to set combo boxes values
        Component.setComboBoxValue(items);
        
        // call method to create text fields
        Component.createTextField();
        
        // call method to create text area
        Component.createTextArea();
        
        // call method to create button
        Component.createButton();
        
  
        // create VBox (top menu) with 10px insets,
        // set center aligned, and add components
        VBox selection1 = new VBox(10);
        selection1.setAlignment(Pos.CENTER);
        selection1.getChildren().addAll(Component.label1, Component.combo1, Component.field1);
        
        VBox selection2 = new VBox(10);
        selection2.setAlignment(Pos.CENTER);
        selection2.getChildren().addAll(Component.label2, Component.combo2, Component.field2);
        
        VBox selection3 = new VBox(10);
        selection3.setAlignment(Pos.CENTER);
        selection3.getChildren().addAll(Component.label3, Component.combo3, Component.field3);
        
        VBox selection4 = new VBox(10);
        selection4.setAlignment(Pos.CENTER);        
        selection4.getChildren().addAll(Component.label4, Component.combo4, Component.field4);
        
        
        // create HBox to hold VBox from top menu, set center aligned, 
        // add 40px padding on right side, and add components
        HBox topGroup = new HBox(20);
        topGroup.setAlignment(Pos.CENTER);
        topGroup.setPadding(new Insets (0, 0, 40, 0));
        topGroup.getChildren().addAll(selection1, selection2, 
                                      selection3, selection4);

        
        // create HBox to hold TextArea,
        // set center aligned, and add components
        HBox textAreaBox = new HBox();
        textAreaBox.setAlignment(Pos.CENTER);        
        textAreaBox.getChildren().add(Component.area);
        
        
        // create HBox to hold button,
        // set center aligned, and add components
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(Component.orderButton);
        
        
        // create VBox as main window layout, set alignment
        // set background color, and add components
        VBox mainWindow = new VBox(10);
        mainWindow.setAlignment(Pos.CENTER);
        mainWindow.setStyle("-fx-background-color: #E6F8E0");
        mainWindow.getChildren().addAll(topGroup, textAreaBox, buttonBox);
        
        
        // create window scene, add component, 
        // and set size to 800px X 600px
        Scene scene = new Scene(mainWindow, 800, 600);
        
        
        // change default primaryStage name to window
        // set window title, stage and make visible
        Stage window = primaryStage;
        window.setTitle("Lab11 - Menu");
        window.setScene(scene);
        window.show();
    
    } // end of start method
    
    
    /**
     * method to create item array list that contains menu.dat values
     *@exception Exception
     */ 
    public void createItemArray() throws Exception
    {
        // local variables
        boolean endOfFile = false;
        items = new ArrayList();
        
        // call method to create menu.dat file that hold items
        // no need to run method once menu.dat file is created
        initMenuItems();
        
        // open menu.dat file and create inputFile to hold values
        FileInputStream fstream = new FileInputStream("src/menu.dat");
        ObjectInputStream inputFile = new ObjectInputStream(fstream);
        
        // loop through inputFile to add values in items array list
        while (!endOfFile)
        {
            try
            {            
                items.add((Item)inputFile.readObject());
            }
            catch (Exception e)
            {
                endOfFile = true;
            }   
        }
        
        // close file
        inputFile.close();
        
    }  // end of createItemArray

    
    /**
     **** MAIN method ****
     *@param args
     */
    public static void main(String[] args) {
        launch(args);
        
    }  // end of main
    
    
}  // end of program
