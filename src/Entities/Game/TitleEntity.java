package Entities.Game;

import Entities.Renderable;

public class TitleEntity extends Renderable {
    protected TitleEntity(Position position) {
        super(position);
    }

    public enum TextState {
        WIN,
        LOSE,
        DRAW,
    }

    @Override
    public String[] getOverlay() {
        return new String[0];
    }
}
