package agh.ics.oop;

public class Animal {
    private MapDirection mapDirection = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;
    public Animal(IWorldMap map) {
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this(map);
        this.position = initialPosition;
    }
    public Animal(){

    }

    @Override
    public String toString() {
        return switch (mapDirection) {
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        Vector2d previousPosition = new Vector2d(position.x,position.y);
        switch(direction){
            case RIGHT -> mapDirection = mapDirection.next();
            case LEFT -> mapDirection = mapDirection.previous();
            case FORWARD -> position = position.add(mapDirection.toUnitVector());
            case BACKWARD -> position = position.substract(mapDirection.toUnitVector());
        }
        if(!map.canMoveTo(position)){
            position = previousPosition;
        }
    }

    public Vector2d getPosition() {
        return position;
    }
}
