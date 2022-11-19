package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver {
    SortedSet<Vector2d> pivotX = new TreeSet<>(
        new Comparator<Vector2d>(){
            @Override
            public int compare(Vector2d a,Vector2d b){
                if ((int)Math.signum(a.x - b.x)==0){
                    return 1;
                }
                return (int)Math.signum(a.x - b.x);
            }
        });
    SortedSet<Vector2d> pivotY = new TreeSet<>(
            new Comparator<Vector2d>(){
                @Override
                public int compare(Vector2d a,Vector2d b){
                    if((int)Math.signum(a.y - b.y)==0){
                        return 1;
                    }
                    return (int)Math.signum(a.y - b.y);
                }
            });
    @Override
    public void positonChanged(Vector2d oldPosition, Vector2d newPosition) {
        pivotY.remove(oldPosition);
        pivotX.remove(oldPosition);
        pivotX.add(newPosition);
        pivotY.add(newPosition);
    }
    public void remove(Vector2d vector){
        pivotY.remove(vector);
        pivotX.remove(vector);
    }
    public void add(Vector2d vector){
        pivotY.add(vector);
        pivotX.add(vector);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(pivotX.first().x,pivotY.first().y);
    }
    public Vector2d upperRight(){
        return new Vector2d(pivotX.last().x,pivotY.last().y);
    }
}
