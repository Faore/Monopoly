package im.admt.team11.PA3.Game.Board.Pieces;

import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.HashMap;
import java.util.Map;

public class Token {

    public final TokenTypes tokenType;
    public final Button buttonElement;
    public Tile currentLocation;

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

    public void moveToTile(Tile tile) {
        int slot = tile.firstFreeTokenSlot();
        for (int i = 0; i < currentLocation.tokensInSlots.length; i++) {
            if(currentLocation.tokensInSlots[i] == this) {
                currentLocation.tokensInSlots[i] = null;
                break;
            }
        }
        currentLocation = tile;
        currentLocation.tokensInSlots[slot] = this;
        MonopolyGame.getInstance().gameWindowManager.setTokenLocation(this, currentLocation.tokenSlots[slot]);
    }
}
