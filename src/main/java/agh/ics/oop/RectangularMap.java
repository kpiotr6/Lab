package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    final private int width;
    final private int height;
    final private List<Animal> animals = new LinkedList<>();
    public RectangularMap(int width,int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public boolean place(Animal animal){
        for (Animal a : animals) {
            if(a.isAt(animal.getPosition())){
                return false;
            }
        }
        animals.add(animal);
        return true;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return inBoundaries(position) && !isOccupied(position);
    }

    private boolean inBoundaries(Vector2d vector){
        int x = vector.x;
        int y = vector.y;
        return x>=0 && x<width && y>=0 && y<height;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a : animals) {
            if(a.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal a : animals) {
            if(position.equals(a.getPosition())){
                return a;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0),new Vector2d(width-1,height-1));
    }

}
