package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTile;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTileTypes;
import im.admt.team11.PA3.Util.BoardBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;

import java.util.ArrayList;

public class GameBoard {

	public ObservableList<Tile> tiles;
	public ObservableList<Token> playerTokens;

	public GameBoard() {
		playerTokens = FXCollections.observableArrayList();

		tiles = BoardBuilder.buildTileList();
	}
}
