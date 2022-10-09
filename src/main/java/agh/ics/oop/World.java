package agh.ics.oop;

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
        System.out.println("system wystartował");
        Direction[] directions = new Direction[args.length];
        for(int i=0;i< args.length;i++){
            switch (args[i]){
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACK;
                case "r" -> directions[i] = Direction.RIGHT;
                case "l" -> directions[i] = Direction.LEFT;
            }
        }
        run(directions);
        System.out.println("system zakończył działanie");
    }
}
