package edu.gonzaga;

import java.awt.Color;

import java.util.ArrayList;
import java.util.Scanner;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.joint.RevoluteJoint;
import org.dyn4j.geometry.Rectangle;
import java.awt.Graphics;
import java.awt.Color;
/*
 * This class holds all the code under main. This is where the stuff under the abstraction happens.
 */

public class Artillery {
    private Integer power;
    private boolean hit = false;
    private Integer artilleryX;
    private Integer artilleryY;
    private Body body;
    private Color color = Color.RED;

    public Artillery() {
        power = 0;
        artilleryX = 0;
        artilleryY = 0;
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

}