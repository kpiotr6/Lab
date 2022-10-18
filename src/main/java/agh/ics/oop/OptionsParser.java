package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String[] commands) {
        List<MoveDirection> directions = new LinkedList<>();
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "f", "forward" -> directions.add(MoveDirection.FORWARD);
                case "b", "backward" -> directions.add(MoveDirection.BACKWARD);
                case "l", "left" -> directions.add(MoveDirection.LEFT);
                case "r", "right" -> directions.add(MoveDirection.RIGHT);
            }
        }
        return (MoveDirection[]) directions.toArray();
    }
}
