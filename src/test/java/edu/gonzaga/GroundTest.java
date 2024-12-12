package edu.gonzaga;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Rectangle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GroundTest {

    @Test
    public void testInitialization() {
        int width = 500;
        int height = 50;
        Ground ground = new Ground(width, height);

        assertNotNull(ground); // Ensure the object is not null
        assertNotNull(ground.getBody()); // Ensure the body is initialized
    }

    @Test
    public void testBodyMassType() {
        Ground ground = new Ground(500, 50);

        // Ensure the body mass type is set to INFINITE
        assertEquals(MassType.INFINITE, ground.getBody().getMass().getType());
    }

    @Test
    public void testBodyDimensions() {
        int width = 500;
        int height = 50;
        Ground ground = new Ground(width, height);

        // Extract the rectangle shape from the body
        Body body = ground.getBody();
        assertTrue(body.getFixtures().size() > 0, "Body should have at least one fixture");

        Rectangle shape = (Rectangle) body.getFixtures().get(0).getShape();

        // Validate the dimensions
        assertEquals(width, shape.getWidth(), 0.001, "Width should match");
        assertEquals(height, shape.getHeight(), 0.001, "Height should match");
    }

    @Test
    public void testDefaultColor() {
        Ground ground = new Ground(500, 50);

        // Ensure default color is null (as it's not set in the constructor)
        assertNull(ground.getColor());
    }
}
