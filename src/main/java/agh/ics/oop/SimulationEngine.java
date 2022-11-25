package agh.ics.oop;

import javafx.application.Platform;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine,Runnable{
    protected MoveDirection[] moves;
    protected IWorldMap map;
    protected List<Animal> animals = new LinkedList<>();
    protected final static int moveDelay = 300;
    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) throws IllegalArgumentException{
        this.moves = moves;
        this.map = map;
        for (Vector2d position:positions) {
            Animal tmp = new Animal(map,position);
            tmp.addObserver((IPositionChangeObserver)map);
            map.place(tmp);
            animals.add(tmp);
        }

    }

    public SimulationEngine() {

    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void run() {
        int animalNumber = 0;
        int maxAnimal = animals.size();
        for(MoveDirection move:moves){
            try{
                Thread.sleep(moveDelay);
            }catch (Exception e){
                System.out.println("Przerwano symulację");
            }
            animals.get(animalNumber%maxAnimal).move(move);
            animalNumber++;

            Platform.runLater((AbstractWorldMap)map);

        }

    }
}
