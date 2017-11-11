package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTile;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTileTypes;
import im.admt.team11.PA3.Util.BoardBuilder;
import javafx.geometry.Point2D;

import java.util.ArrayList;

public class GameBoard {

	public ArrayList<Tile> tiles;
	public ArrayList<Token> playerTokens;

	public GameBoard() {
		playerTokens = new ArrayList<Token>();
		tiles = BoardBuilder.buildTileList();
	}

	public Tile getTile(int location){ return tiles.get(location); }
}
