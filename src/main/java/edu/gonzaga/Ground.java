package edu.gonzaga;

import java.awt.Color;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Rectangle;

public class Ground {
    private Body body; 
    private Color color; 

    public Body getBody(){
        return this.body;
    }

    public Color getColor(){
        return this.color; 
    }
    
    public Ground(int width, int height){
        this.body = new Body(); 
        Rectangle body = new Rectangle(width, height);
        this.body.setMassType(MassType.INFINITE);
    }

}
