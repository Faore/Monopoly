package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.Railroad;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.StandardProperty;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.Utility;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTile;

import im.admt.team11.PA3.Game.Board.Tiles.SpecialTileTypes;
import im.admt.team11.PA3.Game.Board.Tiles.TileOrientation;
import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;

import java.util.ArrayList;

public class ThemedBoardBuilder {

    public static void associateDeed(ArrayList<Deed> deeds, Deed deed) {
        for (Deed d: deeds) {
            deed.associateWithDeed(d);
        }
        deeds.add(deed);
    }

    public static void buildBoard(ObservableList<Tile> tiles, ObservableList<Deed> deeds) throws Exception {

        ArrayList<Deed> utilities = new ArrayList<>();
        ArrayList<Deed> railroads = new ArrayList<>();

        ArrayList<Deed> brown = new ArrayList<>();
        ArrayList<Deed> lightblue = new ArrayList<>();
        ArrayList<Deed> pink = new ArrayList<>();
        ArrayList<Deed> orange = new ArrayList<>();
        ArrayList<Deed> red = new ArrayList<>();
        ArrayList<Deed> yellow = new ArrayList<>();
        ArrayList<Deed> green = new ArrayList<>();
        ArrayList<Deed> blue = new ArrayList<>();

        Deed deed;
        //Go

        tiles.add(
                new SpecialTile("Go",
                        new Point2D(2585, 2993),
                        new Point2D(2993, 2583),
                        TileOrientation.Corner,
                        SpecialTileTypes.Go
                )
        );
        deed = new Deed(60, 2, 50, 10,30,90,160, 250);
        associateDeed(brown, deed);
        tiles.add(
                new StandardProperty("Watchpoint Gibraltar",
                        new Point2D(2344, 2993),
                        new Point2D(2577, 2585),
                        TileOrientation.Bottom,
                        deed
                )
        );
        tiles.add(
                new SpecialTile("Community Chest",
                        new Point2D(2105, 2988),
                        new Point2D(2334,2589),
                        TileOrientation.Bottom,
                        SpecialTileTypes.CommunityChest)
        );
        deed = new Deed(60, 4, 50, 20,60,180,320, 450);
        associateDeed(brown, deed);
        tiles.add(
                new StandardProperty("Omnic Junkyard",
                        new Point2D(1865,2984),
                        new Point2D(2092,2587),
                        TileOrientation.Bottom,
                        deed
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
        deed = new Deed(200, 25);
        associateDeed(railroads, deed);
        tiles.add(
                new Railroad("Durado Payload",
                        new Point2D(1384,2990),
                        new Point2D(1613,2588),
                        TileOrientation.Bottom,
                        deed
                )
        );
        deed = new Deed(100, 6, 50, 30,90,270,400, 550);
        associateDeed(lightblue, deed);
        tiles.add(
                new StandardProperty("Bar at Eichenwalde",
                        new Point2D(1144,2989),
                        new Point2D(1370,2587),
                        TileOrientation.Bottom,
                        deed
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
        deed = new Deed(100, 6, 50, 30,90,270,400, 550);
        associateDeed(lightblue, deed);
        tiles.add(
                new StandardProperty("Hollywood Theater",
                        new Point2D(666,2988),
                        new Point2D(893,2585),
                        TileOrientation.Bottom,
                        deed
                )
        );
        deed = new Deed(120, 8, 50, 40,100,300,450, 600);
        associateDeed(lightblue, deed);
        tiles.add(
                new StandardProperty("Horizon Transit",
                        new Point2D(423,2989),
                        new Point2D(653,2587),
                        TileOrientation.Bottom,
                        deed
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
        deed = new Deed(140, 10, 100, 50,150,450,625, 750);
        associateDeed(pink, deed);
        tiles.add(
                new StandardProperty("Underworld",
                        new Point2D(9,2574),
                        new Point2D(410,2349),
                        TileOrientation.Left,
                        deed
                )
        );
        deed = new Deed(150);
        associateDeed(utilities, deed);
        tiles.add(
                new Utility("Electric Company",
                        new Point2D(9,2332),
                        new Point2D(410,2107),
                        TileOrientation.Left,
                        deed
                )
        );
        deed = new Deed(140, 10, 100, 50,150,450,625, 750);
        associateDeed(pink, deed);
        tiles.add(
                new StandardProperty("Climbing Wall",
                        new Point2D(9,2092),
                        new Point2D(410,1867),
                        TileOrientation.Left,
                        deed
                )
        );
        deed = new Deed(160, 12, 100, 60,180,500,700, 900);
        associateDeed(pink, deed);
        tiles.add(
                new StandardProperty("Canyon Caves",
                        new Point2D(9,1852),
                        new Point2D(410,1627),
                        TileOrientation.Left,
                        deed
                )
        );
        deed = new Deed(200, 25);
        associateDeed(railroads, deed);
        tiles.add(
                new Railroad("Eichenwalde Payload",
                        new Point2D(9,1612),
                        new Point2D(410,1387),
                        TileOrientation.Left,
                        deed
                )
        );
        deed = new Deed(180, 14, 100, 70,200,550,750, 950);
        associateDeed(orange, deed);
        tiles.add(
                new StandardProperty("Genji's Dojo",
                        new Point2D(9,1372),
                        new Point2D(410,1147),
                        TileOrientation.Left,
                        deed
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
        deed = new Deed(180, 14, 100, 70,200,550,750, 950);
        associateDeed(orange, deed);
        tiles.add(
                new StandardProperty("Hanzo's Hut",
                        new Point2D(9,892),
                        new Point2D(410,667),
                        TileOrientation.Left,
                        deed
                )
        );
        deed = new Deed(200, 16, 100, 80,220,600,800, 1000);
        associateDeed(orange, deed);
        tiles.add(
                new StandardProperty("Big Earl's",
                        new Point2D(9,650),
                        new Point2D(410,427),
                        TileOrientation.Left,
                        deed
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
        deed = new Deed(220, 18, 150, 90,250,700,875, 1050);
        associateDeed(red, deed);
        tiles.add(
                new StandardProperty("Castle Entrance",
                        new Point2D(423,410),
                        new Point2D(652,9),
                        TileOrientation.Top,
                        deed
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
        deed = new Deed(220, 18, 150, 90,250,700,875, 1050);
        associateDeed(red, deed);
        tiles.add(
                new StandardProperty("Tracer Avenue",
                        new Point2D(905,410),
                        new Point2D(1130,9),
                        TileOrientation.Top,
                        deed
                )
        );
        deed = new Deed(240, 20, 150, 100,300,750,925, 1100);
        associateDeed(red, deed);
        tiles.add(
                new StandardProperty("Anubis Pottery",
                        new Point2D(1145,410),
                        new Point2D(1374,9),
                        TileOrientation.Top,
                        deed
                )
        );
        deed = new Deed(200, 25);
        associateDeed(railroads, deed);
        tiles.add(
                new Railroad("Gibraltar Payload",
                        new Point2D(1385,410),
                        new Point2D(1612,9),
                        TileOrientation.Top,
                        deed
                )
        );
        deed = new Deed(260, 22, 150, 110,330,800,975, 1150);
        associateDeed(yellow, deed);
        tiles.add(
                new StandardProperty("King's Row",
                        new Point2D(1625,410),
                        new Point2D(1850,9),
                        TileOrientation.Top,
                        deed
                )
        );
        deed = new Deed(260, 22, 150, 110,330,800,975, 1150);
        associateDeed(yellow, deed);
        tiles.add(
                new StandardProperty("Durado Market",
                        new Point2D(1865,410),
                        new Point2D(2090,9),
                        TileOrientation.Top,
                        deed
                )
        );
        deed = new Deed(150);
        associateDeed(utilities, deed);
        tiles.add(
                new Utility("Water Works",
                        new Point2D(2107,410),
                        new Point2D(2334,9),
                        TileOrientation.Top,
                        deed
                )
        );
        deed = new Deed(280, 24, 150, 120,360,850,1025, 1200);
        associateDeed(yellow, deed);
        tiles.add(
                new StandardProperty("Temple Gate",
                        new Point2D(2345,410),
                        new Point2D(2574,9),
                        TileOrientation.Top,
                        deed
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
        deed = new Deed(300, 26, 200, 130,390,900,1100, 1275);
        associateDeed(green, deed);
        tiles.add(
                new StandardProperty("Twin Dragons",
                        new Point2D(2585,650),
                        new Point2D(2990,423),
                        TileOrientation.Right,
                        deed
                )
        );
        deed = new Deed(300, 26, 200, 130,390,900,1100, 1275);
        associateDeed(green, deed);
        tiles.add(
                new StandardProperty("Nepal Shrine",
                        new Point2D(2585,892),
                        new Point2D(2990,665),
                        TileOrientation.Right,
                        deed
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
        deed = new Deed(320, 28, 200, 150,450,1000,1200, 1400);
        associateDeed(green, deed);
        tiles.add(
                new StandardProperty("Numbani Bus",
                        new Point2D(2585,1368),
                        new Point2D(2990,1147),
                        TileOrientation.Right,
                        deed
                )
        );
        deed = new Deed(200, 25);
        associateDeed(railroads, deed);
        tiles.add(
                new Railroad("Route 66 Payload",
                        new Point2D(2585,1612),
                        new Point2D(2990,1387),
                        TileOrientation.Right,
                        deed
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
        deed = new Deed(350, 35, 200, 175,500,1100,1300, 1500);
        associateDeed(blue, deed);
        tiles.add(
                new StandardProperty("Junkertown Throne",
                        new Point2D(2585,2090),
                        new Point2D(2990,1865),
                        TileOrientation.Right,
                        deed
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
        deed = new Deed(400, 50, 200, 200,600,1400,1700, 2000);
        associateDeed(blue, deed);
        tiles.add(
                new StandardProperty("Lunar Colony",
                        new Point2D(2585,2572),
                        new Point2D(2990,2349),
                        TileOrientation.Right,
                        deed
                )
        );

        deeds.addAll(utilities);
        deeds.addAll(railroads);
        deeds.addAll(brown);
        deeds.addAll(lightblue);
        deeds.addAll(pink);
        deeds.addAll(orange);
        deeds.addAll(red);
        deeds.addAll(yellow);
        deeds.addAll(green);
        deeds.addAll(blue);
    }

}
