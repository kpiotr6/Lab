package agh.ics.oop;

import javafx.application.Platform;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine,Runnable{
    private MoveDirection[] moves;
    private IWorldMap map;
    private List<Animal> animals = new LinkedList<>();

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

    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void run() {
        int animalNumber = 0;
        int maxAnimal = animals.size();
        for(MoveDirection move:moves){

            try{
//                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Przerwano symulację");
            }
            System.out.println("run1");
            animals.get(animalNumber%maxAnimal).move(move);
            animalNumber++;
//            Platform.runLater((AbstractWorldMap)map);
//            try{
//                Thread.sleep(1);
//            }catch (Exception e){
//                System.out.println("Przerwano symulację");
//            }
            System.out.println("run2");

        }

    }
}
