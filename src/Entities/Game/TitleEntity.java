package Entities.Game;

import Entities.Position;
import Entities.Renderable;
import Graphics.GameGraphics;

public class TitleEntity extends Renderable {
    public TextState textState;

    public TitleEntity(Position position, TextState textState) {
        super(position);
        this.textState = textState;
    }

    public void setTextState(TextState textState) {
        this.textState = textState;
    }

    @Override
    public String[] getOverlay() {
        return switch (textState) {
            case WIN -> GameGraphics.textGraphic[0];
            case LOSE -> GameGraphics.textGraphic[1];
            case DRAW -> GameGraphics.textGraphic[2];
        };
    }

    public enum TextState {
        WIN,
        LOSE,
        DRAW,
    }
}
