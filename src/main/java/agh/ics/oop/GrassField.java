package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    private HashSet<Vector2d> hashSet = new HashSet<>();
    private int grassNumber;
    public GrassField(int grassNumber) {
        this.grassNumber = grassNumber;
        stabilizeGrass();
    }
    private boolean isGrass(Vector2d position){
        for (IMapElement e:elements) {
            if(e.isAt(position) && e instanceof Grass){
                return true;
            }
        }
        return false;
    }
    public void removeGrass(Object o){
        hashSet.remove(((Grass)o).getPosition());
        elements.remove(o);
    }
    public void stabilizeGrass(){
        int x,y;
        Random random = new Random();
        while(hashSet.size()<grassNumber){
            x = random.nextInt((int)Math.sqrt(grassNumber*10));
            y = random.nextInt((int)Math.sqrt(grassNumber*10));
            Vector2d tmpVector =new Vector2d(x,y);
            if(hashSet.add(tmpVector)){
                elements.add(new Grass(tmpVector));
            }
        }


    }
    @Override
    public boolean place(Animal animal) {
        IMapElement element = null;
        for (IMapElement e : elements) {
            if(e instanceof Animal && e.isAt(animal.getPosition())){
                return false;
            }
            element = e;
        }
        elements.add(animal);
        if(element instanceof Grass){
            this.removeGrass(element);
            this.stabilizeGrass();
        }
        return true;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return isGrass(position) || !isOccupied(position);
    }

    protected Vector2d lowerLeft(){
        Vector2d lowerLeft = elements.get(0).getPosition();
        for (IMapElement e : elements) {
            lowerLeft = lowerLeft.lowerLeft(e.getPosition());
        }
        return lowerLeft;
    }
    protected Vector2d upperRight(){
        Vector2d upperRight = elements.get(0).getPosition();
        for (IMapElement e : elements) {
            upperRight = upperRight.upperRight(e.getPosition());
        }
        return upperRight;
    }
    @Override
    protected IWorldMap returnThis() {
        return this;
    }
}
