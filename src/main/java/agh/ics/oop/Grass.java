package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;

public class Grass implements IMapElement {
    private Vector2d position;
    private GuiElementBox representation;
    public Grass(Vector2d position) {
        this.position = position;
    }
    @Override
    public Vector2d getPosition() {
        return position;
    }
    @Override
    public String getSource(){
        return "src/main/resources/grass.png";
    }
    @Override
    public String toString() {
        return "*";
    }

    @Override
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public GuiElementBox getRepresentation() {
        return representation;
    }

    public void setRepresentation(GuiElementBox representation) {
        this.representation = representation;
    }
}
