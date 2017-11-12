package im.admt.team11.PA3.Game.Board.Pieces;

import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.MonopolyGame;
import im.admt.team11.PA3.Game.Player;
import im.admt.team11.PA3.Util.TokenMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.HashMap;
import java.util.Map;

public class Token {

    public final Player player;
    public final TokenTypes tokenType;
    public final Button buttonElement;
    public Tile currentLocation;

    public Token(TokenTypes tokenType, Player player) {
        HashMap<TokenTypes, String> tokenMap = TokenMap.getTokenMap();

        this.tokenType = tokenType;
        this.buttonElement = new Button();
        buttonElement.setStyle("-fx-graphic: url('" + tokenMap.get(tokenType) +"'); -fx-background-color: transparent;");
        this.player = player;
    }
}
