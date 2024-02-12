package Graphics;

import Entities.Renderable;

public class PositionConstants {
    public static final Renderable.Position Player1DrawPile = new Renderable.Position(2, CardGraphics.CARD_HEIGHT / 2 + 2);
    public static final Renderable.Position Player2DrawPile = new Renderable.Position(Renderer.WIDTH - Player1DrawPile.x, Player1DrawPile.y);
}
