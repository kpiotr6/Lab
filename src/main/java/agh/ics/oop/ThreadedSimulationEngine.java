package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class ThreadedSimulationEngine extends SimulationEngine {

    private final static int moveDelay = 300;

    public ThreadedSimulationEngine(IWorldMap map, Vector2d[] positions) throws IllegalArgumentException {

        super.map = map;
        for (Vector2d position : positions) {
            Animal tmp = new Animal(map, position);
            tmp.addObserver((IPositionChangeObserver) map);
            map.place(tmp);
            super.animals.add(tmp);
        }
    }

    public void setMoves(MoveDirection[] moves) {
        this.moves = moves;
    }
}
