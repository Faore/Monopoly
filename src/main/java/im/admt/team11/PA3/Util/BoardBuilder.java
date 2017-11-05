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
        tiles.add(new SpecialTile("Go", new Point2D(2585, 2993), new Point2D(2993, 2583), new Point2D(2683, 2700), new Point2D(2893, 2689), new Point2D(2680,2897), new Point2D(2891,2902), SpecialTileTypes.Go));
        return tiles;
    }
}