import java.util.ArrayList;

public class Player {
    private ArrayList<Card> drawPile = new ArrayList<>();
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

    public boolean isDrawPileEmpty() {
        return drawPile.isEmpty();
    }

    public String toString() {
        return STR."\{name}: \{drawPile}";
    }
}
