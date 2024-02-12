import Entities.Card.CardEntity;
import Entities.Card.MovingCardEntity;
import Entities.Renderable;
import Entities.Stack.FaceUpStackEntity;
import Entities.Stack.StackEntity;
import Graphics.CardGraphics;
import Graphics.Renderer;
import Logic.Card;
import Logic.Deck;
import Logic.Player;
import jdk.jfr.Timespan;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.Timer;

public class GameOfWar {
    public static void main(String[] args) {
        System.out.println(STR."Test1 passed?: \{CardGraphics.areAllCardsCorrectLength()}");
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();

        Player player1 = new Player("Logic.Player 1");
        Player player2 = new Player("Logic.Player 2");

        deck.shuffle();

        deck.deal(player1, player2);

        StackEntity player1Stack = new StackEntity(new Renderable.Position(10, 10), player1.getDrawPileSize());
        StackEntity player2Stack = new StackEntity(new Renderable.Position(Renderer.WIDTH - 10, 10 ), player2.getDrawPileSize());

        while (player1.getDrawPileSize() > 0 && player2.getDrawPileSize() > 0) {
            final Card player1Card = player1.draw();
            final Card player2Card = player2.draw();
            Card.Comparison comparison = player1Card.compareTo(player2Card);

            player1Stack.setSize(player1.getDrawPileSize());
            player2Stack.setSize(player2.getDrawPileSize());

            System.out.println(STR."\{player1Card} vs \{player2Card}");
            System.out.println(comparison);

            final MovingCardEntity movingCard1 = new MovingCardEntity(new Renderable.Position(10, 5), new Renderable.Position(Renderer.WIDTH / 2, 30), 1000, player1Card);

            Instant start = Instant.now();
            while (!movingCard1.isDone()) {
                movingCard1.animate(Duration.between(start, Instant.now()).toMillis());

                Renderer.addToFrame(player1Stack, player2Stack);
                Renderer.addToFrame(movingCard1);
                Renderer.render();


                // Sleep for 100ms
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Renderer.addToFrame(player1Stack, player2Stack);
            Renderer.render();


            CardEntity card1 = new CardEntity(new Renderable.Position(10, 5), player1Card);
            for (String line : card1.getOverlay()) {
                System.out.println(line);
            }


            input.nextLine();
        }
    }
}
