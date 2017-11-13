package im.admt.team11.PA3.Game.Board.Pieces;

import im.admt.team11.PA3.Game.Player;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class TokenTest extends ApplicationTest {
    @Test
    public void testInitialize() {
        Player player = new Player(1, TokenTypes.Blue);
        Token token = new Token(TokenTypes.Blue, player);
    }
}