package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Tile;
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
