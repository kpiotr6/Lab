package agh.ics.oop;


import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String[] commands) {
        List<MoveDirection> directions = new LinkedList<>();
        for (String command : commands) {
            switch (command) {
                case "f", "forward" -> directions.add(MoveDirection.FORWARD);
                case "b", "backward" -> directions.add(MoveDirection.BACKWARD);
                case "l", "left" -> directions.add(MoveDirection.LEFT);
                case "r", "right" -> directions.add(MoveDirection.RIGHT);
            }
        }
        MoveDirection[] moveArray = new MoveDirection[directions.size()];
        directions.toArray(moveArray);
        return moveArray;
    }
}
