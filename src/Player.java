import java.util.ArrayList;

public class Player {
    private final ArrayList<Card> hand = new ArrayList<>();
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void draw(Deck deck) {
        hand.add(deck.draw());
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + ": " + hand;
    }
}
