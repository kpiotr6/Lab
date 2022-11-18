package agh.ics.oop;


public class World {
    public static void main(String[] args) {

        try{
            MoveDirection[] directions = OptionsParser.parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            System.out.println(map);
            engine.run();
            System.out.println(map);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
        finally{
            System.exit(0);
        }

    }
}