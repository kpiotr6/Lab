package agh.ics.oop;


public class World {
//    Stworzenie klasy AbstractWorldMapElement z, której dziedziczyć będą
//    klasy Animal oraz Grass jest dobrym pomysłem. Metody toString, isAt oraz
//    get position możnaby było zdefiniować w klasie abstrakcyjnej, co uprościłoby
//    zapis klas potomnych.
    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map);
        engine.run();
        System.out.println(map);
    }
}