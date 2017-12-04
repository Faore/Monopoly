package esof322.pa4.team11;

import esof322.pa4.team11.Game.GameBoard;
import esof322.pa4.team11.Game.Util.CardBuilder;
import esof322.pa4.team11.Game.Util.ThemedCardBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OverwatchMonopolyGameFactoryTest {
    @Test
    public void overwatchChanceCardsInitializedTest() throws Exception {
        GameSettings gameSettings = new GameSettings();
        GameBoard board = new GameBoard(gameSettings);
        ThemedCardBuilder.buildChanceCard(board.chanceCards);
        assertEquals(16, board.chanceCards.size());
    }

    @Test
    public void overwatchChestCardsInitializedTest() throws Exception {
        GameSettings gameSettings = new GameSettings();
        GameBoard board = new GameBoard(gameSettings);
        ThemedCardBuilder.buildChanceCard(board.chestCards);
        assertEquals(16, board.chestCards.size());
    }
}
