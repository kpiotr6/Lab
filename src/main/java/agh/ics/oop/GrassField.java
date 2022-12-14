package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    private HashSet<Vector2d> hashSet = new HashSet<>();
    private int grassNumber;
    private MapBoundary mapBoundary = new MapBoundary();
    public GrassField(int grassNumber) {
        this.grassNumber = grassNumber;
        stabilizeGrass();
    }
    private boolean isGrass(Vector2d position){
        IMapElement e = elements.get(position);
        if(e==null){
            return false;
        }
        if(e.isAt(position) && e instanceof Grass){
            return true;
        }
        return false;
    }
    public void removeGrass(Object o){
        hashSet.remove(((Grass)o).getPosition());
        elements.remove(o);
        mapBoundary.remove(((Grass)o).getPosition());
    }
    public void stabilizeGrass(){
        int x,y;
        Random random = new Random();
        while(hashSet.size()<grassNumber){
            x = random.nextInt((int)Math.sqrt(grassNumber*10));
            y = random.nextInt((int)Math.sqrt(grassNumber*10));
            Vector2d tmpVector =new Vector2d(x,y);
            if(hashSet.add(tmpVector)){
                elements.put(tmpVector,new Grass(tmpVector));
                mapBoundary.add(tmpVector);
            }
        }


    }
    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        IMapElement e = elements.get(animal.getPosition());
        if(e instanceof Animal ){
            throw new IllegalArgumentException("Wrong position: "+animal.getPosition());
        }
        elements.put(animal.getPosition(),animal);
        animal.addMapBoundary(mapBoundary);
        mapBoundary.add(animal.getPosition());
        if(e instanceof Grass){
            this.removeGrass(e);
            this.stabilizeGrass();
        }
        return true;

    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return isGrass(position) || !isOccupied(position);
    }

    protected Vector2d lowerLeft(){
//        Vector2d lowerLeft = elements.keySet().iterator().next();
//        for (Vector2d e : elements.keySet()) {
//            lowerLeft = lowerLeft.lowerLeft(e);
//        }
        return mapBoundary.lowerLeft();
    }
    protected Vector2d upperRight(){
//        Vector2d upperRight = elements.keySet().iterator().next();
//        for (Vector2d e : elements.keySet()) {
//            upperRight = upperRight.upperRight(e);
//        }
        return mapBoundary.upperRight();
    }
    @Override
    protected IWorldMap returnThis() {
        return this;
    }
}
