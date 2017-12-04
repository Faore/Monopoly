package esof322.pa4.team11.Game.Board.Pieces;

import esof322.pa4.team11.Game.Board.Tile;
import esof322.pa4.team11.Game.Player;
import esof322.pa4.team11.Game.Util.TokenMap;
import javafx.scene.control.Button;

import java.util.HashMap;

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
