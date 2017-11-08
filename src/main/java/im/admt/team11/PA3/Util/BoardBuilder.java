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
        tiles.add(
                new SpecialTile("Community Chest",
                        new Point2D(2105, 2988),
                        new Point2D(2334,2589),
                        TileOrientation.Bottom,
                        SpecialTileTypes.CommunityChest)
        );
        tiles.add(
                new StandardProperty("Baltic Avenue",
                        new Point2D(1865,2984),
                        new Point2D(2092,2587),
                        TileOrientation.Bottom
                )
        );
        tiles.add(
                new SpecialTile("Income Tax",
                        new Point2D(1626,2987),
                        new Point2D(1852,2586),
                        TileOrientation.Bottom,
                        SpecialTileTypes.IncomeTax
                )
        );
        tiles.add(
                new StandardProperty("Reading Railroad",
                        new Point2D(1384,2990),
                        new Point2D(1613,2588),
                        TileOrientation.Bottom
                )
        );
        tiles.add(
                new StandardProperty("Oriental Avenue",
                        new Point2D(1144,2989),
                        new Point2D(1370,2587),
                        TileOrientation.Bottom
                )
        );
        tiles.add(
                new SpecialTile("Chance",
                        new Point2D(905,2990),
                        new Point2D(1132,2588),
                        TileOrientation.Bottom,
                        SpecialTileTypes.Chance
                )
        );
        tiles.add(
                new StandardProperty("Vermont Avenue",
                        new Point2D(666,2988),
                        new Point2D(893,2585),
                        TileOrientation.Bottom
                )
        );
        tiles.add(
                new StandardProperty("Connecticut Avenue",
                        new Point2D(423,2989),
                        new Point2D(653,2587),
                        TileOrientation.Bottom
                )
        );
        tiles.add(
                new SpecialTile("Jail",
                        new Point2D(9,2990),
                        new Point2D(410,2588),
                        TileOrientation.Corner,
                        SpecialTileTypes.Jail
                )
        );
        tiles.add(
                new StandardProperty("St. Charles Place",
                        new Point2D(9,2574),
                        new Point2D(410,2349),
                        TileOrientation.Left
                )
        );
        tiles.add(
                new StandardProperty("Electric Company",
                        new Point2D(9,2332),
                        new Point2D(410,2107),
                        TileOrientation.Left
                )
        );
        tiles.add(
                new StandardProperty("States Avenue",
                        new Point2D(9,2092),
                        new Point2D(410,1867),
                        TileOrientation.Left
                )
        );
        tiles.add(
                new StandardProperty("Virginia Avenue",
                        new Point2D(9,1852),
                        new Point2D(410,1627),
                        TileOrientation.Left
                )
        );
        tiles.add(
                new StandardProperty("Pennsylvania Railroad",
                        new Point2D(9,1612),
                        new Point2D(410,1387),
                        TileOrientation.Left
                )
        );
        tiles.add(
                new StandardProperty("St. James Place",
                        new Point2D(9,1372),
                        new Point2D(410,1147),
                        TileOrientation.Left
                )
        );
        tiles.add(
                new SpecialTile("Community Chest",
                        new Point2D(9,1132),
                        new Point2D(410,907),
                        TileOrientation.Left,
                        SpecialTileTypes.CommunityChest
                )
        );
        tiles.add(
                new StandardProperty("Tennessee Avenue",
                        new Point2D(9,892),
                        new Point2D(410,667),
                        TileOrientation.Left
                )
        );
        tiles.add(
                new StandardProperty("New York Avenue",
                        new Point2D(9,650),
                        new Point2D(410,427),
                        TileOrientation.Left
                )
        );
        tiles.add(
                new SpecialTile("Free Parking",
                        new Point2D(9,408),
                        new Point2D(410,9),
                        TileOrientation.Corner,
                        SpecialTileTypes.FreeParking
                )
        );
        return tiles;
    }
}