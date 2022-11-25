package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;
import com.sun.jdi.Value;
import javafx.application.Platform;
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
    protected GridPane gridPane;
    public void setGridPane(GridPane grid){
        this.gridPane = grid;
    }
    public void run(){
        for (IMapElement e: elements.values()) {
            if (e.getRepresentation()!=null){
                e.getRepresentation().update();
            }

        }
        parseToGrid();
        gridPane.setGridLinesVisible(true);
    }

    public void parseToGrid(){
        gridPane.getChildren().clear();
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();

        for(int i= lowerLeft().x;i < upperRight().x+1;i++){
            for(int j = lowerLeft().y;j <  upperRight().y+1;j++){
                Object value = objectAt(new Vector2d(i,j));
                if(value != null){
                    IMapElement e = (IMapElement)value;
                    GuiElementBox representation = e.getRepresentation();
                    if(representation ==null){
                        e.setRepresentation(new GuiElementBox(e));
                        representation = e.getRepresentation();
                    }
                    gridPane.add(representation.getVBox(),i-lowerLeft().x+1,upperRight().y+1-j,1,1);
                }
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
            gridPane.getColumnConstraints().add(new ColumnConstraints(50));
            GridPane.setHalignment(label,HPos.CENTER);
        }
        for(int i=0;i<gridPane.getRowCount();i++){
            gridPane.getRowConstraints().add(new RowConstraints(50));
            GridPane.setHalignment(label,HPos.CENTER);
        }
        gridPane.setGridLinesVisible(false);

    }
    @Override
    public void positonChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = (Animal) elements.get(oldPosition);
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                if(animal.getRepresentation()!=null){
//                    animal.getRepresentation().update();
//                }
//            }
//        });


        elements.remove(oldPosition);
        elements.put(newPosition,animal);
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
