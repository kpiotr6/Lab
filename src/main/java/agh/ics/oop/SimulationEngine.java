package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private IWorldMap map;
    private List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.map = map;
        animals = new LinkedList<>();
        for (Vector2d position:positions) {
            animals.add(new Animal(map,position));
        }
    }
}
