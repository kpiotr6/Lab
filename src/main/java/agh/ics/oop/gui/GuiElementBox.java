package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.Grass;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuiElementBox {
    private HashMap<String,ImageView> images = new HashMap<>();
    private ImageView current;
    private Label label;
    private VBox vBox;
    private IMapElement element;

    public GuiElementBox(IMapElement iMapElement) {
        this.element = iMapElement;
        setRepresentation();
        if (iMapElement instanceof Grass) {
            this.label = new Label("Trawa");
        } else {
            this.label = new Label("Z " + iMapElement.getPosition().toString());
        }
        this.vBox = new VBox(this.current, this.label);
        this.vBox.setAlignment(Pos.CENTER);
    }
    public VBox getVBox() {
        return vBox;
    }

    public void update() {
        if (element instanceof Animal) {
            this.label.setText("Z " + element.getPosition().toString());
            setRepresentation();
            this.vBox = new VBox(this.current, this.label);
            this.vBox.setAlignment(Pos.CENTER);
        }
    }
    private void setRepresentation(){
        ImageView newImage = images.get(element.getSource());
        if(newImage != null){
            current = newImage;
        }
        else{
            Image tmpImage = null;
            try {
                tmpImage = new Image(new FileInputStream(element.getSource()));
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            ImageView tmpView = new ImageView(tmpImage);
            tmpView.setFitWidth(20);
            tmpView.setFitHeight(20);
            images.put(element.getSource(),tmpView);
            current = tmpView;

        }


    }
}
