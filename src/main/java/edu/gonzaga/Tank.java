package edu.gonzaga;

import java.awt.Color;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.joint.RevoluteJoint;
import org.dyn4j.geometry.Rectangle;

public class Tank {
    private Body body;
    private Body barrel;
    private int health;
    private int xCord;
    private int yCord;
    private String color; // String representation of color
    private Color bodyColor; // Actual Color object used for rendering
    private Boolean moved;

    // Dimensions for the tank body and barrel
    private double bodyWidth = 50;
    private double bodyHeight = 30;
    private double barrelWidth = 30;
    private double barrelHeight = 10;

    public Tank(int xCord, int yCord, int health, String color) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.health = health;
        setColor(color); // Set both the string and the actual color

        // Create the tank body with specified dimensions
        this.body = new Body();
        Rectangle tankShape = new Rectangle(bodyWidth, bodyHeight);
        this.body.addFixture(new BodyFixture(tankShape));
        this.body.translate(xCord, yCord);

        // Create the barrel with specified dimensions
        this.barrel = new Body();
        Rectangle barrelShape = new Rectangle(barrelWidth, barrelHeight);
        this.barrel.addFixture(new BodyFixture(barrelShape));
        this.barrel.translate(xCord, yCord + bodyHeight / 2 + barrelHeight / 2); // Position it above the tank
    }
/* we will need to make the tank and then pass it into this method and import swing stuff and then 
probably just make it visible from there. tbd, we might have to add it to a label or something for it 
to be able to call the .setVisible(true) method. we can try and put it in on its own though and just ask chat 
if it does not work
    private void tankGUI(Tank playerTank) {
        playerTank.setVisible(true);
    }
        */

    // Constructors with default dimensions
    public Tank(String color) {
        this(0, 0, 100, color);
    }

    public Tank(int xCord, int yCord, String color) {
        this(xCord, yCord, 100, color);
    }

    public Tank() {
        this(100, 0, 100, "Red");
    }

    // Getters and Setters for dimensions
    public double getBodyWidth() {
        return bodyWidth;
    }

    public void setBodyWidth(double bodyWidth) {
        this.bodyWidth = bodyWidth;
        recreateBody(); // Update the body with new dimensions
    }

    public double getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(double bodyHeight) {
        this.bodyHeight = bodyHeight;
        recreateBody(); // Update the body with new dimensions
    }

    public double getBarrelWidth() {
        return barrelWidth;
    }

    public void setBarrelWidth(double barrelWidth) {
        this.barrelWidth = barrelWidth;
        recreateBarrel(); // Update the barrel with new dimensions
    }

    public double getBarrelHeight() {
        return barrelHeight;
    }

    public void setBarrelHeight(double barrelHeight) {
        this.barrelHeight = barrelHeight;
        recreateBarrel(); // Update the barrel with new dimensions
    }

    // Method to recreate the tank body with updated dimensions
    private void recreateBody() {
        this.body.removeAllFixtures();
        Rectangle tankShape = new Rectangle(bodyWidth, bodyHeight);
        this.body.addFixture(new BodyFixture(tankShape));
    }

    // Method to recreate the barrel with updated dimensions
    private void recreateBarrel() {
        this.barrel.removeAllFixtures();
        Rectangle barrelShape = new Rectangle(barrelWidth, barrelHeight);
        this.barrel.addFixture(new BodyFixture(barrelShape));
    }

    // RevoluteJoint for barrel (unchanged as per your request)
    public RevoluteJoint createBarrelJoint() {
        RevoluteJoint joint = new RevoluteJoint(this.body, this.barrel, this.body.getWorldCenter());
        return joint;
    }

    // Getters and Setters for other properties
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getXCord() {
        return xCord;
    }

    public void setXCord(int xCord) {
        this.xCord = xCord;
    }

    public int getYCord() {
        return yCord;
    }

    public void setYCord(int yCord) {
        this.yCord = yCord;
    }

    public String getColor() {
        return color;
    }

    // Update the string color and the Color object
    public void setColor(String color) {
        this.color = color;
        this.bodyColor = parseColor(color);
    }

    public Color getBodyColor() {
        return bodyColor;
    }

    public Body getBody() {
        return body;
    }


    public Body getBarrel() {
        return barrel;
    }

    // Utility to convert a string into a Color object
    private Color parseColor(String color) {
        switch (color.toLowerCase()) {
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            case "yellow":
                return Color.YELLOW;
            case "black":
                return Color.BLACK;
            case "white":
                return Color.WHITE;
            default:
                return Color.GRAY; // Default color
            
    public Integer moveLeft() {
        if (this.xCord < 5) {
            this.xCord = 0;
            this.body.translate(-this.xCord, 0);
            this.barrel.translate(-this.xCord, 0); // Move the barrel along with the tank
        } else {
            this.xCord -= 5;
            this.body.translate(-5, 0);
            this.barrel.translate(-5, 0); // Move the barrel along with the tank
        }
        moved = true;
        return xCord;
    }

    public Integer moveRight() {
        if (this.xCord > 195) {
            this.xCord = 200;
            this.body.translate(200 - this.xCord, 0);
            this.barrel.translate(200 - this.xCord, 0); // Move the barrel along with the tank
        } else {
            this.xCord += 5;
            this.body.translate(5, 0);
            this.barrel.translate(5, 0); // Move the barrel along with the tank

        }
    }

    public void hit(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public int fire() {
        return 0; // Placeholder for artillery implementation
    }
}
