import Entities.Card.AnimatedCard;
import Entities.Card.CardEntity;
import Entities.Card.MovingCardEntity;
import Entities.Game.TitleEntity;
import Entities.Stack.StackEntity;
import Graphics.CardGraphics;
import Graphics.PositionConstants;
import Graphics.Renderer;
import Logic.Card;
import Logic.Deck;
import Logic.Player;

import java.util.Scanner;

public class GameOfWar {
    public static void main(String[] args) {
        System.out.println(STR."Test1 passed?: \{CardGraphics.areAllCardsCorrectLength()}");
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();

        Player player1 = new Player("Logic.Player 1");
        Player player2 = new Player("Logic.Player 2");

        deck.shuffle();

        deck.deal(player1, player2);

        final StackEntity player1Stack = new StackEntity(PositionConstants.Player1DrawPile, player1.getDrawPileSize());
        final StackEntity player2Stack = new StackEntity(PositionConstants.Player2DrawPile, player2.getDrawPileSize());

        TitleEntity title = new TitleEntity(PositionConstants.Title, TitleEntity.TextState.WIN);

        while (player1.getDrawPileSize() > 0 && player2.getDrawPileSize() > 0) {
            final Card player1Card = player1.draw();
            final Card player2Card = player2.draw();
            Card.Comparison comparison = player1Card.compareTo(player2Card);

            switch (comparison) {
                case WIN -> title.setTextState(TitleEntity.TextState.WIN);
                case LOSE -> title.setTextState(TitleEntity.TextState.LOSE);
                case DRAW -> title.setTextState(TitleEntity.TextState.DRAW);
            }

            player1Stack.setSize(player1.getDrawPileSize());
            player2Stack.setSize(player2.getDrawPileSize());

            AnimatedCard animatedCard1 = new AnimatedCard(PositionConstants.Player1DrawPile.add(2, 2), 1000, player1Card);
            AnimatedCard animatedCard2 = new AnimatedCard(PositionConstants.Player2DrawPile.add(-2, 2), 1000, player2Card);

            Renderer.resetOverlays();

            Renderer.addToFrame(player1Stack, player2Stack);
            Renderer.addToFrame(animatedCard1, animatedCard2);

            while (Renderer.animate()) {
                Renderer.render();
            }

            Renderer.wait(500);

            MovingCardEntity movingCard1 = new MovingCardEntity(PositionConstants.Player1DrawPile, PositionConstants.Player1Card, 1000, player1Card);
            MovingCardEntity movingCard2 = new MovingCardEntity(PositionConstants.Player2DrawPile, PositionConstants.Player2Card, 1000, player2Card);

            Renderer.resetOverlays();

            Renderer.addToFrame(player1Stack, player2Stack);
            Renderer.addToFrame(movingCard1, movingCard2);

            while (Renderer.animate()) {
                Renderer.render();
            }

            CardEntity card1 = new CardEntity(PositionConstants.Player1Card, player1Card);
            CardEntity card2 = new CardEntity(PositionConstants.Player2Card, player2Card);

            Renderer.resetOverlays();

            Renderer.addToFrame(player1Stack, player2Stack);
            Renderer.addToFrame(card1, card2);
            Renderer.addToFrame(title);
            Renderer.render();


            input.nextLine();
        }
    }
}
