package Graphics;

import Entities.Position;

public class PositionConstants {
    public static final Position Player1DrawPile = new Position(CardGraphics.CARD_WIDTH / 2 + 4, CardGraphics.CARD_HEIGHT / 2 + 2);
    public static final Position Player2DrawPile = new Position(Renderer.WIDTH - 1 - Player1DrawPile.x, Player1DrawPile.y);

    public static final Position Player1Card = new Position(Renderer.WIDTH / 2 - CardGraphics.CARD_WIDTH / 2 - 2, CardGraphics.CARD_HEIGHT / 2 + 10);
    public static final Position Player2Card = new Position(Renderer.WIDTH - 1 - Player1Card.x, Player1Card.y);
    public static final Position Title = new Position(Renderer.WIDTH / 2, Renderer.HEIGHT - 10);
}
