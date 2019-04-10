/************************************************************************
 * This class contains Event Handlers for the combo boxes and button
 *
 * Author: Andre Paquette
 * Last modified: 10/28/18
 * Associated to: Lab11_RestaurantMenu.java
 ***********************************************************************/
package lab11_restaurantmenu;

import java.util.ArrayList;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import static lab11_restaurantmenu.Component.label1;


public class EventHandler {
    
// Fields
    static String pick1 = "",
                  pick2 = "",
                  pick3 = "",
                  pick4 = "";

    
    /** 
     * button event handler
     */    
    public static void buttonAction()
    {
        // orderButton event handler as lambda expression
        Component.orderButton.setOnAction(e ->
        {
            // clear text area
            Component.area.setText("");
            
            // call subTotal method to calculate selected item price
            Calculation.subTotal(Component.field1, Component.field2, Component.field3, Component.field4);
                
            // set text area with top menu values only
            // if selection is not equal to "- none -"  
            if (!Component.combo1.getValue().equals("- none -"))
            {
                Component.area.appendText(String.format("%s: $%s\n", Component.combo1.getValue(), Component.field1.getText()));
            }
            if (!Component.combo2.getValue().equals("- none -"))
            {
                Component.area.appendText(String.format("%s: $%s\n", Component.combo2.getValue(), Component.field2.getText()));
            }
            if (!Component.combo3.getValue().equals("- none -"))
            {
                Component.area.appendText(String.format("%s: $%s\n", Component.combo3.getValue(), Component.field3.getText()));
            }
            if (!Component.combo4.getValue().equals("- none -"))
            {
                Component.area.appendText(String.format("%s: $%s", Component.combo4.getValue(), Component.field4.getText()));
            }
            
            // set text area with calculation values
            // using appendText() not to clear the text area from top menu values
            if (Calculation.total() != 0)
            {
                Component.area.appendText(String.format("\n\n----------------------------------------\n" + 
                                          "Subtotal:\t\t\t\t$%,.2f\n" +
                                          "Sales Tax:\t\t\t\t$ %,.2f\n" +
                                          "Gratuity:\t\t\t\t$ %,.2f\n\n" +
                                          "Grand Total:\t\t\t$%,.2f", Calculation.subtotal,
                                          Calculation.salesTax(), Calculation.gratuity(),
                                          Calculation.total())); 
            }
            else
            {
                Component.area.setText("You did not select any item for your order!");
                Component.area.setFont(Font.font("Serif", FontWeight.BOLD, 14));
                Component.area.setStyle("-fx-text-fill: red;");
            }
            
        });  // end place order button lambda expression
    }
    
    
    /** 
     * combo box combo1 event handler
     * 
    * @param items
     */
    public static void combo1Action(ArrayList<Item> items)
    {
        // ComboBox combo1 event handler as lambda expression
        Component.combo1.setOnAction(e -> 
        {
            // loop to iterate through array list
            for (int i = 0; i < items.size(); i++)
            {
                // condition in order to set text field
                if (Component.combo1.getValue().equals(items.get(i).getDescription()))
                {
                    Component.field1.setText(String.format("%,.2f", items.get(i).getPrice()));
                }
                else if (Component.combo1.getValue().equals("- none -"))
                {
                    Component.field1.setText(String.format("%,.2f", 0.0));
                }

                // condition to set pick from user and format string
                if (Component.combo1.getValue().equals(items.get(i).getDescription()))
                {
                    pick1 = String.format("ITEM:\n" +
                                               "   • Type: %s\n" +
                                               "   • Description: %s\n" +
                                               "   • Price: $%,.2f\n\n", items.get(i).getType(),
                                               items.get(i).getDescription(),
                                               items.get(i).getPrice());
                }
                else if (Component.combo1.getValue().equals("- none -"))
                {
                    pick1 = "";
                }
            }
            
            // set text area based on user picks
            Component.area.setText(String.format("%s%s%s%s", pick1, pick2, pick3, pick4));
        
        }); // end combo1 lambda expression
    }
    
    
    /** 
     * combo box combo2 event handler
     * 
    * @param items
     */
    public static void combo2Action(ArrayList<Item> items)
    {
        // ComboBox combo2 event handler as lambda expression
        Component.combo2.setOnAction(e ->
        {
            // loop to iterate through array list
            for (int i = 0; i < items.size(); i++)
            {
                // condition in order to set text field
                if (Component.combo2.getValue().equals(items.get(i).getDescription()))
                {
                    Component.field2.setText(String.format("%,.2f", items.get(i).getPrice()));
                }
                else if (Component.combo2.getValue().equals("- none -"))
                {
                    Component.field2.setText(String.format("%,.2f", 0.0));
                }

                // condition to set pick from user and format string
                if (Component.combo2.getValue().equals(items.get(i).getDescription()))
                {
                    pick2 = String.format("ITEM:\n" +
                                          "   • Type: %s\n" +
                                          "   • Description: %s\n" +
                                          "   • Price: $%,.2f\n\n", 
                                          items.get(i).getType(),
                                          items.get(i).getDescription(),
                                          items.get(i).getPrice());
                }
                else if (Component.combo2.getValue().equals("- none -"))
                {
                    pick2 = "";
                }
            }

            // set text area based on user picks
            Component.area.setText(String.format("%s%s%s%s", pick1, pick2, pick3, pick4));
                    
        });  // end combo2 lambda expression    
    }
    
    
    /** 
     * combo box combo3 event handler
     * 
    * @param items
     */    
    public static void combo3Action(ArrayList<Item> items)
    {
        // ComboBox combo3 event handler as lambda expression
        Component.combo3.setOnAction(e ->
        {
            // loop to iterate through array list
            for (int i = 0; i < items.size(); i++)
            {
                // condition in order to set text field
                if (Component.combo3.getValue().equals(items.get(i).getDescription()))
                {
                    Component.field3.setText(String.format("%,.2f", items.get(i).getPrice()));
                }
                else if (Component.combo3.getValue().equals("- none -"))
                {
                    Component.field3.setText(String.format("%,.2f", 0.0));
                }

                // condition to set pick from user and format string
                if (Component.combo3.getValue().equals(items.get(i).getDescription()))
                {
                    pick3 = String.format("ITEM:\n" +
                                               "   • Type: %s\n" +
                                               "   • Description: %s\n" +
                                               "   • Price: $%,.2f\n\n", items.get(i).getType(),
                                               items.get(i).getDescription(),
                                               items.get(i).getPrice());
                }
                else if (Component.combo3.getValue().equals("- none -"))
                {
                    pick3 = "";
                }
            }
            
            Component.area.setText(String.format("%s%s%s%s", pick1, pick2, pick3, pick4));
        });  // end combo3 lambda expression
    }
    
    
    /** 
     * combo box combo4 event handler
     * 
    * @param items
     */
    public static void combo4Action(ArrayList<Item> items)
    {
        // ComboBox combo4 event handler as lambda expression
        Component.combo4.setOnAction(e ->
        {
            // loop to iterate through array list
            for (int i = 0; i < items.size(); i++)
            {
                // condition in order to set text field
                if (Component.combo4.getValue().equals(items.get(i).getDescription()))
                {
                    Component.field4.setText(String.format("%,.2f", items.get(i).getPrice()));
                }
                else if (Component.combo4.getValue().equals("- none -"))
                {
                    Component.field4.setText(String.format("%,.2f", 0.0));
                }

                // condition to set pick from user and format string
                if (Component.combo4.getValue().equals(items.get(i).getDescription()))
                {
                    pick4 = String.format("ITEM:\n" +
                                               "   • Type: %s\n" +
                                               "   • Description: %s\n" +
                                               "   • Price: $%,.2f", items.get(i).getType(),
                                               items.get(i).getDescription(),
                                               items.get(i).getPrice());
                }
                else if (Component.combo4.getValue().equals("- none -"))
                {
                    pick4 = "";
                }
            }
            
            // set text area based on user picks
            Component.area.setText(String.format("%s%s%s%s", pick1, pick2, pick3, pick4));
        
        });  // end combo4 lambda expression    
    }
    
}  // end of EventHandler class
