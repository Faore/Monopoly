package esof322.pa4.team11.Game.Util;

import esof322.pa4.team11.Game.Board.Card.Deed;
import esof322.pa4.team11.Game.Board.Tile;
import esof322.pa4.team11.Game.UI.GameWindowController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoardBuilderTest {

    @Test
    public void testFullMonopolyBoard() throws Exception {
        ObservableList<Tile> tiles = FXCollections.observableArrayList();
        ObservableList<Deed> deeds = FXCollections.observableArrayList();
        BoardBuilder.buildBoard(tiles, deeds);
        assertTrue(deeds.size() == 28);
        assertTrue(tiles.size() == 40);
    }
}
