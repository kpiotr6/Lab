package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.Grass;
import agh.ics.oop.IMapElement;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GuiElementBox {
    private Image image;
    private ImageView imageView;
    private Label label;
    private VBox vBox;
    private IMapElement element;

    public GuiElementBox(IMapElement iMapElement) {
        this.element = iMapElement;
        this.image = new Image(iMapElement.getSource());
        this.imageView = new ImageView(this.image);
        this.imageView.setFitHeight(20);
        this.imageView.setFitWidth(20);
        if(iMapElement instanceof Grass){
            this.label = new Label("Trawa");
        }
        else{
            this.label = new Label("Z "+iMapElement.getPosition().toString());
        }
        this.vBox = new VBox(this.imageView,this.label);
    }
    public VBox getVBox(){
        return vBox;
    }
    public void updateLabel(){
        if(element instanceof Animal){
            this.label.setText("Z "+element.getPosition().toString());
        }
    }
}
