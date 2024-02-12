package Graphics;

import Logic.Card;

import java.util.HashMap;
import java.util.Map;

public class CardGraphics {
    public static final int CARD_WIDTH = 10;
    public static final int CARD_HEIGHT = 9;

    public static String[] getCardFace(int rank, Card.Suit suit) {
        String[] face = cardFaces[rank];
        for (int i = 0; i < face.length; i++) {
            face[i] = face[i].replaceAll("\\*", String.valueOf(suitCharacters.get(suit)));
        }
        return face;
    }

    public static String[] getCardFace(Card card) {
        return getCardFace(card.getRank(), card.getSuit());
    }

    public static String[] getStack(int s) {
        return stacks[Math.min(s, stacks.length - 1)];
    }

    private static final Map<Card.Suit, Character> suitCharacters = new HashMap<>(4) {{
        put(Card.Suit.CLUBS, '♣');
        put(Card.Suit.DIAMONDS, '♦');
        put(Card.Suit.HEARTS, '♥');
        put(Card.Suit.SPADES, '♠');
    }};

    private static final String[][] stacks = {
            {
                    " _________",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    " ~~~~~~~~~"
            },
            {
                    " _________",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|-~~--~~~-|",
                    "|~-~--~~--|"
            },
    };

    private static final String[][] cardFaces = {
            {
                    " _________ ",
                    "|2        |",
                    "|         |",
                    "|    *    |",
                    "|         |",
                    "|    *    |",
                    "|         |",
                    "|        2|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|3        |",
                    "|    *    |",
                    "|         |",
                    "|    *    |",
                    "|         |",
                    "|    *    |",
                    "|        3|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|4        |",
                    "|         |",
                    "|  *   *  |",
                    "|         |",
                    "|  *   *  |",
                    "|         |",
                    "|        4|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|5        |",
                    "|         |",
                    "|  *   *  |",
                    "|    *    |",
                    "|  *   *  |",
                    "|         |",
                    "|        5|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|6        |",
                    "|  *   *  |",
                    "|         |",
                    "|  *   *  |",
                    "|         |",
                    "|  *   *  |",
                    "|        6|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|7        |",
                    "|    *    |",
                    "|  *   *  |",
                    "|    *    |",
                    "|  *   *  |",
                    "|    *    |",
                    "|        7|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|8        |",
                    "|  *   *  |",
                    "|  *   *  |",
                    "|         |",
                    "|  *   *  |",
                    "|  *   *  |",
                    "|        8|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|9        |",
                    "|  *   *  |",
                    "|  *   *  |",
                    "|    *    |",
                    "|  *   *  |",
                    "|  *   *  |",
                    "|        9|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|10       |",
                    "|   * *   |",
                    "|  * * *  |",
                    "|         |",
                    "|  * * *  |",
                    "|   * *   |",
                    "|       10|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________",
                    "|J /~~|_  |",
                    "|* | o`,  |",
                    "|  | -|   |",
                    "| =~)+(_= |",
                    "|   |- |  |",
                    "|  `.o | *|",
                    "|  ~|__/ J|",
                    " ~~~~~~~~~",
            },
            {
                    " _________ ",
                    "|Q |~~~|  |",
                    "|  /o,o\\  |",
                    "|  \\_-_/  |",
                    "| _-~+_-~ |",
                    "|  /~-~\\  |",
                    "|  \\o`o/ *|",
                    "|  |___| Q|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|K |/|\\|  |",
                    "|* /o,o\\  |",
                    "|  \\_-_/  |",
                    "| ~-_-~-_ |",
                    "|  /~-~\\  |",
                    "|  \\o`o/ *|",
                    "|  |\\|/| K|",
                    " ~~~~~~~~~ ",
            },
            {
                    " _________ ",
                    "|A        |",
                    "|*  /~\\   |",
                    "|  / ^ \\  |",
                    "| (  *  ) |",
                    "|  \\ v /  |",
                    "|   \\_/  *|",
                    "|        A|",
                    " ~~~~~~~~~",
            },
    };

    public final static String[][] cardFlippingAnimation = {
            {
                    "_________",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    "|         |",
                    "~~~~~~~~~",
            },

            {

                    "  /▔▔▔ ",
                    " /    |",
                    "/     |",
                    "|     |",
                    "|     |",
                    "|    / ",
                    "|   /  ",
                    " __/   ",
            },

            {
                    "||",
                    "||",
                    "||",
                    "||",
                    "||",
                    "||",
                    "||",
                    "||",
                    "||",
            },

            {

                    "  /▔▔▔ ",
                    " /    |",
                    "/     |",
                    "|     |",
                    "|     |",
                    "|    / ",
                    "|   /  ",
                    " __/   ",
            },
    };

    public static Boolean areAllCardsCorrectLength() {
        for (String[] face : cardFaces) {
            for (String line : face) {
                if (line.length() != CARD_WIDTH) {
                    return false;
                }
            }
        }
        return true;
    }
}
