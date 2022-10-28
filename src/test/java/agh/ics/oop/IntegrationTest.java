package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrationTest {

    @Test
    public void testMap1(){
        String commands = "f b r l f f r r f f f f f f f f";
        MoveDirection[] directions = new OptionsParser().parse(commands.split(" "));
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        SimulationEngine simulationEngine = (SimulationEngine)engine;
        engine.run();
        List<Animal> a = simulationEngine.getAnimals();
        assertEquals(a.get(0).getPosition(),new Vector2d(2,0));
        assertEquals(a.get(1).getPosition(),new Vector2d(3,4));
        assertEquals(a.get(0).getMapDirection(),MapDirection.SOUTH);
        assertEquals(a.get(1).getMapDirection(),MapDirection.NORTH);
    }
    @Test
    public void testMap2(){
        String commands = "f f f r r r f f f";
        MoveDirection[] directions = new OptionsParser().parse(commands.split(" "));
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(0,2), new Vector2d(0,3),new Vector2d(0,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        SimulationEngine simulationEngine = (SimulationEngine)engine;
        engine.run();
        List<Animal> a = simulationEngine.getAnimals();
        assertEquals(a.get(0).getPosition(),new Vector2d(1,2));
        assertEquals(a.get(1).getPosition(),new Vector2d(1,3));
        assertEquals(a.get(2).getPosition(),new Vector2d(1,4));
        assertEquals(a.get(0).getMapDirection(),MapDirection.EAST);
        assertEquals(a.get(1).getMapDirection(),MapDirection.EAST);
        assertEquals(a.get(2).getMapDirection(),MapDirection.EAST);
    }
    @Test
    public void testMap3(){
        String commands = "f r r r f f f r r f f";
        MoveDirection[] directions = new OptionsParser().parse(commands.split(" "));
        IWorldMap map = new RectangularMap(2, 2);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        SimulationEngine simulationEngine = (SimulationEngine)engine;
        engine.run();
        List<Animal> a = simulationEngine.getAnimals();
        assertEquals(a.get(0).getPosition(),new Vector2d(1,0));
        assertEquals(a.get(1).getPosition(),new Vector2d(0,0));
        assertEquals(a.get(0).getMapDirection(),MapDirection.SOUTH);
        assertEquals(a.get(1).getMapDirection(),MapDirection.WEST);
    }

}
