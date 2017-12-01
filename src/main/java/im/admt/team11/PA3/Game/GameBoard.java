package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Card;
import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Util.BoardBuilder;
import im.admt.team11.PA3.Util.CardBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameBoard {

	public ObservableList<Tile> tiles;
	public ObservableList<Deed> deeds;
	public ObservableList<Token> playerTokens;
	public ObservableList<Card> cards;

	public GameBoard(GameSettings gameSettings) throws Exception {
		playerTokens = FXCollections.observableArrayList();
		tiles = FXCollections.observableArrayList();
		deeds = FXCollections.observableArrayList();
		cards = FXCollections.observableArrayList();

		for(Player player : gameSettings.players) {
			playerTokens.add(player.token);
		}

		BoardBuilder.buildBoard(tiles, deeds);
		CardBuilder.buildChanceCard(cards);
		//CardBuilder.buildChestCard(cards);
		FXCollections.shuffle(cards);
	}

	public Card getCard(){
		Card card = cards.get(0);
		cards.remove(0);
		cards.add(card);
		return card;
	}
}
