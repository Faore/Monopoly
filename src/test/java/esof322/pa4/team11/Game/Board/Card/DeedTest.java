package esof322.pa4.team11.Game.Board.Card;

import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import esof322.pa4.team11.Game.Board.Tiles.Properties.StandardProperty;
import esof322.pa4.team11.Game.Board.Tiles.Property;
import esof322.pa4.team11.Game.Board.Tiles.TileOrientation;
import esof322.pa4.team11.Game.Player;
import esof322.pa4.team11.Game.UI.GameWindowController;
import javafx.geometry.Point2D;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeedTest extends ApplicationTest{

    //Create test data
    private Deed testDeedBoardwalk;

    public DeedTest() throws Exception {
        testDeedBoardwalk = new Deed(400, 50, 200, 200, 600, 1400, 1700, 200);
    }

    @Test
    public void testInitialize() throws Exception {
        Deed railroad = new Deed(200, 25);
        Deed utility = new Deed(150);
        assertTrue(testDeedBoardwalk instanceof Deed);
        assertTrue(railroad instanceof Deed);
        assertTrue(utility instanceof Deed);
    }

    @Test
    public void testGetRentRailroad() throws Exception {
        Deed railroad = new Deed(200, 25);
        Deed railroad2 = new Deed(200, 25);
        Player player = new Player(1, TokenTypes.Blue);
        railroad.setOwner(player);
        railroad2.setOwner(player);
        railroad.associateWithDeed(railroad2);
        int expectedRent = 100;
        assertEquals(expectedRent, railroad.getRent());
    }

    @Test
    public void testGetRentWithHouses() throws Exception {
        testDeedBoardwalk.setOwner(new Player(1, TokenTypes.Blue));
        testDeedBoardwalk.addBuildingLevel();
        testDeedBoardwalk.addBuildingLevel();
        int expectedRent = 600;
        assertEquals(expectedRent, testDeedBoardwalk.getRent());
    }

    @Test
    public void testGetOwner() throws Exception {
        assertTrue(null == testDeedBoardwalk.getOwner());
    }

    @Test
    public void testGetCurrentBuildingLevel() throws Exception {
        assertEquals(0, testDeedBoardwalk.getCurrentBuildingLevel());
    }

    @Test
    public void testSetOwner() throws Exception {
        Player player = new Player(1, TokenTypes.Blue);
        testDeedBoardwalk.setOwner(player);
        assertEquals(player, testDeedBoardwalk.currentOwner);
    }

    @Test
    public void testSetMortgaged() throws Exception {
        testDeedBoardwalk.setOwner(new Player(1, TokenTypes.Blue));
        testDeedBoardwalk.setMortgaged(true);
        assertEquals(true, testDeedBoardwalk.isMortgaged);
    }

    @Test
    public void testAssociateWithDeed() throws Exception {
        Deed testDeedParkPlace = new Deed(350, 35, 200, 175,500,1100,1300, 1500);
        testDeedBoardwalk.associatedDeeds.add(testDeedParkPlace);
        testDeedParkPlace.associatedDeeds.add(testDeedBoardwalk);
        assertTrue(testDeedBoardwalk.associatedDeeds.get(0) == testDeedParkPlace);
        assertTrue(testDeedParkPlace.associatedDeeds.get(0) == testDeedBoardwalk);
    }

    @Test
    public void testAttachToProperty() throws Exception {
        Property boardwalk = new StandardProperty("Mediterranean Avenue",
                new Point2D(2344, 2993),
                new Point2D(2577, 2585),
                TileOrientation.Bottom, testDeedBoardwalk);
        testDeedBoardwalk.attachToProperty(boardwalk);
        assertEquals(boardwalk, testDeedBoardwalk.getProperty());
    }

    @Test
    public void testGetProperty() throws Exception {
        Property boardwalk = new StandardProperty("Mediterranean Avenue",
                new Point2D(2344, 2993),
                new Point2D(2577, 2585),
                TileOrientation.Bottom, testDeedBoardwalk);
        assertTrue(boardwalk == testDeedBoardwalk.getProperty());
    }

    @Test
    public void testAddAndRemoveBuildingLevelOnStandard() throws Exception {
        testDeedBoardwalk.addBuildingLevel();
        testDeedBoardwalk.removeBuildingLevel();
        assertEquals(0, testDeedBoardwalk.getCurrentBuildingLevel());
    }

    @Test
    public void testToString() throws Exception {
        Property boardwalk = new StandardProperty("Mediterranean Avenue",
                new Point2D(2344, 2993),
                new Point2D(2577, 2585),
                TileOrientation.Bottom, testDeedBoardwalk);
        assertTrue(boardwalk.name == testDeedBoardwalk.toString());
    }
}