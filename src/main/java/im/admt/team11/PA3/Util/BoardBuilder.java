package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.StandardProperty;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTile;

import im.admt.team11.PA3.Game.Board.Tiles.SpecialTileTypes;
import im.admt.team11.PA3.Game.Board.Tiles.TileOrientation;
import javafx.geometry.Point2D;

import java.util.ArrayList;

public class BoardBuilder {
    public static ArrayList<Tile> buildTileList() {
        ArrayList<Tile> tiles = new ArrayList<Tile>();
        //Go
        tiles.add(
                new SpecialTile("Go",
                        new Point2D(2585, 2993),
                        new Point2D(2993, 2583),
                        TileOrientation.Corner,
                        SpecialTileTypes.Go)
        );
        tiles.add(
                new StandardProperty("Mediterranean Avenue",
                        new Point2D(2344, 2993),
                        new Point2D(2577, 2585),
                        TileOrientation.Bottom
                )
        );
        return tiles;
    }
}