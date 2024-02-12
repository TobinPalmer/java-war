package Logic;

import Logic.Card;

import java.util.ArrayList;

public class Player {
    public final ArrayList<Card> drawPile = new ArrayList<>();
    private final ArrayList<Card> discardPile = new ArrayList<>();
    private final String name;

    public Player(String name) {
        this.name = name;
    }

public void deal(Card card) {
drawPile.add(card);
}

    public Card draw() {
        return drawPile.removeLast();
    }

    public String getName() {
        return name;
    }

    public int getDrawPileSize() {
        return drawPile.size();
    }

    public String toString() {
        return STR."\{name}: \{drawPile}";
    }
}
