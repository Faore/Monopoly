package im.admt.team11.PA3.Game.Board;

import javafx.geometry.Point2D;

public class Tile {

	public final String name;
	public final Point2D firstBound;
	public final Point2D secondBound;
	public final Point2D tokenSlot1;
	public final Point2D tokenSlot2;
	public final Point2D tokenSlot3;
	public final Point2D tokenSlot4;
	
	public Tile(String name, Point2D firstBound, Point2D secondBound, Point2D tokenSlot1, Point2D tokenSlot2, Point2D tokenSlot3, Point2D tokenSlot4) {
		this.name = name;
		//Tiles have coordinates. They are bound by the first and second bound (first: bottom left, second: top right)
		this.firstBound = firstBound;
		this.secondBound = secondBound;
		this.tokenSlot1 = tokenSlot1;
		this.tokenSlot2 = tokenSlot2;
		this.tokenSlot3 = tokenSlot3;
		this.tokenSlot4 = tokenSlot4;
	}
}
