package esof322.pa4.team11.Game.UI.Debug;

import esof322.pa4.team11.Game.Board.Pieces.Token;
import esof322.pa4.team11.Game.Board.Tile;
import esof322.pa4.team11.Game.MonopolyGame;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class DebugUI {

    public Label clickCoordinates;
    public Label tileEntity;
    public ListView tokenList;
    public ListView tileList;

    @FXML
    public void initialize() {
        MonopolyGame.getInstance().debugUI = this;

        MonopolyGame.getInstance().gameWindowManager.zoomGroup.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickCoordinates.setText("(" + String.format("%1$,.2f", event.getX()) + ", " + String.format("%1$,.2f", event.getY()) + ")");
                Tile tile = MonopolyGame.getInstance().gameWindowManager.tileAtEvent(event);
                tileEntity.setText(tile != null ? tile.name : "None");
            }
        });
        tokenList.setItems(MonopolyGame.getInstance().gameBoard.playerTokens);
        tokenList.setCellFactory(new Callback<ListView<Token>, ListCell<Token>>() {
            @Override
            public ListCell call(ListView<Token> p) {

                ListCell<Token> cell = new ListCell<Token>() {
                    @Override
                    protected void updateItem(Token t, boolean bln) {
                        super.updateItem(t, bln);
                        if(t != null) {
                            setText(t.tokenType.toString() + ": " + t.currentLocation.name);
                        }
                    }
                };

                return cell;
            }
        });
    }
}
