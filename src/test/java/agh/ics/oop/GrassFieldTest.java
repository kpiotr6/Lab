package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GrassFieldTest {
    @Test
    public void canMoveToTest(){
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
        IEngine engine = new SimulationEngine(new MoveDirection[]{}, map, positions);
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.canMoveTo(new Vector2d(18,2)));
    }
    @Test
    public void placeTest(){
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
        assertTrue(map.place(new Animal(map,positions[0])));
        assertThrows(IllegalArgumentException.class,()->{
            map.place(new Animal(map,positions[0]));
        });

        GrassField grassField = (GrassField)map;
        HashMap<Vector2d,IMapElement> elements = grassField.getElements();
        IMapElement k = null;

        for (IMapElement e:elements.values()) {
            if(e instanceof Animal){
                k = e;
                break;
            }
        }
        assertTrue(k.isAt(positions[0]));
    }
    @Test
    public void isOccupiedTest(){
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
        map.place(new Animal(map,positions[0]));
        assertTrue(map.isOccupied(positions[0]));

    }
    @Test
    public void objectAtTest(){
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
        Animal a = new Animal(map,positions[0]);
        map.place(a);
        assertEquals(map.objectAt(new Vector2d(2,2)),a);

    }
}
