package im.admt.team11.PA3.Game.Board.Pieces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.HashMap;
import java.util.Map;

public class Token {

    public final TokenTypes tokenType;
    public final Button buttonElement;

    public Token(TokenTypes tokenType) {
        HashMap<TokenTypes, String> tokenMap = new HashMap<TokenTypes, String>();
        tokenMap.put(TokenTypes.Blue, "/BlueToken.png");
        tokenMap.put(TokenTypes.Red, "/RedToken.png");
        tokenMap.put(TokenTypes.Green, "GreenToken.png");
        tokenMap.put(TokenTypes.Yellow, "YellowToken.png");

        this.tokenType = tokenType;
        this.buttonElement = new Button();
        buttonElement.setStyle("-fx-graphic: url('" + tokenMap.get(tokenType) +"'); -fx-background-color: transparent;");
    }
}
