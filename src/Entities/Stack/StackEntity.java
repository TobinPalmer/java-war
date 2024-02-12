package Entities.Stack;

import Entities.Position;
import Entities.Renderable;
import Graphics.CardGraphics;

public class StackEntity extends Renderable {
    private int size = 0;

    public StackEntity(Position position, int s) {
        super(position);
        this.size = s;
    }

    public void setSize(int s) {
        this.size = s;
    }

    @Override
    public String[] getOverlay() {
        return CardGraphics.getStack(size);
    }
}
