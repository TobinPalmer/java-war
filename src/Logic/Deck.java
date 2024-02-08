package Logic;

import java.util.ArrayList;

public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (int rank = 1; rank <= 13; rank++) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int j = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public void deal(Player player1, Player player2) {
        while(cards.size() >= 2) {
            player1.deal(cards.removeLast());
            player2.deal(cards.removeLast());
        }
    }

    public Card draw() {
        return cards.removeLast();
    }

    public int size() {
        return cards.size();
    }
}
