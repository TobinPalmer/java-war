package Entities.Stack;

import Entities.Renderable;

public class StackEntity extends Renderable {
    public Position position;

    public StackEntity(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public String[] getOverlay() {
        return new String[0];
    }
}
