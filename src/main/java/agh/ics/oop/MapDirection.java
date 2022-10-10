package agh.ics.oop;

public enum MapDirection {
    NORTH("Północ"),
    SOUTH("Południe"),
    WEST("Wschód"),
    EAST("Zachód");
    private final String dir;

    MapDirection(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return dir;
    }
    MapDirection previous(){
        return switch (this) {
            case EAST -> NORTH;
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
        };
    }
    MapDirection next(){
        return switch (this) {
            case EAST -> SOUTH;
            case NORTH -> EAST;
            case WEST -> NORTH;
            case SOUTH -> WEST;
        };
    }
    Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
        };
    }
}