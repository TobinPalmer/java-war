public class Card {
    final Suit suit;
    final int rank;

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }


    public String toString() {
        String rank = switch (this.rank) {
            case 1 -> "Ace";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> Integer.toString(this.rank);
        };
        String suit = switch (this.suit) {
            case CLUBS -> "Clubs";
            case DIAMONDS -> "Diamonds";
            case HEARTS -> "Hearts";
            case SPADES -> "Spades";
        };
        return rank + " of " + suit;
    }
}
