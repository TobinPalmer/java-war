package Entities.Card;

import Entities.Renderable;
import Graphics.CardGraphics;
import Logic.Card;

public class CardEntity extends Renderable {
    private final Card card;

    public CardEntity(Renderable.Position position, Card c) {
        super(position);
        card = c;
    }

    @Override
    public String[] getOverlay() {
        return CardGraphics.getCardFace(card.getRank(), card.getSuit());
    }
}
