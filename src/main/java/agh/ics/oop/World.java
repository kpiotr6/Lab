package agh.ics.oop;

import java.util.Map;

public class World {
    static void run(Direction[] directions){
        System.out.println("Start");
        for (Direction dir: directions) {
            switch(dir){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACK -> System.out.println("Zwierzak idzie do tył");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
            }
        }
        System.out.println("Stopp");
    }
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(MapDirection.EAST.next());
        System.out.println(MapDirection.EAST.toUnitVector());
    }
}
