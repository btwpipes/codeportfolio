/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication28;

import java.io.*;
import java.io.IOException;
import javax.swing.JOptionPane;

public class JavaApplication28 {

     public static void main(String[] args) {
        try
       {
           /* Data used to create file
           FileOutputStream stream = new FileOutputStream("people.dat");
           ObjectOutputStream objstream = new ObjectOutputStream(stream);
           
           objstream.writeObject(new Person("Icon", "Dothus", 25));
           objstream.writeObject(new Person("Ida", "Mann", 36));
           objstream.writeObject(new Person("Iyla", "Java", 19));
           objstream.writeObject(new Person("Bess", "Ndabiz", 40));
           objstream.writeObject(new Person("Kerry", "Daway", 55));
          */
           
           
           
            //read in data from file and store in an array
            FileInputStream fs = new FileInputStream("people.dat");
            ObjectInputStream os = new ObjectInputStream(fs);

            Person[] people = new Person[5];

            for(int i=0; i < 5; i++)
            {
                people[i] = (Person) os.readObject();
            }

            //prompt user for selection
            String response = JOptionPane.showInputDialog("Enter an ID number or -1 to see a list of all ID numbers");

            //process user response
            if(response != null)
            {
                int id = Integer.parseInt(response);

                if(id == -1)//list all id's
                {
                    for(Person p : people)
                    {
                        System.out.println(p.getId());
                    }
                }
                else //get info on a specific person
                {
                    for(Person p : people)
                    {
                        if(p.getId() == id)
                        {
                            String info = "Name: " + p.getFullName() + "\n";
                            info += "Age: " + p.getAge() + "\n";
                            info += "ID: " + p.getId();

                            JOptionPane.showMessageDialog(null, info);
                        }
                    }
                }
            }

     }
     catch(IOException io)
     {
         System.out.println(io.getMessage());
     }
     catch(ClassNotFoundException ce)
     {
         System.out.println(ce.getMessage());
     }
       
     //clean up GUI thread
     System.exit(0);
    }
    
}
