package edu.gonzaga;
public class Castle {
    private int height;
    private int xCoordinate;

    public Castle() {
        height = 100;
        xCoordinate = 100;
    }

    public Castle(int height, int xCoordinate) {
        this.height = height;
        this.xCoordinate = xCoordinate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getXCord() {
        return xCoordinate;
    }

    public void setXCord(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
}