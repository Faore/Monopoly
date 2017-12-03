package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Card;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameBoardTest {
    @Test
    public void initializedObjects() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        assertTrue(board instanceof GameBoard);
        assertTrue(board.tiles instanceof ObservableList);
        assertTrue(board.playerTokens instanceof ObservableList);
        assertTrue(board.deeds instanceof ObservableList);
        assertTrue(board.chanceCards instanceof  ObservableList);
        assertTrue(board.chestCards instanceof ObservableList);
    }

    @Test
    public void tilesInitialized() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        assertEquals(40, board.tiles.size());
    }

    @Test
    public void playerTokensInitialized() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        assertEquals(1, board.playerTokens.size());
        assertEquals(TokenTypes.Blue, board.playerTokens.get(0).tokenType);
    }

    @Test
    public void deedsInitialized() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        assertEquals(28, board.deeds.size());
    }

    @Test
    public void chanceCardsInitialized() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        assertEquals(16, board.chanceCards.size());
    }

    @Test
    public void chestCardsInitialized() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        assertEquals(16, board.chestCards.size());
    }

    @Test
    public void testGetChanceCard() throws Exception{
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        board.chanceCards.add(0, new Card(1,"Bank pays you dividend of $50"));
        assertEquals(1, board.getChanceCard().getCardNum());
    }

    @Test
    public void testGetChestCard() throws Exception{
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        board.chestCards.add(0, new Card(1,"Doctor's fee. Pay $50"));
        assertEquals(1, board.getChestCard().getCardNum());
    }
}
