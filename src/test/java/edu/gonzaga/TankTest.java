package edu.gonzaga;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class TankTest {

    @Test
    public void testInitialization() {
        Tank tank = new Tank(50, 100, 150, "Blue");

        assertEquals(50, tank.getXCord());
        assertEquals(100, tank.getYCord());
        assertEquals(150, tank.getHealth());
        assertEquals("Blue", tank.getColor());
        assertEquals(Color.BLUE, tank.getBodyColor());
    }

    @Test
    public void testDefaultConstructor() {
        Tank tank = new Tank();

        assertEquals(100, tank.getXCord());
        assertEquals(0, tank.getYCord());
        assertEquals(100, tank.getHealth());
        assertEquals("Red", tank.getColor());
        assertEquals(Color.RED, tank.getBodyColor());
    }

    @Test
    public void testSetAndGetDimensions() {
        Tank tank = new Tank();

        tank.setBodyWidth(90);
        assertEquals(90, tank.getBodyWidth());

        tank.setBodyHeight(60);
        assertEquals(60, tank.getBodyHeight());

        tank.setBarrelWidth(40);
        assertEquals(40, tank.getBarrelWidth());

        tank.setBarrelHeight(15);
        assertEquals(15, tank.getBarrelHeight());
    }

    @Test
    public void testMovementLeftAndRight() {
        Tank tank = new Tank(50, 100, 150, "Green");

        // Move left
        int newXCord = tank.moveLeft();
        assertEquals(45, newXCord);

        // Move right
        newXCord = tank.moveRight();
        assertEquals(50, newXCord);

        // Boundary conditions
        tank.setXCord(0);
        assertEquals(0, tank.moveLeft()); // Shouldn't move left past 0

        tank.setXCord(200);
        assertEquals(200, tank.moveRight()); // Shouldn't move right past 200
    }

    @Test
    public void testColorParsing() {
        Tank tank = new Tank();

        tank.setColor("Yellow");
        assertEquals(Color.YELLOW, tank.getBodyColor());

        tank.setColor("InvalidColor");
        assertEquals(Color.GRAY, tank.getBodyColor()); // Default color
    }

    @Test
    public void testHealthReduction() {
        Tank tank = new Tank(50, 100, 150, "Blue");

        tank.hit(30);
        assertEquals(120, tank.getHealth());

        tank.hit(200);
        assertEquals(0, tank.getHealth()); // Health cannot drop below 0
    }

    @Test
    public void testFire() {
        Tank tank = new Tank(100, 100, 150, "Red");

        int power = tank.fire();

        // Check if artillery is fired with correct power
        assertEquals(50, power);

        // The GUI for firing is hard to unit test; focus on artillery setup
    }

    @Test
    public void testBarrelJoint() {
        Tank tank = new Tank(50, 100, 150, "Blue");

        var joint = tank.createBarrelJoint();
        assertNotNull(joint);

        // Check the bodies connected by the joint
        assertEquals(tank.getBody(), joint.getBody1());
        assertEquals(tank.getBarrel(), joint.getBody2());
    }

    // Note: GUI rendering tests like `draw` require mock Graphics object and are better suited for integration tests
}
