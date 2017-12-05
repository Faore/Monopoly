package esof322.pa4.team11.Game.Util;

import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TokenMapTest {

    @Test
    public void testGetTokenMap() {
        HashMap<TokenTypes, String> map = TokenMap.getTokenMap();
        assertEquals(map.get(TokenTypes.Blue),"/BlueToken.png");
        assertEquals(map.get(TokenTypes.Green),"/GreenToken.png");
        assertEquals(map.get(TokenTypes.Yellow),"/YellowToken.png");
        assertEquals(map.get(TokenTypes.Red),"/RedToken.png");
    }

    @Test
    public void testGetHouseMap() {
        HashMap<TokenTypes, String> map = TokenMap.getHouseMap();
        assertEquals(map.get(TokenTypes.Blue),"/BlueHouse.png");
        assertEquals(map.get(TokenTypes.Green),"/GreenHouse.png");
        assertEquals(map.get(TokenTypes.Yellow),"/YellowHouse.png");
        assertEquals(map.get(TokenTypes.Red),"/RedHouse.png");
    }

    @Test
    public void testGetHotelMap() {
        HashMap<TokenTypes, String> map = TokenMap.getHotelMap();
        assertEquals(map.get(TokenTypes.Blue),"/BlueHotel.png");
        assertEquals(map.get(TokenTypes.Green),"/GreenHotel.png");
        assertEquals(map.get(TokenTypes.Yellow),"/YellowHotel.png");
        assertEquals(map.get(TokenTypes.Red),"/RedHotel.png");
    }
}
