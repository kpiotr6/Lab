package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private IWorldMap map;
    private List<Animal> animals = new LinkedList<>();

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.map = map;
        for (Vector2d position:positions) {
            Animal tmp = new Animal(map,position);
            map.place(tmp);
            animals.add(tmp);
        }
    }

    @Override
    public void run() {
        int nubmer = moves.length;
        int k = 0;
        for(Animal a : animals){
            for (int i = k;i<nubmer;i++){
                k = i;
                a.move(moves[i]);
                if(i==nubmer-1){
                    return;
                }
            }
        }
    }
}
