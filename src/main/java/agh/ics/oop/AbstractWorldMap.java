package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWorldMap {
    protected abstract Vector2d lowerLeft();
    protected abstract Vector2d upperRight();
    protected abstract IWorldMap returnThis();
    final protected List<IMapElement> elements = new LinkedList<>();

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(returnThis());
        return mapVisualizer.draw(lowerLeft(),upperRight());
    }

    public boolean place(Animal animal) {
        for (IMapElement e : elements) {
            if(e.isAt(animal.getPosition())){
                return false;
            }
        }
        elements.add(animal);
        return true;
    }
    public boolean isOccupied(Vector2d position) {
        for (IMapElement e : elements) {
            if(e.isAt(position)){
                return true;
            }
        }
        return false;
    }
    public Object objectAt(Vector2d position) {
        for (IMapElement e : elements) {
            if(position.equals(e.getPosition())){
                return e;
            }
        }
        return null;
    }

    public List<IMapElement> getElements() {
        return elements;
    }
}
