package esof322.pa4.team11.Game.Board.Card;

import esof322.pa4.team11.Game.UI.GameWindowController;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeedTest {

    //Create test data
    private Deed testDeedBoardwalk;

    public DeedTest() throws Exception {
        testDeedBoardwalk = new Deed(400, 50, 200, 200, 600, 1400, 1700, 200, new GameWindowController());
    }

    @Test
    public void testGetRent() throws Exception {
        int expectedRent = 50;
        assertEquals(expectedRent, testDeedBoardwalk.rent);
    }

    @Test
    public void testGetOwner() throws Exception {

        assertTrue(null == testDeedBoardwalk.currentOwner);
    }

    @Test
    public void testGetCurrentBuildingLevel() throws Exception {
        assertEquals(0, testDeedBoardwalk.getCurrentBuildingLevel());
    }

}