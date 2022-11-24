package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;
import com.sun.jdi.Value;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public abstract class AbstractWorldMap implements IPositionChangeObserver,Runnable {
    protected abstract Vector2d lowerLeft();
    protected abstract Vector2d upperRight();
    protected abstract IWorldMap returnThis();
    final protected HashMap<Vector2d,IMapElement> elements = new HashMap<>();
    protected HashMap<Vector2d,GuiElementBox> boxesMap = new HashMap<>();
    protected GridPane gridPane;
    protected GuiElementBox toModificate;
    protected Vector2d modificatePosition;
    public static int ctr = 0;
    public void setGridPane(GridPane grid){
        this.gridPane = grid;
    }
    public void run(){
        if(toModificate!=null){

            toModificate.update();
            boxesMap.put(modificatePosition,toModificate);
        }

        parseToGrid();
        System.out.println("map");
    }

    public void parseToGrid(){
        gridPane.getChildren().clear();
        ctr++;
        if(ctr < 3){
            gridPane.setGridLinesVisible(true);
            for(int i= lowerLeft().x;i < upperRight().x+1;i++){
                for(int j = lowerLeft().y;j <  upperRight().y+1;j++){
                    Object value = objectAt(new Vector2d(i,j));
                    String string;
                    if(value!=null){
                        string = value.toString();
                    }
                    else{
                        string = " ";
                    }
                    Label label = new Label(string);
                    gridPane.add(label,i-lowerLeft().x+1,upperRight().y+1-j,1,1);
                    GridPane.setHalignment(label,HPos.CENTER);
                }
            }
            for(int j = lowerLeft().y;j <  upperRight().y+1;j++){
                Label label = new Label(""+j);
                gridPane.add(label,0,upperRight().y+1-j,1,1);
                GridPane.setHalignment(label,HPos.CENTER);
            }
            for(int j = lowerLeft().x;j <  upperRight().x+1;j++){
                Label label = new Label(""+j);
                gridPane.add(label,j-lowerLeft().x+1,0,1,1);
                GridPane.setHalignment(label,HPos.CENTER);
            }
            Label label = new Label("y/x");
            gridPane.add(label,0,0,1,1);
            GridPane.setHalignment(label,HPos.CENTER);
            for(int i=0;i<gridPane.getColumnCount();i++){
                gridPane.getColumnConstraints().add(new ColumnConstraints(20));
                GridPane.setHalignment(label,HPos.CENTER);
            }
            for(int i=0;i<gridPane.getRowCount();i++){
                gridPane.getRowConstraints().add(new RowConstraints(20));
                GridPane.setHalignment(label,HPos.CENTER);
            }
        }

//        for(int i= lowerLeft().x;i < upperRight().x+1;i++){
//            for(int j = lowerLeft().y;j <  upperRight().y+1;j++){
//                Object value = objectAt(new Vector2d(i,j));
//                if(value != null){
//                    Vector2d e = ((IMapElement)value).getPosition();
//                    if(boxesMap.get(e) == null){
//                        boxesMap.put(e,new GuiElementBox((IMapElement)value));
//                    }
//                    GuiElementBox b = boxesMap.get(e);
//                    gridPane.add(b.getVBox(),i-lowerLeft().x+1,upperRight().y+1-j,1,1);
//                }
//                else{
//                    gridPane.add(new Label("void"),i-lowerLeft().x+1,upperRight().y+1-j,1,1);
//                }
//            }
//        }
//        for(int j = lowerLeft().y;j <  upperRight().y+1;j++){
//            Label label = new Label(""+j);
//            gridPane.add(label,0,upperRight().y+1-j,1,1);
//            GridPane.setHalignment(label,HPos.CENTER);
//        }
//        for(int j = lowerLeft().x;j <  upperRight().x+1;j++){
//            Label label = new Label(""+j);
//            gridPane.add(label,j-lowerLeft().x+1,0,1,1);
//            GridPane.setHalignment(label,HPos.CENTER);
//        }
//        Label label = new Label("y/x");
//        gridPane.add(label,0,0,1,1);
//        GridPane.setHalignment(label,HPos.CENTER);
//        for(int i=0;i<gridPane.getColumnCount();i++){
//            gridPane.getColumnConstraints().add(new ColumnConstraints(60));
//            GridPane.setHalignment(label,HPos.CENTER);
//        }
//        for(int i=0;i<gridPane.getRowCount();i++){
//            gridPane.getRowConstraints().add(new RowConstraints(60));
//            GridPane.setHalignment(label,HPos.CENTER);
//        }

    }
    @Override
    public void positonChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = (Animal) elements.get(oldPosition);
        GuiElementBox box = boxesMap.get(oldPosition);
        if(box != null){
            toModificate = box;
            modificatePosition = newPosition;
            boxesMap.remove(oldPosition);
        }
        elements.remove(oldPosition);
        elements.put(newPosition,animal);
//        parseToGrid();
    }
    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(returnThis());
        return mapVisualizer.draw(lowerLeft(),upperRight());
    }

    public boolean place(Animal animal) throws IllegalArgumentException {
        IMapElement e = elements.get(animal.getPosition());
        if(e instanceof Animal){
            throw new IllegalArgumentException("Wrong position: "+animal.getPosition());
        }
        elements.put(animal.getPosition(),animal);
        return true;
    }
    public boolean isOccupied(Vector2d position) {
        return elements.get(position)!=null;
    }
    public Object objectAt(Vector2d position) {
        return elements.get(position);
    }

    public HashMap<Vector2d,IMapElement> getElements() {
        return elements;
    }
}
