/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication28;

import java.io.*;
import java.util.Random;

/**
 *
 * @author rburley
 */
public class Person implements Serializable
{
    //properties
    private String firstName;
    private String lastName;
    private int age;
    private int id;
    
    private static Random nextId;
    
    //constructor
    Person(String fname, String lname, int _age)
    {
        firstName = fname;
        lastName = lname;
        age = _age;
        id = getNextId();
    }
    
    //accessors/mutators
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setFirstName(String fname)
    {
        firstName = fname;
    }
    
    public void setLastName(String lname)
    {
        lastName = lname;
    }
    
    public void setAge(int _age)
    {
        age = _age;
    }
    
    //used by all instances to generate an Id
    private static int getNextId()
    {
        if(nextId == null)
        {
            nextId = new Random();
        }
        
        return nextId.nextInt(1000);
    }
}
