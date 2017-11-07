package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.StandardProperty;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTile;

import im.admt.team11.PA3.Game.Board.Tiles.SpecialTileTypes;
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
                        new Point2D[]{new Point2D(2683, 2700), new Point2D(2893, 2689), new Point2D(2680, 2897), new Point2D(2891, 2902)},
                        SpecialTileTypes.Go)
        );
        tiles.add(
                new StandardProperty("Mediterranean Avenue",
                        new Point2D(2344, 2993),
                        new Point2D(2577, 2585),
                        new Point2D[]{new Point2D(2402, 2758), new Point2D(2510, 2767), new Point2D(2389, 2917), new Point2D(2520, 2929)},
                        new Point2D[]{new Point2D(2371,2639), new Point2D(2415, 2638), new Point2D(2508, 2637), new Point2D(2557, 2635)}
                        )
        );
        return tiles;
    }
}