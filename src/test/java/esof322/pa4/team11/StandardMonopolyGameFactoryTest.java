package esof322.pa4.team11;

import esof322.pa4.team11.Game.GameBoard;
import esof322.pa4.team11.Game.Util.CardBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardMonopolyGameFactoryTest {
    @Test
    public void chanceCardsInitialized() throws Exception {
        GameSettings gameSettings = new GameSettings();
        GameBoard board = new GameBoard(gameSettings);
        CardBuilder.buildChanceCard(board.chanceCards);
        assertEquals(16, board.chanceCards.size());
    }

    @Test
    public void chestCardsInitialized() throws Exception {
        GameSettings gameSettings = new GameSettings();
        GameBoard board = new GameBoard(gameSettings);
        CardBuilder.buildChanceCard(board.chestCards);
        assertEquals(16, board.chestCards.size());
    }
}
