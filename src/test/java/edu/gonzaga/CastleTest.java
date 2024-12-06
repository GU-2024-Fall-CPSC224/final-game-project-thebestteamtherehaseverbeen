package edu.gonzaga;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CastleTest {
    @Test
    void equalsTest() {
        int x = 1;
        int y = 1;
        Assertions.assertEquals(x, y);
    }


    @Test
    void testXCord() {
        Castle castle = new Castle();
        int xCordTest = 200;
        castle.setXCord(xCordTest);
        assertEquals(castle.getXCord(), xCordTest);
    } 

}
