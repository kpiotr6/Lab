package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    IWorldMap map;


    @Override
    public void init() throws Exception {
        MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw().toArray(new String[0]));
        map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,8) };
        IEngine engine = new SimulationEngine(directions, map, positions);
//        System.out.println(map);
        engine.run();
//        System.out.println(map);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        ((AbstractWorldMap)map).parseToGrid(gridPane);
        Scene scene = new Scene(gridPane);
        primaryStage.setResizable(false);
        gridPane.setGridLinesVisible(true);
        primaryStage.show();
        primaryStage.setScene(scene);

    }
}
