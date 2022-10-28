package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private RectangularMap map;
    private List<Animal> animals = new LinkedList<>();

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.map = (RectangularMap)map;
        for (Vector2d position:positions) {
            Animal tmp = new Animal(map,position);
            map.place(tmp);
            animals.add(tmp);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void run() {
        int animalNumber = 0;
        int maxAnimal = animals.size();
        for(MoveDirection move:moves){
            animals.get(animalNumber%maxAnimal).move(move);
            animalNumber++;
        }
    }
}
