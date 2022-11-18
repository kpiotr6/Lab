package agh.ics.oop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWorldMap implements IPositionChangeObserver {
    protected abstract Vector2d lowerLeft();
    protected abstract Vector2d upperRight();
    protected abstract IWorldMap returnThis();


    final protected HashMap<Vector2d,IMapElement> elements = new HashMap<>();


    @Override
    public void positonChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = (Animal) elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition,animal);
    }
    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(returnThis());
        return mapVisualizer.draw(lowerLeft(),upperRight());
    }

    public boolean place(Animal animal) throws IllegalArgumentException {
        IMapElement e = elements.get(animal.getPosition());
        if(e instanceof Animal){
            throw new IllegalArgumentException("Wrong position: "+animal.getPosition());
        }
        elements.put(animal.getPosition(),animal);
        return true;
    }
    public boolean isOccupied(Vector2d position) {
        return elements.get(position)!=null;
    }
    public Object objectAt(Vector2d position) {
        return elements.get(position);
    }

    public HashMap<Vector2d,IMapElement> getElements() {
        return elements;
    }
}
