package edu.gonzaga;

public class Player {

    private String name;
    private Tank tank;

    public Player() {
        tank = new Tank();

    }

    public void setColor(String color) {
        this.tank.setColor(color);
    }

    public Tank getTank() {
        return this.tank;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void takeTurn() {

    }
}
