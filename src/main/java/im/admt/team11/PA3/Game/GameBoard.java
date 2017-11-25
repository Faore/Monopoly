package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Util.BoardBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameBoard {

	public ObservableList<Tile> tiles;
	public ObservableList<Deed> deeds;
	public ObservableList<Token> playerTokens;

	public GameBoard(GameSettings gameSettings) throws Exception {
		playerTokens = FXCollections.observableArrayList();
		tiles = FXCollections.observableArrayList();
		deeds = FXCollections.observableArrayList();

		for(Player player : gameSettings.players) {
			playerTokens.add(player.token);
		}

		BoardBuilder.buildBoard(tiles, deeds);
	}
}
