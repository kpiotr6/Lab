package agh.ics.oop;


import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String[] commands) throws IllegalArgumentException {
        List<MoveDirection> directions = new LinkedList<>();
        int k;
        for (String command : commands) {
            switch (command) {
                case "f", "forward" -> directions.add(MoveDirection.FORWARD);
                case "b", "backward" -> directions.add(MoveDirection.BACKWARD);
                case "l", "left" -> directions.add(MoveDirection.LEFT);
                case "r", "right" -> directions.add(MoveDirection.RIGHT);
                case "" ->  k = 1;
                default -> throw new IllegalArgumentException(command+" is not legal move specification");
            }
        }
        MoveDirection[] moveArray = new MoveDirection[directions.size()];
        directions.toArray(moveArray);
        return moveArray;
    }
}
