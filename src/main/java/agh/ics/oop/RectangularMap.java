package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap implements IWorldMap{
    final private int width;
    final private int height;

    public RectangularMap(int width,int height){
        this.width = width;
        this.height = height;
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

    protected Vector2d lowerLeft(){
        return new Vector2d(0,0);
    }
    protected Vector2d upperRight(){
        return new Vector2d(width-1,height-1);
    }

    @Override
    protected IWorldMap returnThis() {
        return this;
    }
}
