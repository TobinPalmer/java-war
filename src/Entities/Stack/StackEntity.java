package Entities.Stack;

import Entities.Renderable;

public class StackEntity extends Renderable {
    public StackEntity(Position position) {
        super(position);
    }

    @Override
    public String[] getOverlay() {
        return new String[0];
    }
}
