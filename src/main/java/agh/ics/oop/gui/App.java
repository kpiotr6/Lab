package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.plaf.TableHeaderUI;
import java.util.LinkedList;

public class App extends Application {

    private IWorldMap map;
    private GridPane gridPane = new GridPane();
    private MoveDirection[] directions;
    private Thread thread;
    private Scene scene;
    private ThreadedSimulationEngine engine;
    @Override
    public void init() throws Exception {
        map = new GrassField(10);
        ((AbstractWorldMap)map).setGridPane(gridPane);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 8)};
        engine = new ThreadedSimulationEngine(map, positions);
        ((AbstractWorldMap)map).run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(gridPane);
        scene = new Scene(scroll);
        primaryStage.setScene(scene);

        Stage controls = new Stage();
        controls.setResizable(false);
        controls.show();
        TextField text = new TextField();
        Button button = new Button("Start");
        HBox hbox =  new HBox(text,button);
        Scene controlsScene = new Scene(hbox);
        controls.setScene(controlsScene);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                directions = OptionsParser.parse(text.getText().split(" ")); // OptionsParser.parse(getParameters().getRaw().toArray(new String[0]));
                engine.setMoves(directions);
                thread = new Thread(engine);
                thread.start();
                controls.close();
            }
        });



    }
}
