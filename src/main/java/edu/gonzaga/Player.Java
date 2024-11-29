package edu.gonzaga;

public class Player {
    public String name;
    public String color;

    public String getName() { // called from MainGame
        return name;
    }

    public void setName(String name) { // called from MainGame
        this.name = name;
    }

    public String getColor() { // called from MainGame
        System.out.println(color);
        return color;
    }

    public void setColor(String color) { // called from MainGame
        this.color = color;
        System.out.println(color);
    }

    // still need the takeTurn method that is void with parameter of a Tank
}