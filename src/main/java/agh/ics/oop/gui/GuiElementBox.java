package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.Grass;
import agh.ics.oop.IMapElement;
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
    private ImageView imageView;
    private Label label;
    private VBox vBox;
    private IMapElement element;

    public GuiElementBox(IMapElement iMapElement) {
        this.element = iMapElement;
        setRepresentation(iMapElement);
        if (iMapElement instanceof Grass) {
            this.label = new Label("Trawa");
        } else {
            this.label = new Label("Z " + iMapElement.getPosition().toString());
        }
        this.vBox = new VBox(this.imageView, this.label);
    }
    public VBox getVBox() {
        return vBox;
    }

    public void update() {
        if (element instanceof Animal) {
            this.label.setText("Z " + element.getPosition().toString());
            setRepresentation(element);
        }
    }
    private void setRepresentation(IMapElement iMapElement){

        Image image = null;
        try {
            image = new Image(new FileInputStream(iMapElement.getSource()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.imageView = new ImageView(image);
        this.imageView.setFitHeight(40);
        this.imageView.setFitWidth(40);


    }
}
