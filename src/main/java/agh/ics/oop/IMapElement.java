package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;

public interface IMapElement {
    boolean isAt(Vector2d position);
    Vector2d getPosition();
    String getSource();
    GuiElementBox getRepresentation();
    void setRepresentation(GuiElementBox representation);
}
