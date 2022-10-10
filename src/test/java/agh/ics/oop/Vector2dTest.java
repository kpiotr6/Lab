package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        Vector2d v3 = new Vector2d(2,1);
        assertEquals(v1,v2);
        assertNotEquals(v2,v3);
        assertEquals(v1,v1);
    }
    @Test
    public void toStringTest(){
        String test = new Vector2d(1,2).toString();
        assertEquals(test,"(1,2)");
        assertNotEquals(test,"(1,1)");
    }
    @Test
    public void precedsTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(0,-2);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(4,1);
        assertTrue(v1.precedes(v3));
        assertTrue(v2.precedes(v4));
        assertFalse(v3.precedes(v1));
    }
    @Test
    public void followsTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(0,-2);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(4,1);
        assertFalse(v1.follows(v3));
        assertFalse(v2.follows(v4));
        assertTrue(v3.follows(v1));
    }
    @Test
    public void upperRightTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(0,-2);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(4,1);
        assertEquals(v1.upperRight(v2),v1);
        assertEquals(v3.upperRight(v4),new Vector2d(4,3));
    }
    @Test
    public void lowerLeftTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(0,-2);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(4,1);
        assertEquals(v1.lowerLeft(v2),v2);
        assertEquals(v3.lowerLeft(v4),new Vector2d(1,1));
    }
    @Test
    public void addTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(0,-2);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(4,1);
        assertEquals(v1.add(v2),new Vector2d(1,0));
        assertEquals(v3.add(v4),new Vector2d(5,4));
    }
    @Test
    public void substractTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(0,-2);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(4,1);
        assertEquals(v1.substract(v2),new Vector2d(1,4));
        assertEquals(v3.substract(v4),new Vector2d(-3,2));
    }
    @Test
    public void oppositeTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(-1,-2);
        assertEquals(v1,v2.opposite());
    }
}
