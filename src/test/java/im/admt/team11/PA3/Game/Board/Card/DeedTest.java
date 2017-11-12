package im.admt.team11.PA3.Game.Board.Card;

import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;
import im.admt.team11.PA3.Game.Board.Tiles.TileOrientation;
import javafx.geometry.Point2D;
import org.junit.Test;

import im.admt.team11.PA3.Game.Board.Tiles.Properties.Railroad;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.StandardProperty;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.Utility;
import im.admt.team11.PA3.Game.Board.Tiles.Property;
import im.admt.team11.PA3.Game.MonopolyGame;
import im.admt.team11.PA3.Game.Player;

import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.*;

public class DeedTest {

    //Create test data
    private Deed testDeedBoardwalk = new Deed(400, 50, 200, 200, 600, 1400, 1700, 200);
    private Property testProperty = new StandardProperty("Boardwalk", new Point2D(2585,2572),
            new Point2D(2990,2349), TileOrientation.Right, testDeedBoardwalk);

    private Player currentOwner = new Player(1, TokenTypes.Blue);

    public ArrayList<Deed> associatedDeeds;

    private int currentBuildingLevel = 5;

    public DeedTest() throws Exception {
    }

    @Test
    public void testGetRent() throws Exception {
        int expectedRent = 50;

        assertEquals(expectedRent, testDeedBoardwalk.rent, 0);
    }

    @Test
    public void testGetOwner() throws Exception {
        int expectedPlayerNumber = 1;

        assertEquals(currentOwner.playerNumber, expectedPlayerNumber, 0);
    }

    @Test
    public void testGetCurrentBuildingLevel() throws Exception {
        int buildingLevelTest = 5;

        assertEquals(buildingLevelTest, currentBuildingLevel, 0);
    }

    @Test
    public void testToString() throws Exception {
        String testName = "Boardwalk";

        assertEquals(testName, testProperty.name, 0);
    }

}