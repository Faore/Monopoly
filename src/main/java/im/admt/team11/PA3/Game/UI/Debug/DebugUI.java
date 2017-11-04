package im.admt.team11.PA3.Game.UI.Debug;

import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.MonopolyGame;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.util.Map;

public class DebugUI {

    public Label clickCoordinates;
    public Label tileEntity;

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
    }
}
