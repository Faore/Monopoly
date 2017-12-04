package esof322.pa4.team11.Game.Util;

import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import org.junit.Test;

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
