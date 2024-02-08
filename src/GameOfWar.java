import Entities.Card.CardEntity;
import Entities.Renderable;
import Logic.Card;
import Logic.Deck;
import Logic.Player;

import java.util.Scanner;

public class GameOfWar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();

        Player player1 = new Player("Logic.Player 1");
        Player player2 = new Player("Logic.Player 2");

        deck.shuffle();

        deck.deal(player1, player2);

        while (!player1.isDrawPileEmpty() && !player2.isDrawPileEmpty()) {
            Card player1Card = player1.draw();
            Card player2Card = player2.draw();
            Card.Comparison comparison = player1Card.compareTo(player2Card);

            System.out.println(STR."\{player1Card} vs \{player2Card}");
            System.out.println(comparison);

            CardEntity card1 = new CardEntity(new Renderable.Position(10, 5), player1Card);
            for (String line : card1.getOverlay()) {
                System.out.println(line);
            }

            input.nextLine();
        }
    }
}
