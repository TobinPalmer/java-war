package Entities.Card;

import Entities.AnimatedRenderable;
import Entities.Position;
import Graphics.CardGraphics;
import Logic.Card;

public class MovingCardEntity extends AnimatedRenderable {
    private final Card card;

    public MovingCardEntity(Position position, Position targetPosition, double time, Card card) {
        super(position, targetPosition, time);
        this.card = card;
    }

    @Override
    public String[] getOverlay() {
        return CardGraphics.getCardFace(card);
    }
}
