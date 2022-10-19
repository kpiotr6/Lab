package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    private void moveAnimal(Animal animal,String stringCommands){
        String[] dividedCommands = stringCommands.split(" ");
        MoveDirection[] moveDirection = OptionsParser.parse(dividedCommands);
        for (MoveDirection direction : moveDirection) {
            animal.move(direction);
        }
    }
    @Test
    public void TestMoving1(){
        String commands = "f f f r f f r f b";
        Animal animal = new Animal();
        moveAnimal(animal,commands);
        assertEquals(animal.toString(),"(4,4) Południe");
    }
    @Test
    public void TestMoving2(){
        String commands = "f l f r f dasd v e q b r f e b l f f";
        Animal animal = new Animal();
        moveAnimal(animal,commands);
        assertEquals(animal.toString(),"(1,4) Północ");
    }
    @Test
    public void TestMoving3(){
        String commands = "b b b b b b r f f f f f l l ";
        Animal animal = new Animal();
        moveAnimal(animal,commands);
        assertEquals(animal.toString(),"(4,0) Zachód");
    }

}
