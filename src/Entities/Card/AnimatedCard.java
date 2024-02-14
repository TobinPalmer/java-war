package Entities.Card;

import Entities.AnimatedRenderable;
import Entities.Position;
import Graphics.CardGraphics;
import Logic.Card;

public class AnimatedCard extends AnimatedRenderable {
    private final Card card;
    private int overlayIndex;

    public AnimatedCard(Position position, double time, Card card) {
        super(position, time);
        this.card = card;
    }

    @Override
    public void animate(double t) {
        final var g = CardGraphics.cardFlippingAnimation;
        this.overlayIndex = (int) Math.round((t / this.time) * (g.length));
    }

    @Override
    public boolean isDone() {
        return this.overlayIndex == CardGraphics.cardFlippingAnimation.length;
    }

    @Override
    public String[] getOverlay() {
        if (this.overlayIndex == CardGraphics.cardFlippingAnimation.length) {
            return CardGraphics.getCardFace(this.card);
        } else {
            return CardGraphics.cardFlippingAnimation[this.overlayIndex];
        }
    }
}
