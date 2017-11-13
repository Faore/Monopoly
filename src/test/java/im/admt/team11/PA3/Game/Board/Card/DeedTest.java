package im.admt.team11.PA3.Game.Board.Card;

import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import org.junit.Test;

import im.admt.team11.PA3.Game.Player;
import static org.junit.Assert.*;

public class DeedTest {

    //Create test data
    private Deed testDeedBoardwalk;

    public DeedTest() throws Exception {
        testDeedBoardwalk = new Deed(400, 50, 200, 200, 600, 1400, 1700, 200);
    }

    @Test
    public void testGetRent() throws Exception {
        int expectedRent = 50;
        assertEquals(expectedRent, testDeedBoardwalk.rent);
    }

    @Test
    public void testGetOwner() throws Exception {
        int expectedPlayerNumber = 1;

        assertTrue(null == testDeedBoardwalk.currentOwner);
    }

    @Test
    public void testGetCurrentBuildingLevel() throws Exception {
        assertEquals(0, testDeedBoardwalk.getCurrentBuildingLevel());
    }

}