package im.admt.team11.PA3.Game.Board;

import im.admt.team11.PA3.Game.Board.Pieces.Token;
import javafx.geometry.Point2D;

public class Tile {

	public final String name;
	public final Point2D firstBound;
	public final Point2D secondBound;
	public final Point2D[] tokenSlots;
	public final Token[] tokensInSlots;
	
	public Tile(String name, Point2D firstBound, Point2D secondBound, Point2D[] tokenSlots) {
		this.name = name;
		//Tiles have coordinates. They are bound by the first and second bound (first: bottom left, second: top right)
		this.firstBound = firstBound;
		this.secondBound = secondBound;
		this.tokenSlots = tokenSlots;
		this.tokensInSlots = new Token[tokenSlots.length];
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
