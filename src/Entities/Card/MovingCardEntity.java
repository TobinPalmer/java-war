package Entities.Card;

import Entities.AnimatedRenderable;
import Entities.Position;
import Graphics.CardGraphics;
import Logic.Card;

public class MovingCardEntity extends AnimatedRenderable {
    private final Card card;
    private final Position targetPosition;
    private final Position startPosition;

    public MovingCardEntity(Position position, Position targetPosition, double time, Card card) {
        super(position, time);
        this.startPosition = position.copy();
        this.card = card;
        this.targetPosition = targetPosition;
    }

    @Override
    public void animate(double t) {
        double progress = Math.min(t, this.time) / this.time;

        double x = (targetPosition.x - startPosition.x) * progress + startPosition.x;
        double y = (targetPosition.y - startPosition.y) * progress + startPosition.y;

        position.set((int) Math.round(x), (int) Math.round(y));
    }

    @Override
    public String[] getOverlay() {
        return CardGraphics.getCardFace(card);
    }

    @Override
    public boolean isDone() {
        return position.x == targetPosition.x && position.y == targetPosition.y;
    }
}
