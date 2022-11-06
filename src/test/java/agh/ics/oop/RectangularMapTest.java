package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RectangularMapTest {
    @Test
    public void canMoveToTest(){
        IWorldMap map = new RectangularMap(30,40);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
        IEngine engine = new SimulationEngine(new MoveDirection[]{}, map, positions);
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.canMoveTo(new Vector2d(18,2)));
    }
    @Test
    public void placeTest(){
        IWorldMap map = new RectangularMap(30,40);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
        assertTrue(map.place(new Animal(map,positions[0])));
        assertFalse(map.place(new Animal(map,positions[0])));
        RectangularMap rectangularMap = (RectangularMap)map;
        List<IMapElement> elements = rectangularMap.getElements();
        IMapElement k = null;
        for (IMapElement e:elements) {
            if(e instanceof Animal){
                k = e;
                break;
            }
        }
        assertTrue(k.isAt(positions[0]));
    }
    @Test
    public void isOccupiedTest(){
        IWorldMap map = new RectangularMap(30,40);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
        map.place(new Animal(map,positions[0]));
        assertTrue(map.isOccupied(positions[0]));

    }
    @Test
    public void objectAtTest(){
        IWorldMap map = new RectangularMap(30,40);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
        Animal a = new Animal(map,positions[0]);
        map.place(a);
        assertEquals(map.objectAt(new Vector2d(2,2)),a);

    }
}
