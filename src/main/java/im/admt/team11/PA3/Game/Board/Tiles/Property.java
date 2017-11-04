package im.admt.team11.PA3.Game.Board.Tiles;

import im.admt.team11.PA3.Game.Board.Tile;
import javafx.geometry.Point2D;

public class Property extends Tile {
	public Property(String name, Point2D firstBound, Point2D secondBound, Point2D tokenSlot1, Point2D tokenSlot2, Point2D tokenSlot3, Point2D tokenSlot4, Point2D building1, Point2D building2, Point2D building3, Point2D building4) {
	    super(name, firstBound, secondBound, tokenSlot1, tokenSlot2, tokenSlot3, tokenSlot4);
    }
}
