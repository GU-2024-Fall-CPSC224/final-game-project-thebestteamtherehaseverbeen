package edu.gonzaga;

import java.awt.Color;
import java.awt.Graphics;

import org.dyn4j.dynamics.Body;

public class Artillery {
    private Integer power;
    private boolean hit = false;
    private Integer artilleryX;
    private Integer artilleryY;
    private Body body;
    private Color color = Color.RED;
    private double radius = 15; // Radius of the artillery projectile

    public Artillery(){
        power = 0;
        artilleryX = 0;
        artilleryY = 0;
        color = Color.RED;
    }

    public Artillery(int startX, int startY, int power) {
        this.power = power;
        this.artilleryX = startX;
        this.artilleryY = startY;
        color = Color.RED;
    }

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

    public double getRadius(){
        return this.radius; 
    }

    public Color getColor(){
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
