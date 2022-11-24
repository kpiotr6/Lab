package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;

public class App extends Application {

    private IWorldMap map;
    private GridPane gridPane = new GridPane();
    private MoveDirection[] directions;
    private Thread thread;
    private Scene scene;
    private SimulationEngine engine;
    @Override
    public void init() throws Exception {
        directions = OptionsParser.parse(getParameters().getRaw().toArray(new String[0]));
        map = new GrassField(10);
        ((AbstractWorldMap)map).setGridPane(gridPane);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,8) };
        engine = new SimulationEngine(directions, map, positions);
        thread = new Thread(engine);

//        engine.run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            primaryStage.show();

            primaryStage.setHeight(500);
            primaryStage.setWidth(500);

            scene = new Scene(gridPane);
            gridPane.add(new VBox(new Label("KRAA"),new Label("AARK")),0,0);
            primaryStage.setScene(scene);
//        gridPane.add(new Label("lool"),1,0);
//        gridPane.add(new Label("lool"),2,0);
//            ((AbstractWorldMap)map).run();
//            engine.run();
//            thread.start();
//            Thread.sleep(5000);
//        thread.interrupt();
//            Thread.sleep(1000);
//            ((AbstractWorldMap)map).run();
            engine.run();
            ((AbstractWorldMap)map).run();
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
