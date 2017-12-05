package esof322.pa4.team11.Game.Board;

import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import esof322.pa4.team11.Game.Board.Tiles.SpecialTile;
import esof322.pa4.team11.Game.Board.Tiles.SpecialTileTypes;
import esof322.pa4.team11.Game.Board.Tiles.TileOrientation;
import esof322.pa4.team11.Game.Player;
import javafx.geometry.Point2D;
import org.junit.Assert;
import org.junit.Test;

public class TileTest {
    @Test
    public void testTile() {
        Tile tile = new SpecialTile("Go",
                new Point2D(2585, 2993),
                new Point2D(2993, 2583),
                TileOrientation.Corner,
                SpecialTileTypes.Go
        );
        Assert.assertEquals(0, tile.firstFreeTokenSlot());
        Player player = new Player(1, TokenTypes.Blue);
        tile.tokensInSlots[0] = player.token;
        Assert.assertEquals(1, tile.firstFreeTokenSlot());
    }
}
