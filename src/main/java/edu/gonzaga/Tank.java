package edu.gonzaga;

import java.awt.geom.AffineTransform;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JFrame gameOverFrame = new JFrame();

    // Dimensions for the tank body and barrel
    private double bodyWidth = 80;
    private double bodyHeight = 50;
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
        }
    }

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
        this.moved = true;
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
        this.moved = true;
        return xCord;
    }

    public void hit(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    // Inside the Tank class, add the draw method
    public void draw(Graphics g, Tank tank, Tank tank1, Tank tank2, Artillery newArtillery) {
        if (tank == tank1) {
            Graphics2D g2d = (Graphics2D) g; // Cast Graphics to Graphics2D for advanced features
            // Save the current transformation state
            AffineTransform originalTransform = g2d.getTransform();
            // Draw the body of the tank
            g2d.setColor(this.bodyColor);
            g2d.fillRect(this.xCord, this.yCord, (int) this.bodyWidth, (int) this.bodyHeight);
            // Adjust the barrel base coordinates to move it up and to the right
            int barrelBaseX = this.xCord + 30; // Move farther right from the body
            int barrelBaseY = ((int) (this.yCord + bodyHeight / 2 - 10)) - 13; // Move higher up
            // Move the origin to the new barrel's base
            g2d.translate(barrelBaseX, barrelBaseY);
            // Rotate the barrel to 45 degrees (in radians)
            g2d.rotate(Math.toRadians(-45)); // -45 degrees for an upward angle
            // Draw the barrel at the new rotated position
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, -(int) (barrelHeight / 2), (int) barrelWidth, (int) barrelHeight);
            // Restore the original transformation state
            g2d.setTransform(originalTransform);
            newArtillery.draw(g, tank);
            newArtillery.setLocation((tank.getXCord()) + 55, (tank.getYCord() - 20));
            newArtillery.setArtX((tank.getXCord()) + 55);
            // newArtillery.setArtY(tank.getY);
        } else {
            Graphics2D g2d = (Graphics2D) g; // Cast Graphics to Graphics2D for advanced features
            // Save the current transformation state
            AffineTransform originalTransform = g2d.getTransform();
            // Draw the body of the tank
            g2d.setColor(this.bodyColor);
            g2d.fillRect(this.xCord, this.yCord, (int) this.bodyWidth, (int) this.bodyHeight);
            // Adjust the barrel base coordinates to move it up and to the right
            int barrelBaseX = this.xCord + 10; // Move farther right from the body
            int barrelBaseY = ((int) (this.yCord + bodyHeight / 2 - 10)) - 30; // Move higher up
            // Move the origin to the new barrel's base
            g2d.translate(barrelBaseX, barrelBaseY);
            // Rotate the barrel to 45 degrees (in radians)
            g2d.rotate(Math.toRadians(45)); // -45 degrees for an upward angle
            // Draw the barrel at the new rotated position
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, -(int) (barrelHeight / 2), (int) barrelWidth, (int) barrelHeight);
            // Restore the original transformation state
            g2d.setTransform(originalTransform);
            newArtillery.draw(g, tank);
            newArtillery.setLocation((tank.getXCord()) + 10, (tank.getYCord()) - 20);
        }

    }

    public int fire(Tank tank1, JFrame gameFrame, Artillery newArtillery) {
        // Set initial properties of the artillery
        newArtillery.setPower(50); // Initial velocity
        double angle = Math.toRadians(45); // Launch angle in radians
        newArtillery.setArtX(200); // Starting X position
        newArtillery.setArtY(500); // Starting Y position (lower on the screen)

        // Calculate initial velocity components
        double velocityX = newArtillery.getPower() * Math.cos(angle);
        double velocityY = -newArtillery.getPower() * Math.sin(angle); // Negative for upward direction
        double gravity = 9.8; // Gravitational constant
        double timeStep = 0.05; // Time step for updates

        // Create a panel to render the artillery
        JPanel firePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set color for artillery
                g.setColor(newArtillery.getColor());
                // Draw the artillery as a circle
                g.fillOval(0, 0, (int) (newArtillery.getRadius() * 2), (int) (newArtillery.getRadius() * 2));
            }
        };

        // Set panel properties
        int artilleryDiameter = (int) (newArtillery.getRadius() * 2);
        firePanel.setBounds(newArtillery.getArtX(), newArtillery.getArtY(), artilleryDiameter, artilleryDiameter);
        firePanel.setOpaque(false); // Transparent background

        // Add the panel to the frame
        gameFrame.setLayout(null); // Absolute positioning
        gameFrame.add(firePanel);
        gameFrame.revalidate();
        gameFrame.repaint();

        // Timer for animating the projectile
        Timer timer = new Timer((int) (timeStep * 1000), new ActionListener() {
            double time = 0; // Elapsed time

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update time
                time += timeStep;

                // Update positions based on projectile motion equations
                int newX = (int) (200 + velocityX * time);
                int newY = (int) (500 - (velocityY * time - 0.5 * gravity * time * time));

                // Stop the timer if the projectile hits the ground
                if (newY > gameFrame.getHeight()) {
                    ((Timer) e.getSource()).stop();
                    gameFrame.remove(firePanel);
                    gameFrame.repaint();
                    return;
                }

                // Update the artillery's position
                newArtillery.setArtX(newX);
                newArtillery.setArtY(newY);

                // Update panel location and repaint
                firePanel.setBounds(newX, newY, artilleryDiameter, artilleryDiameter);
                gameFrame.repaint();
            }
        });

        // Start the timer
        timer.start();

        return newArtillery.getPower(); // Return the power as a result
    }

    public void gameOverScreen() {
        JLabel gameOverLabelBackground = new JLabel();
        ImageIcon gameOverIcon = new ImageIcon("game_over.png");
        gameOverLabelBackground.setIcon(gameOverIcon);
        gameOverLabelBackground.setSize(1100, 700);
        gameOverLabelBackground.setHorizontalAlignment(JLabel.CENTER);
        JLabel gameOverLabel = new JLabel("GAME OVER");
        gameOverLabel.setFont(new Font("Algerian", Font.BOLD, 100));
        JPanel gameOverScreenPanel = new JPanel(new BorderLayout());
        gameOverFrame.setBackground(Color.black);
        gameOverLabel.setForeground(Color.red);
        gameOverScreenPanel.add(gameOverLabelBackground, BorderLayout.CENTER);
        gameOverFrame.add(gameOverScreenPanel);
        gameOverFrame.setSize(1200, 800);
        gameOverFrame.setLocation(90, 75);
        gameOverFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameOverFrame.setVisible(true);
    }

    public void tsunami(Tank tank1, JFrame gameFrame, Artillery newArtillery) {
        // Create a new JFrame for the tsunami effect
        JFrame tsunamiFrame = new JFrame();
        tsunamiFrame.setLayout(new BorderLayout());
        tsunamiFrame.setSize(1100, 800); // Set the size of the frame
        tsunamiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel for the tsunami effect (blue background)
        JPanel tsunamiPanel = new JPanel();
        tsunamiPanel.setBackground(Color.blue);
        tsunamiFrame.add(tsunamiPanel, BorderLayout.CENTER);

        // Make sure the frame is visible
        tsunamiFrame.setVisible(true);

        // Optional: Debugging statement to confirm visibility
        System.out.println("Tsunami frame created and visible.");
    }
}