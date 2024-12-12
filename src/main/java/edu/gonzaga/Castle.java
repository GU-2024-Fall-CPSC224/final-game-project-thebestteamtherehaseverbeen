package edu.gonzaga;
import java.awt.Color;
import java.awt.Graphics;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Rectangle;

public class Castle {
    public int xCoordinate;
    public Body body; 
    public Color color = Color.BLACK; 

    public int bodyWidth = 150;
    public int bodyHeight = 300;

    public Castle() {
        color = Color.BLACK; 
        bodyHeight = 600;
        bodyWidth = 255; 
        xCoordinate = 565;

        this.body = new Body(); 
        Rectangle castleShape = new Rectangle(bodyWidth, bodyHeight); 
        this.body.addFixture(new BodyFixture(castleShape)); 
    }

    public Castle(int xCoordinate) {
        this.bodyHeight = 600; 
        this.bodyWidth = 300;
        this.xCoordinate = xCoordinate;
        
        this.body = new Body(); 
        Rectangle castleShape = new Rectangle(bodyWidth, bodyHeight); 
        this.body.addFixture(new BodyFixture(castleShape)); 
    }

    public int getXCord() {
        return xCoordinate;
    }

    public void setXCord(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillRect(xCoordinate, 300, bodyWidth, bodyHeight); 
    }
}