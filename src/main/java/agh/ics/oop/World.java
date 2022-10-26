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
        System.out.println("Stop");
    }
    public static void main(String[] args) {
        Animal animal = new Animal();
        OptionsParser.parse(args);
        MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection direction: directions) {
            animal.move(direction);
        }
        System.out.println(animal);

    }
}