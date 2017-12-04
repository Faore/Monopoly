package esof322.pa4.team11.Game;

import esof322.pa4.team11.Game.Board.Card.Card;
import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import esof322.pa4.team11.GameSettings;
import javafx.collections.ObservableList;
import org.junit.Assert;
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
    public void playerTokensInitialized() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        assertEquals(1, board.playerTokens.size());
        assertEquals(TokenTypes.Blue, board.playerTokens.get(0).tokenType);
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
    public void testGetChanceCard16() throws Exception {
        //Because 16 is special.
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        board.chanceCards.add(0, new Card(16,"Bank pays you dividend of $50"));
        Assert.assertEquals(board.getChanceCard(), board.chanceJailCard);
    }

    @Test
    public void testGetChestCard16() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        board.chestCards.add(0, new Card(1,"Doctor's fee. Pay $50"));
        assertEquals(1, board.getChestCard().getCardNum());
    }

    @Test
    public void testGetChestCard() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        board.chestCards.add(0, new Card(16,"Doctor's fee. Pay $50"));
        Assert.assertEquals(board.getChestCard(), board.chestJailCard);
    }

    @Test
    public void testReplaceChanceJailCard() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        board.chanceCards.clear();
        board.chanceCards.add(0, new Card(16,"Bank pays you dividend of $50"));
        board.getChanceCard();
        board.replaceChanceJailCard();
        assertEquals(board.chanceJailCard, board.chanceCards.get(0));
    }

    @Test
    public void testReplaceChestJailCard() throws Exception {
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(new Player(1, TokenTypes.Blue));
        GameBoard board = new GameBoard(gameSettings);
        board.chestCards.clear();
        board.chestCards.add(0, new Card(16,"Bank pays you dividend of $50"));
        board.getChestCard();
        board.replaceChestJailCard();
        assertEquals(board.chestJailCard, board.chestCards.get(0));
    }
}
