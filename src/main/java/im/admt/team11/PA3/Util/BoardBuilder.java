package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTile;

import im.admt.team11.PA3.Game.Board.Tiles.SpecialTileTypes;
import javafx.geometry.Point2D;
import java.util.ArrayList;

public class BoardBuilder {
    public static ArrayList<Tile> buildTileList() {
        ArrayList<Tile> tiles = new ArrayList<Tile>();

        //Go
        tiles.add(new SpecialTile("Go", new Point2D(0,0), new Point2D(0,0), SpecialTileTypes.Go));
        return tiles;
    }
}