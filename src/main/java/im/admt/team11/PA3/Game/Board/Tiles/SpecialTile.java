package im.admt.team11.PA3.Game.Board.Tiles;

import im.admt.team11.PA3.Game.Board.Tile;

import javafx.geometry.Point2D;

public class SpecialTile extends Tile {
	public final SpecialTileTypes type;
	public SpecialTile(String name, Point2D firstBound, Point2D secondBound, SpecialTileTypes type) {
		super(name, firstBound, secondBound);
		this.type = type;
	}
}
