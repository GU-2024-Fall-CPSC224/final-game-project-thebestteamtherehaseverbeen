package edu.gonzaga;

import java.awt.Color;
import java.awt.Graphics;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Circle;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;

public class Artillery {
    private Integer power;
    private boolean hit = false;
    private Integer artilleryX;
    private Integer artilleryY;
    private Body artillery;
    private Color color = Color.RED;
    private double radius = 15; // Radius of the artillery projectile
    private Boolean fired = false;

    public Artillery() {
        artillery = new Body();
        Circle shape = new Circle(1.0); // A circle with radius 1.0
        artillery.addFixture(shape);
        artillery.setMass(MassType.NORMAL);
        artillery.translate(100, 300);
    }

    public void fireArtillery() {
        // Apply an impulse to the artillery (let's say a force of 20 in the x-direction
        // and 10 in the y-direction)
        Vector2 impulse = new Vector2(20.0, -10.0); // Apply an impulse to simulate firing
        artillery.applyImpulse(impulse, artillery.getWorldCenter());
        fired = true;
    }

    public void updateCoords() {
        // Step the physics simulation by one time step (e.g., 1/60th of a second)
        // world.update(1.0 / 60.0);

        // Update artillery's position (if fired)
        if (fired) {
            artilleryX = (int) artillery.getWorldCenter().x;
            artilleryY = (int) artillery.getWorldCenter().y;
        }

        // Repaint the panel to show the updated position
        // repaint();
    }

    public Boolean getFired() {
        return fired;
    }

    /*
     * public Artillery(){
     * power = 0;
     * artilleryX = 0;
     * artilleryY = 0;
     * color = Color.RED;
     * }
     * 
     * public Artillery(int startX, int startY, int power) {
     * this.power = power;
     * this.artilleryX = startX;
     * this.artilleryY = startY;
     * color = Color.RED;
     * }
     */

    public void setPower(Integer x) {
        power = x;
    }

    public void setHit(boolean ifHit) {
        hit = ifHit;
    }

    public void setArtX(Integer xCoor) {
        artilleryX = xCoor;
    }

    public void setArtY(Integer yCoor) {
        artilleryY = yCoor;
    }

    public Integer getPower() {
        return this.power;
    }

    public Boolean getHit() {
        return this.hit;
    }

    public Integer getArtX() {
        return this.artilleryX;
    }

    public Integer getArtY() {
        return this.artilleryY;
    }

    public double getRadius() {
        return this.radius;
    }

    public Color getColor() {
        return this.color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(artilleryX - (int) radius, artilleryY - (int) radius, (int) radius * 2, (int) radius * 2);
    }

    public void move() {
        if (!hit) {
            artilleryX += power / 10; // Adjust speed horizontally
            artilleryY -= power / 20; // Simulate upward movement (gravity effect to be added)
        }
    }

}
