package esof322.pa4.team11.Game;

import esof322.pa4.team11.Game.Board.Card.Deed;
import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import esof322.pa4.team11.Game.UI.GameWindowController;
import esof322.pa4.team11.GameSettings;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class PlayerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }

    @Test
    public void testInitialize() {
        Player player = new Player(1, TokenTypes.Blue);
    }

    @Test
    public void testGetMoney() {
        assertEquals(1500, new Player(1, TokenTypes.Blue).getMoney());
    }

    @Test
    public void testAddMoney() {
        Player player = new Player(1, TokenTypes.Blue);
        player.giveMoney(45);
        player.giveMoney(55);
        assertEquals(1600, player.getMoney());
    }

    @Test
    public void testRemoveMoney() {
        Player player = new Player(1, TokenTypes.Blue);
        player.takeMoney(45);
        player.takeMoney(5);
        assertEquals(1450, player.getMoney());
    }

    @Test
    public void testCollectMoneyFromPlayer() {
        Player player1 = new Player(1, TokenTypes.Blue);
        Player player2 = new Player(2, TokenTypes.Blue);
        player1.collectMoneyFromPlayer(player2, 1000);
        assertEquals(500, player2.getMoney());
        assertEquals(2500, player1.getMoney());
    }

    @Test
    public void testBuyDeed() throws Exception {
        Deed deed = new Deed(60, 2, 50, 10,30,90,160, 250);
        Player player = new Player(1, TokenTypes.Blue);
        player.buyDeed(deed);
        assertTrue(player.deeds.contains(deed));
        assertEquals(1440, player.getMoney());
    }

    @Test
    public void testAuctionDeed() throws Exception {
        Deed deed = new Deed(60, 2, 50, 10,30,90,160, 250);
        Player player = new Player(1, TokenTypes.Blue);
        player.buyDeed(deed, 1500);
        assertTrue(player.deeds.contains(deed));
        assertEquals(0, player.getMoney());
    }

    @Test
    public void testSetInJail() {
        Player player = new Player(1, TokenTypes.Blue);
        assertFalse(player.inJail());
        player.setInJail(true);
        assertTrue(player.inJail());
        player.setInJail(false);
        assertFalse(player.inJail());
    }

    @Test
    public void testDecrementJailTime() {
        Player player = new Player(1, TokenTypes.Blue);
        player.setInJail(true);
        assertTrue(player.inJail());
        player.decrementTimeInJail();
        assertTrue(player.inJail());
        player.decrementTimeInJail();
        assertTrue(player.inJail());
        player.decrementTimeInJail();
        assertFalse(player.inJail());
    }

    @Test
    public void testPlayerValue() throws Exception {
        Player player = new Player(1, TokenTypes.Blue);
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(player);
        GameBoard gameBoard = new GameBoard(gameSettings);
        Deed deed1 = new Deed(60);
        Deed deed2 = new Deed(60);
        deed1.setOwner(player);
        deed2.setOwner(player);
        deed2.setMortgaged(true);
        assertEquals(1590, player.getPlayerValue());
    }

    @Test
    public void testGetToken() {
        Player player = new Player(1, TokenTypes.Blue);
        assertNotNull(player.getToken());
        assertEquals(TokenTypes.Blue, player.getToken().tokenType);
    }

    @Test
    public void testBuyDeedFail() throws Exception {
        Player player = new Player(1, TokenTypes.Blue);
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(player);
        Deed deed = new Deed(250);
        deed.setOwner(player);
        try {
            player.buyDeed(deed);
        } catch (Exception e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);
    }

    @Test
    public void testBuyDeedAuctionFail() throws Exception {
        Player player = new Player(1, TokenTypes.Blue);
        GameSettings gameSettings = new GameSettings();
        gameSettings.players.add(player);
        Deed deed = new Deed(250);
        deed.setOwner(player);
        try {
            player.buyDeed(deed, 50);
        } catch (Exception e) {
            assertTrue(true);
            return;
        }
        assertTrue(false);
    }
}
