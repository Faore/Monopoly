package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TokenMapTest {

    @Test
    public void getTokenMapTest() {
        HashMap<TokenTypes, String> map = TokenMap.getTokenMap();
        assertEquals(map.get(TokenTypes.Blue),"/BlueToken.png");
        assertEquals(map.get(TokenTypes.Green),"/GreenToken.png");
        assertEquals(map.get(TokenTypes.Yellow),"/YellowToken.png");
        assertEquals(map.get(TokenTypes.Red),"/RedToken.png");
    }
}
