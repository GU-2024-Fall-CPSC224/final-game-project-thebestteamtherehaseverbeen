package edu.gonzaga;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * This class holds all the code under main. This is where the stuff under the abstraction happens.
 */

public class Player {
    public String name;
    public String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public String getColor() {
        return color; 
    }


    public void setColor(String color) {
        this.color = color;
    }

    //still need the takeTurn method that is void with parameter of a Tank
}