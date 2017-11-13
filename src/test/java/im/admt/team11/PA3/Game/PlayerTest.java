package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    public void testAuctionDeed() throws Exception {
        Deed deed = new Deed(60, 2, 50, 10,30,90,160, 250);
        Player player = new Player(1, TokenTypes.Blue);
        player.buyDeed(deed, 1500);
        assertTrue(player.deeds.contains(deed));
        assertEquals(0, player.getMoney());
    }
}
