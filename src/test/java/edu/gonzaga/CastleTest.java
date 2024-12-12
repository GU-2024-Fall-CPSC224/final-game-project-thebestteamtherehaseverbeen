package edu.gonzaga;

import java.awt.Color;

import org.dyn4j.geometry.Rectangle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CastleTest {

    @Test
    public void testDefaultConstructor() {
        Castle castle = new Castle();

        // Validate default properties
        assertEquals(255, castle.bodyWidth, "Default width should be 255");
        assertEquals(600, castle.bodyHeight, "Default height should be 600");
        assertEquals(565, castle.getXCord(), "Default x-coordinate should be 565");
        assertNotNull(castle.body, "Body should be initialized");
    }

    @Test
    public void testParameterizedConstructor() {
        int xCoordinate = 400;
        Castle castle = new Castle(xCoordinate);

        // Validate parameterized properties
        assertEquals(300, castle.bodyWidth, "Width should be 300 for parameterized constructor");
        assertEquals(600, castle.bodyHeight, "Height should be 600 for parameterized constructor");
        assertEquals(xCoordinate, castle.getXCord(), "x-coordinate should match the constructor argument");
        assertNotNull(castle.body, "Body should be initialized");
    }

    @Test
    public void testBodyShape() {
        Castle castle = new Castle();

        // Ensure body has a fixture and validate its shape
        assertNotNull(castle.body, "Body should be initialized");
        assertTrue(castle.body.getFixtures().size() > 0, "Body should have at least one fixture");

        Rectangle shape = (Rectangle) castle.body.getFixtures().get(0).getShape();
        assertEquals(255, shape.getWidth(), 0.001, "Width of the body shape should match");
        assertEquals(600, shape.getHeight(), 0.001, "Height of the body shape should match");
    }

    @Test
    public void testSetAndGetXCord() {
        Castle castle = new Castle();
        int newX = 700;
        castle.setXCord(newX);

        assertEquals(newX, castle.getXCord(), "x-coordinate should update correctly");
    }

    @Test
    public void testDefaultColor() {
        Castle castle = new Castle();

        // Validate the default color
        assertEquals(Color.BLACK, castle.color, "Default color should be BLACK");
    }

   // @Test
   // public void testDraw() {
        // This is a GUI-related method; testing it directly would require mocking or visual validation.
        // For simplicity, ensure it does not throw any errors during execution.

      //  Castle castle = new Castle();
       // assertDoesNotThrow(() -> {
            // Simulate graphics context and call the draw method
           // Graphics g = new MockGraphics();
      //      castle.draw(g);
      //  }, "Draw method should not throw exceptions");
    //}
}
