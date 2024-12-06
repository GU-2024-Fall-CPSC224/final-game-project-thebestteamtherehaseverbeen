package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TankTest {

    private Tank tank;

    @BeforeEach
    public void setUp() {
        // This runs before each test
        tank = new Tank(100, 10, 100, "Red");
    }

    @Test
    public void testTankConstructor() {
        // Test if the constructor correctly initializes the tank's properties
        assertEquals(100, tank.getHealth(), "Health should be initialized to 100");
        assertEquals(100, tank.getXCord(), "X coordinate should be initialized to 100");
        assertEquals(10, tank.getYCord(), "Y coordinate should be initialized to 10");
        assertEquals("Red", tank.getColor(), "Color should be initialized to Red");
    }

    @Test
    public void testSetters() {
        // Test setters and getters
        tank.setHealth(50);
        tank.setXCord(20);
        tank.setYCord(30);
        tank.setColor("Green");

        assertEquals(50, tank.getHealth(), "Health should be set to 50");
        assertEquals(20, tank.getXCord(), "X coordinate should be set to 20");
        assertEquals(30, tank.getYCord(), "Y coordinate should be set to 30");
        assertEquals("Green", tank.getColor(), "Color should be set to Green");
    }

    @Test
    public void testMoveLeft() {
        // Test moving the tank left
        tank.moveLeft();
        assertEquals(95, tank.getXCord(), "X coordinate should be decremented by 5 after moving left");
        assertEquals(95, tank.getBody().getTransform().getTranslationX(), "Body's X coordinate should match tank's X coordinate");
    }

    @Test
    public void testMoveRight() {
        // Test moving the tank right
        tank.moveRight();
        assertEquals(105, tank.getXCord(), "X coordinate should be incremented by 5 after moving right");
        assertEquals(105, tank.getBody().getTransform().getTranslationX(), "Body's X coordinate should match tank's X coordinate");
    }

    @Test
    public void testMoveLimits() {
        // Test movement limits to ensure the tank can't move beyond the defined boundaries
        tank.setXCord(0); // Set the tank near the left boundary
        tank.moveLeft();
        assertEquals(0, tank.getXCord(), "Tank should not move beyond the left boundary");

        tank.setXCord(200); // Set the tank near the right boundary
        tank.moveRight();
        assertEquals(200, tank.getXCord(), "Tank should not move beyond the right boundary");
    }

    @Test
    public void testTankColor() {
        // Test if the tank's color can be properly set and retrieved
        tank.setColor("Blue");
        assertEquals("Blue", tank.getColor(), "Color should be set to Blue");

        tank.setColor("Yellow");
        assertEquals("Yellow", tank.getColor(), "Color should be set to Yellow");
    }

    @Test
    public void testHealthAfterHit() {
        // Test health reduction after a hit
        tank.hit(20);
        assertEquals(80, tank.getHealth(), "Health should be reduced by 20 after hit");
    }

    @Test
    public void testHealthNeverGoesBelowZero() {
        // Test that health does not go below 0
        tank.hit(200);
        assertEquals(0, tank.getHealth(), "Health should not go below 0");
    }

    @Test
    public void testTankInitializationWithDifferentColors() {
        // Test constructor with different colors
        Tank redTank = new Tank("Red");
        assertEquals("Red", redTank.getColor(), "Color should be Red");

        Tank greenTank = new Tank("Green");
        assertEquals("Green", greenTank.getColor(), "Color should be Green");
    }

    @Test
    public void testTankInitializationWithDifferentCoordinates() {
        // Test constructor with different coordinates
        Tank tankAtPosition = new Tank(50, 100, 100, "Red");
        assertEquals(100, tankAtPosition.getXCord(), "X coordinate should be 100");
        assertEquals(100, tankAtPosition.getYCord(), "Y coordinate should be 100");
    }

    @Test
    public void testBodyInitialization() {
        // Test that the body is properly initialized in the physics world
        assertNotNull(tank.getBody(), "The body should not be null");
    }

    @Test
    public void testMoveAndUpdateBodyPosition() {
        // Test if moving the tank updates the body position
        tank.moveRight();
        assertEquals(tank.getXCord(), tank.getBody().getTransform().getTranslationX(), "Body's X coordinate should match tank's X coordinate");
    }
}
