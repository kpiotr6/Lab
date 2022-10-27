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
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map);
        engine.run();
        System.out.println(map);

    }
}