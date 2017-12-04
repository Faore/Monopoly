package esof322.pa4.team11.Game;

import esof322.pa4.team11.Game.Board.Pieces.Token;
import esof322.pa4.team11.Game.Board.Tile;
import esof322.pa4.team11.Game.Util.BoardBuilder;
import esof322.pa4.team11.Game.Util.CardBuilder;
import esof322.pa4.team11.Game.Util.ThemedBoardBuilder;
import esof322.pa4.team11.Game.Board.Card.Card;
import esof322.pa4.team11.Game.Board.Card.Deed;
import esof322.pa4.team11.GameSettings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameBoard {

	public ObservableList<Tile> tiles;
	public ObservableList<Deed> deeds;
	public ObservableList<Token> playerTokens;
	public ObservableList<Card> chanceCards;
	public ObservableList<Card> chestCards;
	public Card chanceJailCard;
	public Card chestJailCard;

	public GameBoard(GameSettings gameSettings) throws Exception {
		playerTokens = FXCollections.observableArrayList();
		tiles = FXCollections.observableArrayList();
		deeds = FXCollections.observableArrayList();
		chanceCards = FXCollections.observableArrayList();
		chestCards = FXCollections.observableArrayList();

		for(Player player : gameSettings.players) {
			playerTokens.add(player.token);
		}

		CardBuilder.buildChanceCard(chanceCards);
		CardBuilder.buildChestCard(chestCards);
		FXCollections.shuffle(chanceCards);
		FXCollections.shuffle(chestCards);
	}

	public Card getChanceCard(){
		Card card = chanceCards.get(0);
		chanceCards.remove(card);
		if (card.getCardNum() != 16) {
			chanceCards.add(card);
		}else{
			chanceJailCard = card;
		}
		return card;
	}

	public Card getChestCard(){
		Card card = chestCards.get(0);
		chestCards.remove(card);
		if (card.getCardNum() != 16){
			chestCards.add(card);
		}else {
			chestJailCard = card;
		}
		return card;
	}

	public void replaceChanceJailCard(){
		chanceCards.add(chanceJailCard);
	}

	public void replaceChestJailCard(){
		chestCards.add(chestJailCard);
	}

	public int getLocation(Tile tile){
		return tiles.indexOf(tile);
	}
}
