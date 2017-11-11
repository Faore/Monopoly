package im.admt.team11.PA3.Game.Board.Tiles;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Tile;
import javafx.geometry.Point2D;

abstract public class Property extends Tile {

	public final Deed deed;

	public Property(String name, Point2D firstBound, Point2D secondBound, TileOrientation orientation, Deed deed) throws Exception {
	    super(name, firstBound, secondBound, orientation);
	    this.deed = deed;
	    deed.attachToProperty(this);
    }
}
