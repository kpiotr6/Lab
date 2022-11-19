package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionsParserTest {
    @Test
    public void parseTest1(){
        assertThrows(IllegalArgumentException.class,()->{
            OptionsParser.parse(new String[]{"f","l","b","Kanapka z serem"});
        });
        assertThrows(IllegalArgumentException.class,()->{
            OptionsParser.parse(new String[]{"","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA","b","Kanapka z serem"});
        });

    }
    @Test
    public void parseTest2(){

        assertTrue(Arrays.equals(OptionsParser.parse(new String[]{"f","l","b"}),new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD}));
        assertFalse(Arrays.equals(OptionsParser.parse(new String[]{"r","l","f","f"}),new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD}));
    }
}
