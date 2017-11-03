package im.admt.team11.PA3.Game.Board;

import javafx.geometry.Point2D;

public class Tile {

	final String name;
	final Point2D firstBound;
	final Point2D secondBound;
	
	public Tile(String name, Point2D firstBound, Point2D secondBound) {
		this.name = name;
		//Tiles have coordinates. They are bound by the first and second bound (first: bottom left, second: top right)
		this.firstBound = firstBound;
		this.secondBound = secondBound;
	}
}
