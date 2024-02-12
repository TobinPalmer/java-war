package Logic;

public class Card {
    final Suit suit;
    final int rank;

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String toString() {
        String rank = switch (this.rank) {
            case 9 -> "Jack";
            case 10 -> "Queen";
            case 11 -> "King";
            case 12 -> "Ace";
            default -> Integer.toString(this.rank + 2);
        };
        String suit = switch (this.suit) {
            case CLUBS -> "Clubs";
            case DIAMONDS -> "Diamonds";
            case HEARTS -> "Hearts";
            case SPADES -> "Spades";
        };
        return STR."\{rank} of \{suit}";
    }

    public Comparison compareTo(Card card) {
        if (this.rank > card.rank) {
            return Comparison.WIN;
        } else if (this.rank < card.rank) {
            return Comparison.LOSE;
        } else {
            return Comparison.TIE;
        }
    }

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public enum Comparison {
        WIN,
        LOSE,
        TIE
    }
}
