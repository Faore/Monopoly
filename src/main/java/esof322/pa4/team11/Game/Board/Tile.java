package esof322.pa4.team11.Game.Board;

import esof322.pa4.team11.Game.Board.Pieces.Token;
import esof322.pa4.team11.Game.Board.Tiles.TileOrientation;
import javafx.geometry.Point2D;

abstract public class Tile {

	public static final int tokenOffsetX = 62/2;
	public static final int tokenOffsetY = 100/2;

	public static final int buildingOffset = 48/2;


	public final String name;
	public final Point2D firstBound;
	public final Point2D secondBound;
	public Point2D[] tokenSlots;
	public Token[] tokensInSlots;
	public final TileOrientation orientation;
	
	public Tile(String name, Point2D firstBound, Point2D secondBound, TileOrientation orientation) {
		this.name = name;
		//Tiles have coordinates. They are bound by the first and second bound (first: bottom left, second: top right)
		this.firstBound = firstBound;
		this.secondBound = secondBound;
		this.orientation = orientation;
	}

	public int firstFreeTokenSlot() {
		for(int i = 0; i < tokensInSlots.length; i++) {
			if(tokensInSlots[i] == null) {
				return i;
			}
		}
		return -1;
	}
}
