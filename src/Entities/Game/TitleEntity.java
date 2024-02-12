package Entities.Game;

import Entities.Position;
import Entities.Renderable;

public class TitleEntity extends Renderable {
    protected TitleEntity(Position position) {
        super(position);
    }

    @Override
    public String[] getOverlay() {
        return new String[0];
    }

    public enum TextState {
        WIN,
        LOSE,
        DRAW,
    }
}
