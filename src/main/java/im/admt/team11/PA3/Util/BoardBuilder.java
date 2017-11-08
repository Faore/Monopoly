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
        tiles.add(
                new StandardProperty("Kentucky Avenue",
                        new Point2D(423,410),
                        new Point2D(652,9),
                        TileOrientation.Top
                )
        );
        tiles.add(
                new SpecialTile("Chance",
                        new Point2D(665,410),
                        new Point2D(890,9),
                        TileOrientation.Top,
                        SpecialTileTypes.Chance
                )
        );
        tiles.add(
                new StandardProperty("Indiana Avenue",
                        new Point2D(905,410),
                        new Point2D(1130,9),
                        TileOrientation.Top
                )
        );
        tiles.add(
                new StandardProperty("Illinois Avenue",
                        new Point2D(1145,410),
                        new Point2D(1374,9),
                        TileOrientation.Top
                )
        );
        tiles.add(
                new StandardProperty("B. & O. Railroad",
                        new Point2D(1385,410),
                        new Point2D(1612,9),
                        TileOrientation.Top
                )
        );
        tiles.add(
                new StandardProperty("Atlantic Avenue",
                        new Point2D(1625,410),
                        new Point2D(1850,9),
                        TileOrientation.Top
                )
        );
        tiles.add(
                new StandardProperty("Ventnor Avenue",
                        new Point2D(1865,410),
                        new Point2D(2090,9),
                        TileOrientation.Top
                )
        );
        tiles.add(
                new StandardProperty("Water Works",
                        new Point2D(2107,410),
                        new Point2D(2334,9),
                        TileOrientation.Top
                )
        );
        tiles.add(
                new StandardProperty("Marvin Gardens",
                        new Point2D(2345,410),
                        new Point2D(2574,9),
                        TileOrientation.Top
                )
        );
        tiles.add(
                new SpecialTile("Go To Jail",
                        new Point2D(2587,410),
                        new Point2D(2988,9),
                        TileOrientation.Corner,
                        SpecialTileTypes.GoToJail
                )
        );
        tiles.add(
                new StandardProperty("Pacific Avenue",
                        new Point2D(2585,650),
                        new Point2D(2990,423),
                        TileOrientation.Right
                )
        );
        tiles.add(
                new StandardProperty("North Carolina Avenue",
                        new Point2D(2585,892),
                        new Point2D(2990,665),
                        TileOrientation.Right
                )
        );
        tiles.add(
                new SpecialTile("Community Chest",
                        new Point2D(2585,1132),
                        new Point2D(2990,905),
                        TileOrientation.Right,
                        SpecialTileTypes.CommunityChest
                )
        );
        tiles.add(
                new StandardProperty("Pennsylvania Avenue",
                        new Point2D(2585,1368),
                        new Point2D(2990,1147),
                        TileOrientation.Right
                )
        );
        tiles.add(
                new StandardProperty("Short Line",
                        new Point2D(2585,1612),
                        new Point2D(2990,1387),
                        TileOrientation.Right
                )
        );
        tiles.add(
                new SpecialTile("Chance",
                        new Point2D(2585,1852),
                        new Point2D(2990,1625),
                        TileOrientation.Right,
                        SpecialTileTypes.Chance
                )
        );
        tiles.add(
                new StandardProperty("Park Place",
                        new Point2D(2585,2090),
                        new Point2D(2990,1865),
                        TileOrientation.Right
                )
        );
        tiles.add(
                new SpecialTile("Luxury Tax",
                        new Point2D(2585,2330),
                        new Point2D(2990,2109),
                        TileOrientation.Right,
                        SpecialTileTypes.LuxuryTax
                )
        );
        tiles.add(
                new StandardProperty("Boardwalk",
                        new Point2D(2585,2572),
                        new Point2D(2990,2349),
                        TileOrientation.Right
                )
        );
        return tiles;
    }
}