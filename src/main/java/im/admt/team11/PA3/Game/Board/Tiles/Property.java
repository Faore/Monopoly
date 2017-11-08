package im.admt.team11.PA3.Game.Board.Tiles;

import im.admt.team11.PA3.Game.Board.Tile;
import javafx.geometry.Point2D;

abstract public class Property extends Tile {
	public Property(String name, Point2D firstBound, Point2D secondBound, TileOrientation orientation) {
	    super(name, firstBound, secondBound, orientation);
    }
}
