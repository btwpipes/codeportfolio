/****************************************************************
 * This class creates labels, combo boxes, text fields
 * test area, button, drop shadow, and set combo boxes values
 *
 * Author: Andre Paquette
 * Last modified: 10/28/18
 * Associated to: Lab11_RestaurantMenu.java
 ****************************************************************/
package lab11_restaurantmenu;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Component {
    
    // Fields
    static Label label1 = new Label(),
                 label2 = new Label(),
                 label3 = new Label(),
                 label4 = new Label();
    
    static ComboBox combo1 = new ComboBox(),
                    combo2 = new ComboBox(),
                    combo3 = new ComboBox(),
                    combo4 = new ComboBox();
    
    static TextField field1,
                     field2,
                     field3,
                     field4;
    
    static TextArea area;
    static Button orderButton;
    static DropShadow dropShadow;

    
    /**
     * create labels
     * 
     * @param items
     */
    public static void createLabel(ArrayList<Item> items)
    {
                // loop to set value to labels
        // set font to Verdana bold 14pt and orange
        for (int i = 0; i < items.size(); i++)
        {
            if (label1.getText().equals(""))
            {
                label1 = new Label(items.get(i).getType()); 
                label1.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
                label1.setStyle("-fx-text-fill: #DF7401;");
            }
            if (label2.getText().equals("") && !items.get(i).getType().equals(label1.getText()))
            {
                label2 = new Label(items.get(i).getType());
                label2.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
                label2.setStyle("-fx-text-fill: #DF7401;");
            }
            if (label3.getText().equals("") && !items.get(i).getType().equals(label1.getText()) &&
                    !items.get(i).getType().equals(label2.getText()))
            {
                label3 = new Label(items.get(i).getType());
                label3.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
                label3.setStyle("-fx-text-fill: #DF7401;");
            }
            if (label4.getText().equals("") && !items.get(i).getType().equals(label1.getText()) &&
                    !items.get(i).getType().equals(label2.getText()) && 
                    !items.get(i).getType().equals(label3.getText()))
            {
                label4 = new Label(items.get(i).getType());    
                label4.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
                label4.setStyle("-fx-text-fill: #DF7401;");
            }
        }
    }

    
    /**
     * create drop shadow
     */
    public static void createDropShadow()
    {
        // create drop shadow effect (used on button)
        dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        dropShadow.setColor(Color.color(0.5, 0.5, 0.5));
    }
    
    
    /**
     * create combo boxes
     * 
     * @param items
     */
    public static void createComboBox(ArrayList<Item> items)
    {
        // create ComboBox, and set 1st selection to none
        combo1.getItems().add("- none -");
        combo1.getSelectionModel().selectFirst();
        EventHandler.combo1Action(items);
        
        combo2.getItems().add("- none -");
        combo2.getSelectionModel().selectFirst();
        EventHandler.combo2Action(items);
        
        combo3.getItems().add("- none -");
        combo3.getSelectionModel().selectFirst();
        EventHandler.combo3Action(items);
        
        combo4.getItems().add("- none -");
        combo4.getSelectionModel().selectFirst();
        EventHandler.combo4Action(items);
    }
    
    
    /**
     * set combo boxes values
     * 
     * @param items
     */
    public static void setComboBoxValue(ArrayList<Item> items)
    {
        // for each loop to set up combo boxes values 
        for (Item r : items)
        {   
            // set beef type ComboBox
            if (r.getType().equalsIgnoreCase(items.get(0).getType()))
            {
                combo1.getItems().add(r.getDescription());
            }
            
            // set chicken type ComboBox
            if (r.getType().equalsIgnoreCase(items.get(4).getType()))
            {
                combo2.getItems().add(r.getDescription());
            }
            
            // set vegetable type ComboBox
            if (r.getType().equalsIgnoreCase(items.get(7).getType()))
            {
                combo3.getItems().add(r.getDescription());
            }
            
            // set drink type ComboBox
            if (r.getType().equalsIgnoreCase(items.get(11).getType()))
            { 
                combo4.getItems().add(r.getDescription());
            }
        
        }  // end of for each loop
    }
    
    
    /**
     * create text fields
     */
    public static void createTextField()
    {
        // create TextField, set starting value to $0.00,
        // and set fields so user cannot edit
        field1 = new TextField(String.format("%,.2f", 0.0));
        field1.setEditable(false);
        
        field2 = new TextField(String.format("%,.2f", 0.0));
        field2.setEditable(false);
        
        field3 = new TextField(String.format("%,.2f", 0.0));
        field3.setEditable(false);
        
        field4 = new TextField(String.format("%,.2f", 0.0));
        field4.setEditable(false);
    }
    
    
    /**
     * create text area
     */
    public static void createTextArea()
    {
        // create TextArea, set size, and set editable
        area = new TextArea();
        area.setPrefHeight(350);
        area.setPrefWidth(300);  
        area.setEditable(false);
    }
    
    
    /**
     * create button
     */
    public static void createButton()
    {
        // create Button, set button text
        // set drop shadow, and set font
        createDropShadow();
        orderButton = new Button();
        orderButton.setText("Order"); 
        orderButton.setEffect(dropShadow);
        orderButton.setFont(Font.font("Serif", FontWeight.BOLD, 14));
        
        EventHandler.buttonAction();
    }
}
