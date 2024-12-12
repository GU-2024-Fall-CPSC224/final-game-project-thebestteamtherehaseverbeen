package edu.gonzaga;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ArtilleryTest {

    @Test
    public void testInitialization() {
        Artillery artillery = new Artillery();

        assertNotNull(artillery);
        assertEquals(Color.RED, artillery.getColor());
        assertEquals(15, artillery.getRadius());
        assertFalse(artillery.getFired());
    }

    @Test
    public void testFireArtillery() {
        Artillery artillery = new Artillery();

        assertFalse(artillery.getFired()); // Ensure not fired initially

        artillery.fireArtillery();
        assertTrue(artillery.getFired()); // Check if the fired flag is set
    }

    @Test
    public void testUpdateCoords() {
        Artillery artillery = new Artillery();

        artillery.fireArtillery(); // Fire the artillery
        artillery.updateCoords(); // Update position

        assertNotNull(artillery.getArtX());
        assertNotNull(artillery.getArtY());

        // Verify that the artillery has moved
        assertTrue(artillery.getArtX() > 0);
        assertTrue(artillery.getArtY() > 0);
    }

    @Test
    public void testSettersAndGetters() {
        Artillery artillery = new Artillery();

        artillery.setPower(50);
        assertEquals(50, artillery.getPower());

        artillery.setHit(true);
        assertTrue(artillery.getHit());

        artillery.setArtX(200);
        assertEquals(200, artillery.getArtX());

        artillery.setArtY(300);
        assertEquals(300, artillery.getArtY());
    }

    @Test
    public void testMove() {
        Artillery artillery = new Artillery();
        artillery.setPower(40);
        artillery.setArtX(100);
        artillery.setArtY(100);

        artillery.move(); // Simulate movement

        // Verify the updated coordinates
        assertEquals(104, artillery.getArtX());
        assertEquals(98, artillery.getArtY());
    }

    @Test
    public void testDraw() {
        Artillery artillery = new Artillery();

        // This test will require creating a mock Graphics object
        // Graphics mocking can be done with libraries like Mockito
        // Left as an exercise as it depends on your setup
    }
}
